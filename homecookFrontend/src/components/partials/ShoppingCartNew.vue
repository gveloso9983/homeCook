<template>
  <div class="cart">
    <div>
      <p v-show="!mapedCartData.length"><i>O carrinho está vazio!</i></p>
      <ul class="list-products-checkout">
        <li v-for="product in mapedCartData" :key="product['id']">
          <span class="nome-product-cart">{{ product.name }}</span>
          <p style="color: #847d77">
            {{ product.quantity }} x {{ product.price }}€
            <v-btn
            style="float: right"
              color="white"
              small
              depressed
              @click="removeCartProduct(product.cartId)"
            >
              <v-icon style="font-size: 18px; margin-top: -4px" color="#f75656">
                mdi-close-circle
              </v-icon>
            </v-btn>
          </p>
        </li>
      </ul>
      <v-divider></v-divider>
      <p class="subtotal-cart-position text-right">Subtotal: {{ sum }}€</p>
    </div>
    <div>
      <v-btn
        @click="goToCheckout"
        block
        class="button btn-confirm-color"
        :disabled="!mapedCartData.length"
        elevation="2"
      >
        Checkout
      </v-btn>
    </div>
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
    <p v-show="checkoutStatus">Checkout {{ checkoutStatus }}.</p>
  </div>
</template>

<script>
import Product from "../../service/product";
import Mixins from "../mixins/mixin";
import { mapState } from "vuex";

export default {
  mixins: [Mixins],
  computed: {
    ...mapState({
      checkoutStatus: (state) => state.cart.checkoutStatus,
    }),
  },

  data() {
    return {
      snackbar : false,
      text: 'Produto removido do carrinho!',
      timeout: 1000,
      mapedCartData: [],
      sum: 0,
      quant: 0,
      pri: 0,
    };
  },

  methods: {
    goToCheckout() {
      this.$router.push("/checkout");
    },
    listCartProducts() {
      Product.listCartProducts()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.mapedCartData = response.data.map((cart) => {

              return {
                name: cart.name,
                price: cart.price,
                quantity: cart.quantity,
                cartId: cart.id,
                idProd: cart.idProd,
              };
            });
            let l = this.mapedCartData.length;

            for (let i = 0; i <= l; i++) {
              this.quant = this.mapedCartData[i]["quantity"];
              this.pri = this.mapedCartData[i]["price"];
              this.sum += this.quant * this.pri;
            }

            return this.sum;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
          console.log(this.mapedCartData);
        });
    },
    removeCartProduct(id) {
      Product.removeCartProduct(id)
        .then((response) => {
          if (response.status == 400) {
            console.log("Deu merda");
            //this.data.apiErrors = error;
          } else {
            this.snackbar = true;
            console.log("Momma we made it!");
          }
        })
        .catch((error) => {
          //this.data.apiErrors = error;
          console.log(this.mapedCartData.id);
        });
    },
  },
  mounted() {
    this.listCartProducts();
    this.currentRole();
  },
};
</script>

<style scoped>
.cart {
  display: flex;
  flex-direction: column;
}

span {
  align-self: center;
  padding: 5% 0% 15% 0;
}

.btn {
  display: flex;
  margin: auto;
  justify-content: center;
}

.list-products-checkout {
  list-style-type: none;
}

.subtotal-cart-position {
  margin-top: 16px;
  letter-spacing: 3px;
  color: #a59d96;
  font-weight: bold;
}

.nome-product-cart {
  font-size: 15px;
  margin-left: -10px;
  font-weight: bold;
  color: #a59d96;
}
</style>