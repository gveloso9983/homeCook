<template>
  <div style="margin-top: 20px">
    <v-row v-if="data.length > 0">
      <v-col v-for="product in data" :key="product.id" cols="12" md="3" sm="4">
        <v-card>
          <a :href="`product/${product.id}`">
            <v-item-group>
              <v-item v-slot="{ toggle }">
                <v-card
                  class="d-flex align-center imgPersonalized"
                  dark
                  @click="toggle"
                >
                  <v-img
                    :src="`${apiUrl}/images/${product.id_image}`"
                    :lazy-src="`${apiUrl}/images/${product.id_image}`"
                    aspect-ratio="1"
                    class="lighten-2 imgPersonalized"
                    height="250"
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

          <v-card-title>
            <h2>
              {{ product.title }}
            </h2>
          </v-card-title>
          <v-card-text>
            <v-row align="center" class="mx-0">
              <v-rating
                :value="product.rating"
                color="amber"
                dense
                half-increments
                readonly
                size="14"
              ></v-rating>

              <div class="grey--text ml-4"> ({{ product.rating }}) </div>
            </v-row>

            <div class="my-3 subtitle-1">{{ product.price }}€</div>
            <p>
              {{ product.name.substring(0, 20) }}
              {{ product.name.length > 20 ? "..." : "" }}
            </p>
            <div>
              <!-- {{ product.description.substring(0, 50) }}
              {{ product.description.length > 50 ? "..." : "" }} -->

              <!-- {{ product.description.substring(0, 50) }}
              {{ product.description.length > 50 ? "..." : "" }}
              <p style="margin-bottom: 22px;" v-if="product.description.length < 40"></p> -->
            </div>
          </v-card-text>

          <v-divider class="mx-4"></v-divider>

          <v-card-actions>
            <v-btn
              block
              class="white--text btn-confirm-color"
              :to="`product/${product.id}`"
            >
              Ver Mais
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
    <h3 class="text-center" v-else>Sem produtos!</h3>
  </div>
</template>

<script>
import Pagination from "../../components/partials/Pagination.vue";

export default {
  components: {
    Pagination,
  },
  props: ["data"],
  data() {
    return {
      apiErrors: "",
      loading: false,
      apiUrl: process.env.VUE_APP_JAVA_API_URL
    };
  },
};
</script>