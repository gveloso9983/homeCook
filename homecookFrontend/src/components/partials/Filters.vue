<template>
  <div>
    <v-container fluid>
      <!-- Mobile -->
      <v-toolbar-items class="hidden-sm-and-up">
        <v-row justify="center">
          <v-dialog v-model="dialog" max-width="600px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                class="white--text btn-confirm-color"
                block
                v-bind="attrs"
                v-on="on"
              >
                <v-icon>mdi-filter</v-icon> Mostrar filtros
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="text-h5">Filtros</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col style="cursor: pointer" cols="12" md="1" sm="1">
                      <p @click="resetFilters" class="resertBtnFilter text-end">
                        Limpar
                      </p>
                    </v-col>

                    <!-- By Category -->
                    <v-col cols="12">
                      <v-select
                        v-model="value"
                        :items="items"
                        label="Categorias"
                        multiple
                        
                      >
                        <template v-slot:selection="{ item, index }">
                          <v-chip v-if="index === 0">
                            <span>{{ item }}</span>
                          </v-chip>
                          <span v-if="index === 1" class="grey--text caption">
                            (+{{ value.length - 1 }} others)
                          </span>
                        </template>
                      </v-select>
                    </v-col>

                    <!-- By Price -->
                    <v-col cols="12">
                      <v-card flat color="transparent">
                        <v-card-text style="padding:0px !important">
                          <v-row>
                            <v-col class="px-4">
                              <span>Preço</span>
                              <v-range-slider
                                v-model="range"
                                :max="max"
                                :min="min"
                                hide-details
                                color="#a59d96"
                                class="align-center"
                              >
                                <template v-slot:prepend>
                                  <v-text-field
                                    :value="`${range[0]}`"
                                    class="mt-0 pt-0"
                                    hide-details
                                    single-line
                                    type="number"
                                    style="width: 60px"
                                    @change="$set(range, 0, $event)"
                                  ></v-text-field>
                                </template>
                                <template v-slot:append>
                                  <v-text-field
                                    :value="range[1]"
                                    class="mt-0 pt-0"
                                    hide-details
                                    single-line
                                    type="number"
                                    style="width: 60px"
                                    @change="$set(range, 1, $event)"
                                  ></v-text-field>
                                </template>
                              </v-range-slider>
                            </v-col>
                          </v-row>
                        </v-card-text>
                      </v-card>
                    </v-col>

                    <!-- By Rating -->
                    <v-col
                      style="padding-top: 35px"
                      class="text-left"
                      cols="12"
                    >
                      <span>Rating</span>
                      <v-rating
                        v-model="rating"
                        color="amber"
                        dense
                        half-increments
                        size="25"
                        background-color="#a59d96"
                      ></v-rating>
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="dialog = false">
                  Fechar
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-row>
      </v-toolbar-items>

      <v-row class="hidden-xs-only" justify="end">
        <v-col style="cursor: pointer; margin-bottom: -35px;" cols="12" md="1" sm="1">
          <p
            @click="resetFilters"
            class="resertBtnFilter"
          >
            Limpar
          </p>
        </v-col>
      </v-row>

      <v-row class="hidden-xs-only">
        <!-- By Category -->
        <v-col cols="12" md="4" sm="4">
          <v-select v-model="value" :items="items" label="Categorias" multiple color="#a59d96">
            <template v-slot:selection="{ item, index }">
              <v-chip v-if="index === 0" color="#a59d96">
                <span>{{ item }}</span>
              </v-chip>
              <span v-if="index === 1" class="grey--text caption">
                (+{{ value.length - 1 }} others)
              </span>
            </template>
          </v-select>
        </v-col>

        <!-- By Price -->
        <v-col cols="12" md="5" sm="5">
          <v-card flat color="transparent">
            <v-card-text>
              <v-row>
                <v-col class="px-4" style="padding:6px 0px 12px 0px !important;">
                  <span style="float:left;margin: 9px 16px 16px 0;">Preço</span>
                  <v-range-slider
                    v-model="range"
                    :max="max"
                    :min="min"
                    hide-details
                    color="#a59d96"
                    class="align-center"
                  >
                    <template v-slot:prepend>
                      <v-text-field
                        :value="`${range[0]}`"
                        class="mt-0 pt-0"
                        hide-details
                        single-line
                        type="number"
                        style="width: 60px"
                        @change="$set(range, 0, $event)"
                      ></v-text-field>
                    </template>
                    <template v-slot:append>
                      <v-text-field
                        :value="range[1]"
                        class="mt-0 pt-0"
                        hide-details
                        single-line
                        type="number"
                        style="width: 60px"
                        @change="$set(range, 1, $event)"
                      ></v-text-field>
                    </template>
                  </v-range-slider>
                </v-col>
              </v-row>
            </v-card-text>
          </v-card>
        </v-col>

        <!-- By Rating -->
        
        <v-col 
          style="padding:17px 14px 12px 0px !important;"
          class="text-center"
          cols="12"
          md="3"
          sm="3"
          
        >
          <span style="float:left;margin: 12px 16px 16px 0;">Rating</span>
          <v-rating
            v-model="rating"
            color="amber"
            style="border-color:a59d96;float:left;margin-top: 7px;"
            dense
            half-increments
            size="25"
            background-color="#a59d96"
          ></v-rating>
        </v-col>
      </v-row>
    </v-container>

    <ListProducts :data="products" />

    <v-col v-if="products && products.length > 0" cols="12">
      <div class="text-center">
        <v-container>
          <v-row justify="center">
            <v-col cols="8">
              <v-container class="max-width">
                <v-pagination
                  v-model="page"
                  class="my-4"
                  :length="totalPages"
                  @input="handlePageChange"
                ></v-pagination>
              </v-container>
            </v-col>
          </v-row>
        </v-container>
      </div>
    </v-col>
  </div>
</template>

<script>
import Product from "../../service/product";
import ListProducts from "../../components/product/ListProducts.vue";
import Mixins from "../mixins/mixin";

export default {
  components: {
    ListProducts,
  },
  mixins: [Mixins],
  data() {
    return {
      page: 1,
      totalPages: 1,
      dialog: false,
      min: 0,
      max: 100,
      range: [0, 100],
      value: [],
      items: [
        "Vegan",
        "Bolos de Aniversário",
        "Tortas e Tartes",
        "Miniaturas",
        "Personalizável",
      ],
      rating: 0,
    };
  },
  created() {
    this.$data.filters.name =
      this.$route.query.filter != null ? this.$route.query.filter : "";
    this.processRequest();
  },
  mounted() {
    if (typeof this.$route.query.filter != "undefined")
      this.$router.push("/listProducts");
  },
  watch: {
    value: function () {
      this.$data.filters.categories = [];
      if (this.value.length > 0) {
        this.value.forEach((element) => {
          if (element == "Vegan") this.$data.filters.categories.push(1);
          if (element == "Bolos de Aniversário")
            this.$data.filters.categories.push(2);
          if (element == "Tortas e Tartes")
            this.$data.filters.categories.push(3);
          if (element == "Miniaturas") this.$data.filters.categories.push(4);
          if (element == "Personalizável")
            this.$data.filters.categories.push(5);
        });
      }

      this.processRequest();
    },
    "$route.query.filter": function () {
      this.$data.filters.name = this.$route.query.filter
        ? this.$route.query.filter
        : "";
      this.processRequest();
    },
    range: function () {
      this.$data.filters.prices = this.range[0] + "," + this.range[1];
      this.processRequest();
    },
    rating: function () {
      this.$data.filters.ratings = this.rating;
      this.processRequest();
    },
  },
  methods: {
    resetFilters() {
      this.range = [0, 100];
      this.rating = 0;
      this.value = [];
    },
    handlePageChange(value) {
      this.page = value;
      this.$data.filters.page = this.page;
      this.processRequest();
    },
    async processRequest() {
      await this.all();
      if (this.cakeData.status == 400) {
        this.data.apiErrors = error;
      } else {
        if (this.$data.products && this.$data.products.length) {
          if (this.page == 1) {
            this.totalPages =
              this.cakeData.data.total < this.$data.filters.limit
                ? 1
                : Math.ceil(
                    this.cakeData.data.total / this.$data.filters.limit
                  );
          }
        }
      }
    },
  },
};
</script>

<style scoped>
.resertBtnFilter {
  font-size: 12px;
  color: #a59d96;
  font-weight: bold;
}
</style>