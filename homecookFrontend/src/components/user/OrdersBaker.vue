<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <v-card>
          <!-- Orders To Do -->
          <v-list v-if="data.ordersToDo && data.ordersToDo.length > 0">
            <v-list-group prepend-icon="mdi-progress-clock" no-action>
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Encomendas por realizar</v-list-item-title>
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
                    :items="data.ordersToDo"
                    :search="data.search"
                    :footer-props="{ itemsPerPageText: 'Produtos por Página' }"
                  >
                    <template v-slot:item.address="{ item }">
                      <span>{{ item.address.city }}</span>
                    </template>

                    <template v-slot:item.actions="{ item }">
                      <v-icon small class="mr-2" @click="detailsOrder(item)">
                        mdi-eye
                      </v-icon>
                      <v-tooltip bottom>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            color="green"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            small
                            @click="updateToDone(item.id, 'true')"
                          >
                            mdi-check-circle
                          </v-icon>
                        </template>
                        <span>Marcar como realizado!</span>
                      </v-tooltip>
                    </template>
                    <template v-slot:top>
                      <v-dialog v-model="data.dialog" max-width="500px">
                        <v-card>
                          <v-card-title>
                            <span class="headline"
                              >Encomenda #{{ data.detailsItem.id }}</span
                            >
                          </v-card-title>

                          <v-card-text v-if="data.detailsItem">
                            <v-container>
                              <v-row>
                                <v-col cols="12" sm="12" md="12">
                                  <v-list-item>
                                    <v-list-item-content>
                                      <v-list-item-title>
                                        {{ data.detailsItem.productName }} -
                                        Qtd: {{ data.detailsItem.quantity }}
                                      </v-list-item-title>
                                      <v-list-item-subtitle>
                                        {{ data.detailsItem.address.street }},
                                        {{
                                          data.detailsItem.address.postalCode
                                        }}
                                        {{ data.detailsItem.address.city }}
                                      </v-list-item-subtitle>
                                      <v-divider></v-divider>
                                    </v-list-item-content>
                                  </v-list-item>
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

          <!-- Orders Done -->
          <v-list v-if="data.ordersDone && data.ordersDone.length > 0">
            <v-list-group prepend-icon="mdi-clock" no-action>
              <template v-slot:activator>
                <v-list-item-content>
                  <v-list-item-title>Encomendas realizadas</v-list-item-title>
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
                    :items="data.ordersDone"
                    :search="data.search"
                    :footer-props="{ itemsPerPageText: 'Produtos por Página' }"
                  >
                    <template v-slot:item.address="{ item }">
                      <span>{{ item.address.city }}</span>
                    </template>

                    <template v-slot:item.actions="{ item }">
                      <v-icon small class="mr-2" @click="detailsOrder(item)">
                        mdi-eye
                      </v-icon>
                      <v-tooltip bottom>
                        <template v-slot:activator="{ on, attrs }">
                          <v-icon
                            color="red"
                            dark
                            v-bind="attrs"
                            v-on="on"
                            small
                            @click="updateToDone(item.id, 'false')"
                          >
                            mdi-history
                          </v-icon>
                        </template>
                        <span>Marcar como por realizar!</span>
                      </v-tooltip>
                    </template>
                    <template v-slot:top>
                      <v-dialog v-model="data.dialog" max-width="500px">
                        <v-card>
                          <v-card-title>
                            <span class="headline"
                              >Encomenda #{{ data.detailsItem.id }}</span
                            >
                          </v-card-title>

                          <v-card-text v-if="data.detailsItem">
                            <v-container>
                              <v-row>
                                <v-col cols="12" sm="12" md="12">
                                  <v-list-item>
                                    <v-list-item-content>
                                      <v-list-item-title>
                                        {{ data.detailsItem.productName }} -
                                        Qtd: {{ data.detailsItem.quantity }}
                                      </v-list-item-title>
                                      <v-list-item-subtitle>
                                        {{ data.detailsItem.address.street }},
                                        {{
                                          data.detailsItem.address.postalCode
                                        }}
                                        {{ data.detailsItem.address.city }}
                                      </v-list-item-subtitle>
                                      <v-divider></v-divider>
                                    </v-list-item-content>
                                  </v-list-item>
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

          <v-snackbar v-model="data.snackbar" color="green">
            Produto marcado como realizado com sucesso!

            <template v-slot:action="{ attrs }">
              <v-btn text v-bind="attrs" @click="snackbar = false">
                <v-icon> mdi-close </v-icon>
              </v-btn>
            </template>
          </v-snackbar>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Product from "../../service/product";
import Invoice from "../../service/invoice";
import Mixins from "../mixins/mixin";

export default {
  mixins: [Mixins],
  mounted() {
    this.currentUser();
    this.currentRole();
    this.getOrdersToDo();
    this.getOrdersDone();
  },
  props: ["data"],
  methods: {
    updateToDone(id, status) {
      Invoice.updateToDone(id, status)
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
    detailsOrder(item) {
      this.data.detailsItem = item;
      this.data.dialog = true;
    },
    getOrdersToDo() {
      Invoice.getOrdersToDo()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.ordersToDo = response.data;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
    getOrdersDone() {
      Invoice.getOrdersDone()
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = error;
          } else {
            this.data.ordersDone = response.data;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
  },
};
</script>