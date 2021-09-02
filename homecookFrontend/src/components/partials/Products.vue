<template>
  <v-container>
    <h2 class="title-home">Últimos produtos</h2>
    <v-divider></v-divider>
    <br />
    <v-row v-if="data.products.length > 0">
      <v-col
        v-for="product in data.products"
        :key="product.id"
        class="d-flex child-flex"
        cols="6"
        md="3"
        sm="3"
      >
        <a :href="`product/${product.id}`">
          <v-item-group>
            <v-item v-slot="{ toggle }">
              <v-card
                class="d-flex align-center imgPersonalized"
                dark
                @click="toggle"
              >
                <v-img
                  :src="`${data.apiUrl}/images/${product.id_image}`"
                  :lazy-src="`${data.apiUrl}/images/${product.id_image}`"
                  aspect-ratio="1"
                  class="lighten-2 imgPersonalized"
                >
                  <template v-slot:placeholder>
                    <v-row
                      class="fill-height ma-0"
                      align="center"
                      justify="center"
                    >
                      <v-progress-circular
                        indeterminate
                        color="grey lighten-5"
                      ></v-progress-circular>
                    </v-row>
                  </template>
                </v-img>
              </v-card>
            </v-item>
          </v-item-group>
        </a>
      </v-col>
    </v-row>

    <v-row>
      <v-col align="center">
        <v-btn elevation="2" href="listProducts" class="btn-confirm-color"
          >Ver todos</v-btn
        >
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Product from "../../service/product";

export default {
  mounted() {
    this.getProducts();
  },
  data() {
    return {
      data: {
        products: [],
        apiUrl: process.env.VUE_APP_JAVA_API_URL
      },
    };
  },
  methods: {
    getProducts() {
      Product.getLast()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.products = response.data.productListElem
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
  },
};
</script>