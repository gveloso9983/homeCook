<template>
  <v-container>
    <h2 align="center">Carrinho</h2>
    <v-divider></v-divider>
    <br />
    <div class="my-prods">
      <v-container>
        <v-row>
          <v-col cols="12" md="6" sm="6">
            <v-row v-for="product in mapedCartData" :key="product.id">
              <v-col cols="12" md="2" sm="2" xs="12">
                <v-avatar>
                  <img
                    :src="`${apiUrl}/images/${product.imageId}`"
                    alt="avatar"
                  />
                  <!-- <img src="https://cdn.vuetifyjs.com/images/cards/cooking.png" alt="avatar" /> -->
                </v-avatar>
              </v-col>

              <v-col cols="12" md="8" sm="8" xs="12">
                <h5>{{ product.name }}</h5>
                <p class="comments">
                  {{ product.price }} € x {{ product.quantity }}
                </p>
              </v-col>
            </v-row>
          </v-col>

          <v-col cols="12" md="6" sm="12">
            <v-card :loading="loading">
              <template slot="progress">
                <v-progress-linear
                  color="deep-purple"
                  height="10"
                  indeterminate
                ></v-progress-linear>
              </template>
              <v-card-title>Carrinho Totais</v-card-title>

              <v-card-text class="text-end">
                <div>Subtotal {{ sum }} €</div>
                <div>Portes 0 €</div>
                <div v-if="voucher">Cupão ({{ voucherName }}) 10 %</div>
                <v-divider></v-divider>
                <div>
                  <b>Total {{ voucher ? sum * 0.9 : sum }} €</b>
                </div>
              </v-card-text>
            </v-card>
            <br />

            <v-text-field
              v-model="voucherName"
              color="#a59d96"
              label="Cupão"
              outlined
            >
              <v-icon @click="applyVoucher" slot="append" color="#a59d96">
                mdi-arrow-collapse-right
              </v-icon>
            </v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </div>
    <v-col cols="12" md="12" sm="12" xs="12">
      <h3 align="center">Dados de Entrega</h3>
      <span v-if="mapedAddressData.length == 0" class="without-address"
        >Sem moradas registadas? Registe <a href="/account">AQUI</a>.</span
      >
      <v-divider></v-divider>
      <br />
      <v-row class="payment-methods">
        <v-col cols="12" sm="12">
          <validation-observer
            align-self="auto"
            ml-4
            id="observer"
            ref="observer"
          >
            <validation-provider
              v-slot="{ errors }"
              name="categoria"
              rules="required"
            >
              <v-select
                solo
                align="center"
                v-model="selected"
                :items="mapedAddressData"
                item-value="id"
                item-text="city"
                :error-messages="errors"
                label="Selecione Morada de Entrega"
                data-vv-name="select"
                required
              >
              </v-select>
            </validation-provider>
          </validation-observer>
        </v-col>
      </v-row>
    </v-col>

    <v-col>
      <h3 align="center">Métodos de pagamento</h3>
      <v-divider></v-divider>
      <br />
      <v-row class="payment-methods">
        <v-col cols="12" md="4" sm="6" xs="12">
          <v-card class="mx-auto" max-width="300" outlined>
            <v-list-item three-line>
              <v-list-item-content>
                <div class="overline mb-4"></div>
                <v-list-item-title class="headline mb-1">
                  PayPal
                </v-list-item-title>
                <v-list-item-subtitle>Pague já!</v-list-item-subtitle>
              </v-list-item-content>

              <v-list-item-avatar tile size="80">
                <v-icon size="80">mdi-credit-card</v-icon>
              </v-list-item-avatar>
            </v-list-item>

            <v-card-actions>
              <v-btn
                :disabled="selected == ''"
                outlined
                rounded
                text
                :loading="loading1"
                @click="processRequest('loading1')"
              >
                PAGAR
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="12" md="4" sm="6" xs="12">
          <v-card class="mx-auto" max-width="300" outlined>
            <v-list-item three-line>
              <v-list-item-content>
                <div class="overline mb-4"></div>
                <v-list-item-title class="headline mb-1">
                  MB Way
                </v-list-item-title>
                <v-list-item-subtitle
                  >Pague com o seu smartphone.</v-list-item-subtitle
                >
              </v-list-item-content>

              <v-list-item-avatar tile size="80">
                <v-icon size="80">mdi-credit-card</v-icon>
              </v-list-item-avatar>
            </v-list-item>

            <v-card-actions>
              <v-btn
                :disabled="selected == ''"
                outlined
                rounded
                text
                :loading="loading2"
                @click="processRequest('loading2')"
              >
                PAGAR
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="12" md="4" sm="6" xs="12">
          <v-card class="mx-auto" max-width="300" outlined>
            <v-list-item three-line>
              <v-list-item-content>
                <div class="overline mb-4"></div>
                <v-list-item-title class="headline mb-1">
                  Multibanco
                </v-list-item-title>
                <v-list-item-subtitle
                  >Gerar uma referência.</v-list-item-subtitle
                >
              </v-list-item-content>

              <v-list-item-avatar tile size="80">
                <v-icon size="80">mdi-credit-card</v-icon>
              </v-list-item-avatar>
            </v-list-item>

            <v-card-actions>
              <v-btn
                :disabled="selected == ''"
                outlined
                rounded
                text
                :loading="loading3"
                @click="processRequest('loading3')"
              >
                PAGAR
              </v-btn>

              <v-dialog v-model="dialog" hide-overlay persistent width="300">
                <v-card color="#a59d96" dark>
                  <v-card-text>
                    A processar pedido...
                    <v-progress-linear
                      indeterminate
                      color="white"
                      class="mb-0"
                    ></v-progress-linear>
                  </v-card-text>
                </v-card>
              </v-dialog>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-col>
  </v-container>
</template>

<script>
import { mapState } from "vuex";
import Invoice from "../../service/invoice";
import Product from "../../service/product";
import User from "../../service/user";

import Mixins from "../mixins/mixin";

Date.prototype.addDays = function (days) {
  var date = new Date(this.valueOf());
  date.setDate(date.getDate() + days);
  return date;
};

export default {
  mixins: [Mixins],
  props: ["data"],

  data() {
    return {
      dialog: false,
      voucher: false,
      voucherName: "",
      apiUrl: process.env.VUE_APP_JAVA_API_URL,
      selected: "",
      selectedAddressData: {},
      address: "",
      menu: false,
      date: null,
      loading: false,
      loading1: false,
      loading2: false,
      loading3: false,
      mapedAddressData: [],
      mapedCartData: [],
      sum: 0,
      quant: 0,
      pri: 0,
    };
  },

  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
    voucherName(val) {
      if (!val) this.voucher = false;
    },
  },

  computed: {
    ...mapState({
      checkoutStatus: (state) => state.cart.checkoutStatus,
    }),
  },

  methods: {
    save(date) {
      this.$refs.menu.save(date);
    },
    applyVoucher() {
      if (this.voucherName) this.voucher = true;
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
                imageId: cart.imageId,
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
          console.log(error);
        });
    },

    getAddresses() {
      User.getAddress()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.mapedAddressData = response.data.map((address) => {
              return {
                city:
                  address.city +
                  ", " +
                  address.street +
                  ", " +
                  address.postalCode,
                id: address.id,
              };
            });
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },

    processRequest(loadingType) {
      this[loadingType] = true;
      var date = new Date();
      this.date = date.addDays(5); // add 5 days

      Invoice.sendInvoice(this.selected, this.date)
        .then((response) => {
          if (response.status == 400) {
            console.log(response);
          } else {
            this.dialog = true;
            setTimeout(() => {
              this.$router.push({ name: "Home" });
            }, 2000);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.getAddresses();
    this.listCartProducts();
    this.currentRole();
  },
};
</script>

<style>
.comments,
.description {
  font-size: 12px;
}
.without-address {
  font-size: 12px;
  font-weight: bold;
}
</style>
