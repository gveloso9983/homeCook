<template>
  <v-container class="innerContainer" v-if="!data.load">
    <v-row class="inside">
      <v-col cols="12" md="5" sm="5" xs="12">
        <v-img
          :src="`${data.apiUrl}/images/` + data.imagesRetrieved[0]"
          :lazy-src="`${data.apiUrl}/images/` + data.imagesRetrieved[0]"
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
      </v-col>

      <v-col cols="12" md="7" sm="7" xs="12">
        <div>
          <h1 class="title-details">{{data.name}}</h1>
          <h2 class="price-details">{{data.price}} €</h2>
          <span class="price-details">{{data.weight}} kg</span>
        </div>

        <v-rating
          :value="data.rating"
          color="amber"
          dense
          size="20"
          readonly
          >2</v-rating
        >

        <v-row>
          <v-col v-for="n in data.imagesRetrieved" :key="n" class="d-flex child-flex" cols="4">
            <v-img
              :src="`${data.apiUrl}/images/` + n"
              :lazy-src="`${data.apiUrl}/images/` + n"
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
        </v-row>

        <!-- Only clients can add to cart -->
        <div v-if="role == 'ROLE_CLIENT' && data.onSale">
          <h4 class="qty-title">Quantidade</h4>
          <form @submit.prevent="submit">
            <v-btn
              class="btn-confirm-color"
              :disabled="data.minToDecrementQty"
              @click="actionMinusPlusBtn('decrement', 'quantity')"
              ><v-icon> mdi-minus </v-icon></v-btn
            >
            <span class="quantity-position">{{ data.quantity }}</span>
            <v-btn
              class="btn-confirm-color"
              @click="actionMinusPlusBtn('increment', 'quantity')"
              ><v-icon> mdi-plus </v-icon></v-btn
            >
            <v-btn block class="btn-add-to-cart btn-confirm-color" type="submit" @click="snackbar = true"
              >Adicionar</v-btn
            >
          </form>

          <v-snackbar
            color="#a59d96"
            v-model="snackbar"
            :timeout="timeout"
          >
            {{ text }}

            <template v-slot:action="{ attrs }">
              <v-btn
                color="white"
                text
                v-bind="attrs"
                @click="snackbar = false"
              >
                OK!
              </v-btn>
            </template>
          </v-snackbar>
        </div>
      </v-col>

      <v-col cols="12">
        <h3 class="description-title">Descrição</h3>
        <p class="description">
          {{data.description}}
        </p>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <h3 class="description-title">Ingredientes</h3>
      </v-col>
    </v-row>

    <v-row v-if="data.ingredients">
      <v-col v-for="ingredient in data.ingredients" :key="ingredient.name" class="d-flex child-flex" cols="4">
        <li>{{ ingredient.name }}</li>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <h3 class="description-title">Comentários</h3>
      </v-col>
    </v-row>

    <div v-if="data.comments">
      <v-row v-for="comment in data.comments" :key="comment.id">
        <v-col cols="12" md="1" sm="1" xs="12">
          <v-avatar>
            <img :src="comment.avatar" alt="avatar" />
          </v-avatar>
        </v-col>

        <v-col cols="12" md="8" sm="8" xs="12">
          <h5>{{ comment.client_name }}</h5>
          <span class="comments">{{ comment.comment }}</span>
        </v-col>

        <v-col cols="12" md="3" sm="3" xs="12">
          <v-rating
            :value="comment.score"
            color="amber"
            dense
            size="20"
            readonly
            >{{ comment.score }}</v-rating
          >
        </v-col>

        <v-col>
          <v-divider></v-divider>
        </v-col>
      </v-row>
    </div>
    <p v-if="data.comments && data.comments.length == 0" class="description">Sem comentários.</p>
  </v-container>
</template>

<script>



import Product from "../../service/product";
import Mixins from "../mixins/mixin";

export default {
  mixins: [Mixins],
  watch: {
    "data.quantity": function () {
      if (this.data.quantity == 1) this.data.minToDecrementQty = true;
      else this.data.minToDecrementQty = false;
    },
  },
  mounted() {
    (this.data.id = this.$route.params.id), this.getById();
    this.currentRole()
  },
  props: ["data"],

  data: () => ({
    snackbar: false,
    text: 'Produto adicionado ao carrinho!',
    timeout: 2000,
  }),

  methods: {
    getById() {
      this.data.loading = true;
      Product.getById(this.data.id)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else if (response.status == 404) {
            return this.$router.push('/404')
          } else {
            this.data.name = response.data.name
            this.data.price = response.data.price
            this.data.weight = response.data.weight
            this.data.rating = response.data.rating
            this.data.images = response.data.images
            this.data.description = response.data.description
            this.data.ingredients = JSON.parse(response.data.ingredients)
            this.data.comments = response.data.comments
            this.data.onSale = response.data.onSale

            // Generate an avatar per comment
            if (this.data.comments.length > 0) this.generateAvatarComments();

            this.getImages()
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        })
        .finally((response) => {
          this.data.loading = false;
        });
    },
    getImages() {
      this.data.imagesRetrieved.push(this.data.images[0])

      if (typeof this.data.images[1] !== 'undefined') this.data.imagesRetrieved.push(this.data.images[1])
      if (typeof this.data.images[2] !== 'undefined') this.data.imagesRetrieved.push(this.data.images[2])

      this.data.load = false;
    },
    generateAvatarComments() {
      this.data.comments.forEach(element => {
        element.avatar = 'https://via.placeholder.com/550/000000/FFFFFF/?text=' + element.client_name
      });
    },
    async submit() {
      this.processRequest();
    },
    processRequest() {
      Product.addCart(this.data.id, this.data.quantity)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
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

.quantity-position {
  padding: 16px;
}

.btn-add-to-cart {
  margin-top: 10px;
}
</style>