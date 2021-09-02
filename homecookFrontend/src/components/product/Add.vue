<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <div class="innerLogin innerAuth" style="width: 100%">
          <h2 v-if="this.$route.params.id" class="loginTitle">
            Editar Produto
          </h2>
          <h2 v-else class="loginTitle">Novo Produto</h2>
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
                      name="Nome"
                      rules="required"
                    >
                      <v-text-field
                        solo
                        v-model="data.name"
                        :error-messages="errors"
                        label="Nome"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="Preço"
                      rules="required"
                    >
                      <v-text-field
                        solo
                        v-model="data.price"
                        :error-messages="errors"
                        label="Preço"
                        min="0"
                        required
                      >
                        <v-icon slot="append"> mdi-currency-eur </v-icon>
                      </v-text-field>
                    </validation-provider>
                  </v-col>

                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="Peso"
                      rules="required"
                    >
                      <v-text-field
                        solo
                        v-model="data.weight"
                        :error-messages="errors"
                        label="Peso"
                        min="0"
                        required
                      >
                        <v-icon slot="append"> mdi-weight-kilogram </v-icon>
                      </v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="12">
                    <v-text-field
                      solo
                      v-model="data.ingredient"
                      label="Ingredientes"
                      @keyup.enter="addIngredient(data.ingredient)"
                    >
                      <v-icon
                        slot="append"
                        @click="addIngredient(data.ingredient)"
                      >
                        mdi-arrow-collapse-right
                      </v-icon>
                    </v-text-field>

                    <p class="helper-msg-form">
                      Pressione <b>Enter</b> a cada ingrediente digitado.
                    </p>

                    <span
                      v-for="(ingredient, index) in data.ingredients"
                      :key="index"
                    >
                      <v-chip close @click:close="deleteIngredient(index)">{{
                        ingredient
                      }}</v-chip>
                    </span>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="12">
                    <validation-provider
                      v-slot="{ errors }"
                      name="category"
                      rules="required"
                    >
                      <v-select
                        solo
                        item-text="name"
                        item-value="id"
                        v-model="data.category"
                        :items="categoryItems"
                        :error-messages="errors"
                        label="Categoria"
                        data-vv-name="select"
                        required
                      ></v-select>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" md="12">
                    <validation-provider
                      v-slot="{ errors }"
                      name="description"
                      rules="required"
                    >
                      <v-textarea
                        solo
                        name="description"
                        label="Descrição"
                        v-model="data.description"
                        counter="500"
                        :error-messages="errors"
                      ></v-textarea>
                    </validation-provider>
                  </v-col>
                </v-row>
                <!-- <v-row v-if="data.imagesRetrieved.length > 0">
                  <v-col  v-for="n in data.imagesRetrieved" :key="n" class="d-flex child-flex" cols="2">
                    <v-img
                      :src="`http://localhost:8000/images/` + n"
                      :lazy-src="`http://localhost:8000/images/` + n"
                      aspect-ratio="1"
                      class="grey lighten-2 imgPersonalized"
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
                  </v-col>
                </v-row> -->
                <!-- <v-row>
                  <v-col cols="12" md="12">
                    <h2>Imagens</h2>
                    <h6>Máximo 3</h6>
                    <v-file-input
                      accept="image/*"
                      v-model="data.files"
                      placeholder="Carregar Imagens"
                      label="Imagens do Produto"
                      multiple
                      prepend-icon="mdi-plus"
                      counter="3"
                    >
                      <template v-slot:selection="{ text }">
                        <v-chip small label color="primary">
                          {{ text }}
                        </v-chip>
                      </template>
                    </v-file-input>
                  </v-col>
                </v-row> -->
                <vue-dropzone
                  ref="dropzone"
                  id="dropzone"
                  @vdropzone-max-files-exceeded="deleteExceed"
                  @vdropzone-files-added="submitFiles"
                  @vdropzone-file-added-manually="manualFile"
                  @vdropzone-removed-file="removeFile"
                  :options="dropzoneOptions"
                                    @vdropzone-error="errorFile"

                  name="files"
                  required
                ></vue-dropzone>

                <br />
                <div v-if="data.loading">
                  <Loading />
                </div>

                <v-btn
                  v-else
                  class="mr-4 btn btn-confirm-color"
                  type="submit"
                  block
                  :disabled="data.errorFileSize == false"
                >
                  Adicionar
                </v-btn>
              </v-container>
            </form>
          </validation-observer>
        </div>

        <v-snackbar v-model="data.snackbar" color="green">
          Adicionado com sucesso!

          <template v-slot:action="{ attrs }">
            <v-btn text v-bind="attrs" @click="data.snackbar = false">
              <v-icon> mdi-close </v-icon>
            </v-btn>
          </template>
        </v-snackbar>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Product from "../../service/product";
import StarRating from "vue-star-rating";
import Loading from "@/components/partials/Loading.vue";
import Mixins from "../../components/mixins/mixin";
import vue2Dropzone from "vue2-dropzone";
import "vue2-dropzone/dist/vue2Dropzone.min.css";
var path = require("path");

export default {
  components: {
    Loading,
    vueDropzone: vue2Dropzone,
  },
  created() {
    this.getCategories();
    this.currentUser();
    if(this.$route.params.id){
      this.data.id = this.$route.params.id;
      this.getById();
    }
  },
  data() {
    
    return {
      dropzoneOptions: {
        url: "#",
        autoProcessQueue: false,
        maxFilesize: 2, // MB
        maxFiles: 3,
        thumbnailWidth: 200,
        thumbnailHeight: 250,
        addRemoveLinks: true,
        dictRemoveFile: "Remover imagem",
        dictFileTooBig:"Ficheiro demasiado grande (Max: 2 MB)",
        acceptedFiles: "image/*",
        dictDefaultMessage: 'Insira pelo menos 1 imagem (Max: 3)',
      },
      data: {
        MAX_TOTAL_SIZE: 6*1024*1024,
        totalSize: 0,
        id: "",
        apiErrors: "",
        images: [],
        loading: false,
        rating: 0,
        quantity: 1,
        minToDecrementQty: true,
        load: false,
        imagesRetrieved: [],
        ingredients: [],
        files: [],
        manualFiles: [],
        errorFileSize: false,
        errorInput: false
      },
    };
  },
  mixins: [Mixins],
  methods: {
    errorFile(file, message, xhr){
      if(message == 'Ficheiro demasiado grande (Max: 2 MB)')
        this.data.errorInput = true;
      else
        this.data.errorInput = false;
        
    },
    manualFile(file) {
      this.data.manualFiles.push(file.name);
      this.data.errorFileSize = true; 
    },
    submitFiles(files) {
      const status = [];
      this.data.files = this.$refs.dropzone.getAcceptedFiles();

      Array.from(this.data.files).forEach(file => {       
        status.push(file.status)
        this.data.totalSize += file.size;
      });
      if(status.includes('error'))
        this.data.errorInput = true;  

      if(this.data.totalSize > this.data.MAX_TOTAL_SIZE) this.data.errorFileSize = false;
      else if(this.data.errorInput) this.data.errorFileSize = false;  
      else this.data.errorFileSize = true; 
      
 
    },
    removeFile(file, error, xhr) {
      this.data.manualFiles = this.data.manualFiles.filter(function (
        value,
        index,
        arr
      ) {
        if (value != file.name) return value;
      });
      this.data.files = this.data.files.filter(function (
        value,
        index,
        arr
      ) {
        if (value.name != file.name) return value;
      });

      if(this.data.files.length + this.data.manualFiles.length == 0) this.data.errorFileSize = false;
      else this.data.errorFileSize = true; 
    },
    deleteExceed(file) {
      this.$refs.dropzone.removeFile(file);
      this.data.files = this.$refs.dropzone.getAcceptedFiles();
      if(this.data.files.length + this.data.manualFiles.length == 0) this.data.errorFileSize = false;
      else this.data.errorFileSize = true;
    },
    getById() {
      this.data.loading = true;
      Product.getById(this.data.id)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else if (response.status == 404) {
            return this.$router.push("/404");
          } else {
            this.categoryItems.forEach((element) => {
            if (element.id == response.data.category_id)
              this.data.category = element.id
            });
            this.data.name = response.data.name
            this.data.price = response.data.price
            this.data.weight = response.data.weight
            this.data.rating = response.data.rating
            this.data.images = response.data.images
            this.data.description = response.data.description            
            JSON.parse(response.data.ingredients).forEach(element => {
              this.data.ingredients.push(element.name)
            });
            this.data.comments = response.data.comments;
            this.data.onSale = response.data.onSale;
          }

          this.getImages();
        })
        .catch((error) => {
          this.data.apiErrors = error;
        })
        .finally((response) => {
          this.data.loading = false;
        });
    },
    getImages() {
      this.data.images.forEach((element) => {
        Product.getEachImg(element)
          .then((val) => {
            var mockFile = {
              name: val.data.name,
              size: val.data.out,
              type: val.data.type,
            };

            this.$refs.dropzone.manuallyAddFile(
              mockFile,
              process.env.VUE_APP_JAVA_API_URL + "/images/" + element + "?" + val.data.name
            );
          })
          .catch((err) => {
            console.log(err);
          });
      });

      this.data.imagesRetrieved.push(this.data.images[0]);
      if (typeof this.data.images[1] !== "undefined")
        this.data.imagesRetrieved.push(this.data.images[1]);
      if (typeof this.data.images[2] !== "undefined")
        this.data.imagesRetrieved.push(this.data.images[2]);

      this.data.load = false;
    },
    addIngredient(content) {
      this.data.ingredients.push(content);
      this.data.ingredient = "";
    },
    deleteIngredient(index) {
      if (index > -1) this.data.ingredients.splice(index, 1);
    },
    async submit() {
      const result = await this.$refs.observer.validate();
      if (result) this.processRequest();
    },
    processRequest() {
      Product.addProduct(this.data)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            if(this.$route.params.id)
              this.$router.push("/product/"+ this.data.id);
            else
              this.$router.push("/listProducts/"+ this.user.id);

          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
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
</style>