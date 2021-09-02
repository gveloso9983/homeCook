<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <v-data-table
          :headers="headers"
          :items="products"
          no-results-text="Sem resultados."
          sort-by="category"
          class="elevation-1"
          :search="search"
          :loading="loading"
          loading-text="A carregar..."
          :footer-props="{ itemsPerPageText: 'Produtos por Página' }"
        >
          <template v-slot:top>
            <v-app-bar flat>
              <v-app-bar-title>As Minhas Receitas</v-app-bar-title>
              <v-divider class="mx-4" inset vertical></v-divider>

              <v-dialog v-model="dialog" max-width="500px">
                <template v-slot:activator="{ on, attrs }">
                  <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Procurar"
                    single-line
                    hide-details
                  ></v-text-field>
                  <v-spacer></v-spacer>
                  <v-btn class="mb-2 btn-confirm-color" @click="goToAdd">
                    Adicionar
                  </v-btn>
                </template>
                <v-card>
                  <v-card-title>
                    
                    <v-col cols="7" sm="7" md="7">
                      <span style="font-size:17px;padding-right:0">Breve Edição do Produto</span>
                    </v-col>
                    <v-col cols="5" sm="5" md="5">
                      <v-btn color="blue darken-1" text @click="editAllInfo">
                        Atualizar + info
                      </v-btn>
                    </v-col>
                   
                  </v-card-title>

                  <v-card-text>
                    <v-container>
                      <v-row>
                        <v-col cols="12" sm="6" md="6">
                          <v-text-field
                            v-model="editedItem.name"
                            label="Nome"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6">
                          <v-select
                            solo
                            item-text="name"
                            item-value="id"
                            v-model="editedItem.category"
                            :items="categoryItems"
                            label="Categoria"
                            data-vv-name="select"
                            required
                          ></v-select>
                        </v-col>
                        <v-col cols="12" sm="6" md="6">
                          <v-text-field
                            v-model="editedItem.weight"
                            label="Peso"
                          ></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="6">
                          <v-text-field
                            v-model="editedItem.price"
                            label="Preço"
                          ></v-text-field>
                        </v-col>
                      </v-row>
                    </v-container>
                  </v-card-text>

                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="close">
                      Cancelar
                    </v-btn>
                    <v-btn color="blue darken-1" text @click="save">
                      Confirmar
                    </v-btn>
                   
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <v-dialog v-model="dialogDelete" max-width="500px">
                <v-card>
                  <v-card-title class="headline"
                    >{{ productToDelete.action }}
                    {{ productToDelete.name }} ?</v-card-title
                  >
                  <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text @click="closeDelete"
                      >Cancelar</v-btn
                    >
                    <v-btn
                      color="blue darken-1"
                      text
                      @click="
                        deleteItemConfirm(
                          productToDelete.id,
                          productToDelete.action
                        )
                      "
                      >Confirmar</v-btn
                    >
                    <v-spacer></v-spacer>
                  </v-card-actions>
                </v-card>
              </v-dialog>
            </v-app-bar>

            <v-snackbar v-model="snackbar" color="green">
              Atualizado com sucesso!

              <template v-slot:action="{ attrs }">
                <v-btn text v-bind="attrs" @click="snackbar = false">
                  <v-icon> mdi-close </v-icon>
                </v-btn>
              </template>
            </v-snackbar>
          </template>
          <template class="text-center" v-slot:item.onSale="{ item }">
            <v-icon
              @click="deleteItem(item, 'Desativar')"
              color="green"
              v-if="item.onSale"
            >
              mdi-eye-settings
            </v-icon>
            <v-icon @click="deleteItem(item, 'Ativar')" color="red" v-else>
              mdi-eye-remove
            </v-icon>
          </template>
          <template v-slot:item.actions="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small class="mr-2" @click="goToDetails(item)">
              mdi-eye
            </v-icon>
          </template>

          <template v-slot:no-data>
            <p>Sem produtos.</p>
            <v-btn color="primary" @click="initialize"> Recarregar </v-btn>
          </template>
        </v-data-table>

      </v-col>
    </v-row>
    <p v-if="apiErrors" class="error-output">{{apiErrors}}</p>

  </v-container>
</template>
<script>
import Baker from "../../service/baker";
import Product from "../../service/product";
import Mixins from "../../components/mixins/mixin";

export default {
  mixins: [Mixins],
  data: () => ({
    snackbar: false,
    apiErrors: '',
    dialog: false,
    dialogDelete: false,
    productToDelete: { id: "", name: "", action: "" },
    search: "",
    loading: true,
    imagesRetrieved: [],
    headers: [
      {
        text: "Nome",
        align: "start",
        value: "name",
      },
      { text: "Categoria", value: "category.name" },
      { text: "Peso (kg)", value: "weight" },
      { text: "Preço (€)", value: "price" },
      { text: "Visível", value: "onSale" },
      { text: "Ações", value: "actions", sortable: false },
    ],
    products: [],
    editedIndex: -1,
    editedItem: {
      name: "",
      weight: 0,
      price: 0,
      category: "",
      onSale: "",
    },
    defaultItem: {
      name: "",
      category: "",
      weight: 0,
      price: 0,
      onSale: 0,
    },
  }),

  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },
  created() {
    this.initialize();
    this.getCategories();
  },
  methods: {
    initialize() {
      Baker.getProducts()
        .then((response) => {
          if (response.status == 400) {
            this.apiErrors = error;
          } else {
            this.products = response.data;
            this.loading = false;
          }
        })
        .catch((error) => {
          this.apiErrors = error;
        });
    },
    goToAdd() {
      this.$router.push("/product/add");
    },

    goToDetails(item) {
      this.$router.push("/product/" + item.id);
    },

    editItem(item) {
      this.editedIndex = this.products.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item, action) {
      this.editedIndex = this.products.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
      this.productToDelete = item;
      this.productToDelete.action = action;
    },

    deleteItemConfirm(id, action) {
      Baker.deleteProduct(id, action)
        .then((response) => {
          if (response.status == 400) {
            this.apiErrors = error;
          } else {
            //this.products.splice(this.editedIndex, 1);
            this.snackbar = true;
            this.products = [];
            this.initialize();
            this.closeDelete();
          }
        })
        .catch((error) => {
          this.apiErrors = error;
        });
    },
    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      // Find and update category
      this.categoryItems.forEach((element) => {
        if (element.id == this.editedItem.category)
          this.editedItem.category = {
            id: element.id,
            name: element.name,
          };
      });
      Object.assign(this.products[this.editedIndex], this.editedItem);
      
      
      const item = {
        name : this.editedItem.name,
        weight : this.editedItem.weight,
        catId :  this.editedItem.category.id,
        price: this.editedItem.price,
        prodId: this.editedItem.id,
      }

      console.log(item)

      Product.parcialEdit(item).then(response => {
        if (response.status == 400) {
            this.apiErrors = response.data;
        } 
        this.close();
      }).catch(error => {
          this.apiErrors = error;
      }).finally(response => {
          this.loading = false;
      })

    },

    editAllInfo(){
      this.$router.push("/editProduct/"+ this.editedItem.id);
    }
  },
};
</script>