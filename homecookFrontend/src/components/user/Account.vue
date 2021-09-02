<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <v-card>
          <v-toolbar dark>
            <v-toolbar-title>
              Dados Pessoais
              <v-icon @click="goToEdit" slot="append">
                mdi-pencil
              </v-icon></v-toolbar-title
            >
          </v-toolbar>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-account-box</v-icon>
            </v-list-item-action>
            <v-list-item-content
              >{{ user.firstName }} {{ user.lastName }}
            </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-human-child</v-icon>
            </v-list-item-action>
            <v-list-item-content> {{ user.birthDate }} </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-email</v-icon>
            </v-list-item-action>
            <v-list-item-content> {{ user.email }} </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-cellphone</v-icon>
            </v-list-item-action>
            <v-list-item-content> {{ user.phoneNumber }} </v-list-item-content>
          </v-list-item>

          <v-list-item v-if="role == 'ROLE_BAKER'">
            <v-list-item-action>
              <v-icon>mdi-cupcake</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <a :href="'/listProducts/' + user.id">As minhas receitas</a>
            </v-list-item-content>
          </v-list-item>

          <v-list
            v-if="
              role == 'ROLE_CLIENT' && data.invoices && data.invoices.length > 0
            "
          >
            <v-list-group prepend-icon="mdi-cart-plus" no-action>
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Encomendas</v-list-item-title>
                </v-list-item-content>
              </template>

              <v-list-item>
                <v-list-item-content>
                  <v-card-title>
                    <v-text-field
                      v-model="data.search"
                      append-icon="mdi-magnify"
                      label="Procurar"
                      single-line
                      hide-details
                    ></v-text-field>
                  </v-card-title>
                  <v-data-table
                    loading-text="A carregar..."
                    :headers="data.headers"
                    no-results-text="Sem resultados."
                    :items="data.invoices"
                    :search="data.search"
                    :footer-props="{ itemsPerPageText: 'Produtos por Página' }"
                  >
                    <template v-slot:item.actions="{ item }">
                      <v-icon small class="mr-2" @click="detailsInvoice(item)">
                        mdi-eye
                      </v-icon>
                    </template>
                    <template v-slot:top>
                      <v-dialog v-model="data.dialog" max-width="500px">
                        <v-card>
                          <v-card-title>
                            <span class="headline"
                              >Fatura #{{ data.detailsItem.id }}</span
                            >
                          </v-card-title>

                          <v-card-text>
                            <v-container>
                              <v-row>
                                <v-col cols="12" sm="12" md="12">
                                  <v-list-item
                                    v-for="item in data.detailsItem.items"
                                    :key="item.id"
                                  >
                                    <v-list-item-content>
                                      <v-list-item-title>
                                        <v-icon v-if="item.done" color="green"
                                          >mdi-check-circle</v-icon
                                        >
                                        <v-icon v-if="!item.done" color="yellow"
                                          >mdi-progress-check</v-icon
                                        >
                                        {{
                                          item.productName
                                        }}</v-list-item-title
                                      >
                                      <v-list-item-subtitle
                                        >Qtd: {{ item.quantity }} -
                                        {{ item.price }}
                                        €</v-list-item-subtitle
                                      >
                                      <v-divider></v-divider>
                                    </v-list-item-content>
                                  </v-list-item>

                                  <div style="float: right; font-size: 10px">
                                    Pronto
                                    <v-icon color="green"
                                      >mdi-check-circle</v-icon
                                    >
                                    Em progresso
                                    <v-icon color="yellow"
                                      >mdi-progress-check</v-icon
                                    >
                                  </div>
                                </v-col>
                              </v-row>
                            </v-container>
                          </v-card-text>
                        </v-card>
                      </v-dialog>
                    </template>
                  </v-data-table>
                </v-list-item-content>
              </v-list-item>
            </v-list-group>
          </v-list>
        </v-card>
      </v-col>
    </v-row>

    <v-row class="inside" v-if="role == 'ROLE_CLIENT'">
      <v-col cols="12" md="12" sm="12" xs="12">
        <v-card>
          <v-toolbar dark>
            <v-toolbar-title>
              Moradas Registadas
              <v-icon @click="goToAddAddress" slot="append"> mdi-plus </v-icon>
            </v-toolbar-title>
            <!-- Open Modal Add -->
            <v-dialog v-model="dialog" max-width="500px">
              <template v-slot:activator="{ on, attrs }"> </template>
              <v-card>
                <v-card-title>
                  <span class="headline">Nova Morada</span>
                </v-card-title>

                <v-card-text>
                  <validation-observer
                    align-self="auto"
                    ml-4
                    id="observer"
                    ref="observer"
                    v-slot="{ invalid }"
                  >
                    <form @submit.prevent="submit">
                      <v-container>
                        <v-row>
                          <v-col cols="12" sm="12">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Rua"
                              rules="required"
                            >
                              <v-text-field
                                solo
                                v-model="data.street"
                                :error-messages="errors"
                                label="Rua"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                        </v-row>

                        <v-row>
                          <v-col cols="12" sm="6">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Codigo Postal"
                              rules="required|max:8"
                            >
                              <v-text-field
                                solo
                                v-model="data.postalCode"
                                :counter="8"
                                :error-messages="errors"
                                label="Codigo Postal"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                          <v-col cols="12" sm="6">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Cidade"
                              rules="required"
                            >
                              <v-text-field
                                solo
                                v-model="data.city"
                                :error-messages="errors"
                                label="Cidade"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                        </v-row>

                        <p v-if="data.apiErrors" class="error-output">
                          {{ data.apiErrors }}
                        </p>
                      </v-container>
                    </form>
                  </validation-observer>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="close">
                    Cancelar
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="saveNewAddress">
                    Adicionar
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <!-- Close Modal Add -->

            <!-- Open Modal Edit -->
            <v-dialog v-model="dialogEdit" max-width="500px">
              <template v-slot:activator="{ on, attrs }"> </template>
              <v-card>
                <v-card-title>
                  <span class="headline"
                    >Editar Morada {{ editedAddress.id }}</span
                  >
                </v-card-title>

                <v-card-text>
                  <validation-observer
                    align-self="auto"
                    ml-4
                    id="observer"
                    ref="observer"
                    v-slot="{ invalid }"
                  >
                    <form @submit.prevent="submit">
                      <v-container>
                        <v-row>
                          <v-col cols="12" sm="12">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Rua"
                              rules="required"
                            >
                              <v-text-field
                                solo
                                v-model="editedAddress.street"
                                :error-messages="errors"
                                label="Rua"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                        </v-row>

                        <v-row>
                          <v-col cols="12" sm="6">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Codigo Postal"
                              rules="required|max:8"
                            >
                              <v-text-field
                                solo
                                v-model="editedAddress.postalCode"
                                :counter="8"
                                :error-messages="errors"
                                label="Codigo Postal"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                          <v-col cols="12" sm="6">
                            <validation-provider
                              v-slot="{ errors }"
                              name="Cidade"
                              rules="required"
                            >
                              <v-text-field
                                solo
                                v-model="editedAddress.city"
                                :error-messages="errors"
                                label="Cidade"
                                required
                              ></v-text-field>
                            </validation-provider>
                          </v-col>
                        </v-row>

                        <p v-if="data.apiErrors" class="error-output">
                          {{ data.apiErrors }}
                        </p>
                      </v-container>
                    </form>
                  </validation-observer>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="close">
                    Cancelar
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="editAddress">
                    Atualizar
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
            <!-- Close Modal Add -->
          </v-toolbar>

          <div v-if="addressData.length > 0">
            <v-list-item v-for="address in addressData" :key="address['id']">
              <v-list-item-action>
                <v-icon>mdi-compass</v-icon>
              </v-list-item-action>
              <v-list-item-content>
                {{ address.city }}, {{ address.street }},
                {{ address.postalCode }}
              </v-list-item-content>

              <v-icon small class="mr-2" @click="editItem(address)">
                mdi-pencil
              </v-icon>

              <v-icon small class="mr-2" @click="deleteAddress(address)">
                mdi-delete
              </v-icon>
            </v-list-item>
          </div>
          <p v-else class="text-center">Sem moradas adicionadas.</p>
        </v-card>

        <v-dialog v-model="dialogDelete" max-width="500px">
          <v-card>
            <v-card-title class="headline"
              >Remover {{ addressToDelete.postalCode }}?</v-card-title
            >
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="closeDelete"
                >Cancelar</v-btn
              >
              <v-btn
                color="blue darken-1"
                text
                @click="deleteItemConfirm(addressToDelete.id)"
                >Confirmar</v-btn
              >
              <v-spacer></v-spacer>
            </v-card-actions>
          </v-card>
        </v-dialog>

        <v-snackbar v-model="snackbar" color="green">
          Realizado com sucesso!

          <template v-slot:action="{ attrs }">
            <v-btn text v-bind="attrs" @click="snackbar = false">
              <v-icon> mdi-close </v-icon>
            </v-btn>
          </template>
        </v-snackbar>
      </v-col>
    </v-row>

    <v-sheet v-if="role == 'ROLE_CLIENT'" class="mx-auto">
      <h3 class="purchased-products">Produtos Comprados</h3>
      <p class="helper-msg">
        Para <b>adicionar</b> comentários selecione o produto desejado.
      </p>
      <v-slide-group
        center-active
        v-model="data.productSelected"
        class="pa-4"
        show-arrows
      >
        <v-slide-item
          v-for="product in data.products"
          :key="product.id"
          v-slot="{ toggle }"
        >
          <v-card
            class="ma-4 remove-shadow"
            height="200"
            width="160"
            @click="toggle"
          >
            <v-img
              :src="`${data.apiUrl}/images/${product.images[0]}`"
              :lazy-src="`${data.apiUrl}/images/${product.images[0]}`"
              aspect-ratio="1"
              class="lighten-2 imgPersonalized"
            >
              <template v-slot:placeholder>
                <v-row class="fill-height ma-0" align="center" justify="center">
                  <v-progress-circular
                    indeterminate
                    color="grey lighten-5"
                  ></v-progress-circular>
                </v-row>
              </template>
            </v-img>
            <p class="text-center helper-msg">{{ product.name }}</p>
          </v-card>
        </v-slide-item>
      </v-slide-group>

      <v-expand-transition>
        <v-sheet v-if="data.productSelected != null" height="200" tile>
          <h5 class="name-product-comment text-center">
            {{ data.products[data.productSelected].name }}
          </h5>
          <v-rating
            v-model="data.rating"
            color="amber"
            dense
            half-increments
            class="text-center"
            size="20"
            >{{ data.rating }}</v-rating
          >
          <v-row cols="12" md="12" sm="12" xs="12">
            <v-col>
              <validation-observer
                align-self="auto"
                ml-4
                id="observer"
                ref="observer"
                v-slot="{ invalid }"
              >
                <form @submit.prevent="submit">
                  <validation-provider
                    v-slot="{ errors }"
                    name="comment"
                    rules="required"
                  >
                    <v-textarea
                      solo
                      name="comment"
                      label="Comentário"
                      v-model="data.comment"
                      counter="500"
                      rows="3"
                      :error-messages="errors"
                    ></v-textarea>
                  </validation-provider>

                  <div v-if="data.loading">
                    <Loading />
                  </div>

                  <v-btn
                    v-else
                    class="mr-4 btn"
                    type="submit"
                    block
                    :disabled="invalid"
                  >
                    Comentar
                  </v-btn>
                </form>
              </validation-observer>

              <v-snackbar v-model="data.snackbar" color="green">
                Comentário adicionado com sucesso!

                <template v-slot:action="{ attrs }">
                  <v-btn text v-bind="attrs" @click="data.snackbar = false">
                    <v-icon> mdi-close </v-icon>
                  </v-btn>
                </template>
              </v-snackbar>
            </v-col>
          </v-row>
        </v-sheet>
      </v-expand-transition>
    </v-sheet>
  </v-container>
</template>

<script>
import Product from "../../service/product";
import Invoice from "../../service/invoice";
import User from "../../service/user";
import Mixins from "../mixins/mixin";

export default {
  mixins: [Mixins],
  data() {
    return {
      dialogDelete: false,
      editedIndex: "",
      snackbar: false,
      dialog: false,
      dialogEdit: false,
      addressData: [],
      addressToDelete: "",
      addressDeletedIndex: "",
      editedAddress: {
        id: "",
        street: "",
        city: "",
        postalCode: "",
      },
    };
  },
  mounted() {
    this.currentUser();
    this.currentRole();
    this.getInvoices();
    this.getAddresses();
    this.getProducts();
  },
  props: ["data"],
  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    },
  },
  methods: {
    deleteItemConfirm() {
      User.deleteAddress(this.addressToDelete.id)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.dialogDelete = false;
            this.snackbar = true;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    deleteAddress(item) {
      this.dialogDelete = true;
      this.addressToDelete = item;
    },
    async saveNewAddress() {
      const result = await this.$refs.observer.validate();
      if (result) this.addNewAddress();
    },
    editAddress() {
      User.editAddress(this.editedAddress)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.dialogEdit = false;
            this.snackbar = true;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    addNewAddress() {
      User.addAddress(this.data)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.snackbar = true;
            this.dialog = false;
            this.data.address = "";
            this.data.street = "";
            this.data.city = "";
            this.data.postalCode = "";
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    detailsInvoice(item) {
      Invoice.getInvoiceById(item.id)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.detailsItem = response.data;
            this.data.dialog = true;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    getProducts() {
      Invoice.getProducts()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.products = response.data;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    getInvoices() {
      Invoice.getInvoices()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.invoices = response.data;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    getAddresses() {
      User.getAddress()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.addressData = response.data;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    goToEdit() {
      this.$router.push("account/edit");
    },

    editItem(item) {
      this.editedIndex = item.id;
      this.editedAddress = item;
      this.dialogEdit = true;
    },

    goToEditAddress(adid) {
      this.getCurrentAddress(adid).then((response) => {
        if (response.status == 400) {
          this.data.apiErrors = error;
        } else {
          this.currentAddressData = response.data;
          console.log("Current Address Data " + this.currentAddressData);
        }
      });
      this.$router.push("account/address/edit");
    },
    goToAddAddress() {
      this.dialog = true;
      // this.$router.push("account/address/add");
    },
    async submit() {
      const result = await this.$refs.observer.validate();
      if (result) this.processRequest();
    },
    processRequest() {
      this.data.productId = this.data.products[this.data.productSelected].id;
      Product.addComment(this.data)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.snackbar = true;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
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
    },

    save() {
      // Find and update category
      this.categoryItems.forEach((element) => {
        if (element.id == this.editedItem.category)
          this.editedItem.category = {
            id: element.category,
            name: element.name,
          };
      });

      Object.assign(this.products[this.editedIndex], this.editedItem);
      this.close();
    },
  },
};
</script>

<style scoped>
.price-details {
  font-weight: 200;
  letter-spacing: 2px;
}

.price-details {
  font-weight: 100;
}

.qty-title {
  padding-top: 10px;
  font-weight: 300;
}

.description-title {
  letter-spacing: 2px;
  text-transform: uppercase;
}

.comments,
.description {
  font-size: 12px;
}

.remove-shadow {
  box-shadow: 0px 0px 0px 0px rgb(255 255 255 / 20%),
    0px 0px 0px 0px rgb(0 0 0 / 14%), 0px 0px 0px 0px rgb(0 0 0 / 12%) !important;
}

.purchased-products {
  margin-top: 20px;
}

.name-product-comment {
  letter-spacing: 1px;
  text-transform: uppercase;
}
</style>