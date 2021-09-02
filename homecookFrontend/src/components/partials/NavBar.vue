<template>
  <nav>
    <v-navigation-drawer v-model="sidebar" app>
      <v-list>
        <v-list-item to="/listProducts">
          <v-list-item-action>
            <v-icon>mdi-cupcake</v-icon>
          </v-list-item-action>
          <v-list-item-content>Produtos</v-list-item-content>
        </v-list-item>

        <v-list-item to="/about">
          <v-list-item-action>
            <v-icon>mdi-information-variant</v-icon>
          </v-list-item-action>
          <v-list-item-content>Sobre Nós</v-list-item-content>
        </v-list-item>
      </v-list>

      <v-list-item>
        <v-list-item-action class="menu-mobile">
          <v-menu
            v-model="menuMobile"
            :close-on-content-click="false"
            :nudge-width="200"
            offset-x
          >
            <template v-slot:activator="{ on, attrs }">
              <v-btn v-bind="attrs" v-on="on">
                <v-icon>mdi-account</v-icon>
              </v-btn>
            </template>

            <v-card>
              <v-list v-if="isLogged">
                <v-list-item>
                  <v-list-item-avatar>
                    <img
                      :src="generateAvatar(user.firstName, user.lastName)"
                      :alt="user.firstName"
                    />
                  </v-list-item-avatar>

                  <v-list-item-content>
                    <v-list-item-title
                      >{{ user.firstName }}
                      {{ user.lastName }}</v-list-item-title
                    >
                    <v-list-item-subtitle>{{
                      user.email
                    }}</v-list-item-subtitle>
                  </v-list-item-content>

                  <v-list-item-action>
                    <v-btn icon @click="logout()">
                      <v-icon>mdi-logout-variant</v-icon>
                    </v-btn>
                  </v-list-item-action>
                </v-list-item>
              </v-list>

              <v-divider v-if="isLogged"></v-divider>

              <v-list v-if="isLogged">
                <v-list-item to="/account">
                  <v-list-item-title>Conta</v-list-item-title>
                </v-list-item>
              </v-list>

              <v-list v-if="isLogged && role == 'ROLE_BAKER'">
                <v-list-item :to="'/listProducts/' + user.id">
                  <v-list-item-title>Produtos</v-list-item-title>
                </v-list-item>
              </v-list>

              <v-list v-if="isLogged && role == 'ROLE_BAKER'">
                <v-list-item to="/orders">
                  <v-list-item-title>Encomendas</v-list-item-title>
                </v-list-item>
              </v-list>

              <v-list v-if="isLogged">
                <v-list-item to="/changePassword">
                  <v-list-item-title>Mudar Password</v-list-item-title>
                </v-list-item>
              </v-list>

              <v-list v-if="!isLogged">
                <v-list-item to="/login">
                  <v-icon>mdi-login</v-icon>
                  <v-list-item-title>Login</v-list-item-title>
                </v-list-item>
              </v-list>

              <v-list v-if="!isLogged">
                <v-list-item to="/register">
                  <v-icon>mdi-account-plus</v-icon>
                  <v-list-item-title>Criar Conta</v-list-item-title>
                </v-list-item>
              </v-list>
            </v-card>
          </v-menu>
        </v-list-item-action>
        <v-list-item-content>Conta</v-list-item-content>
      </v-list-item>

      <v-list-item
        v-if="isLogged && role == 'ROLE_CLIENT'"
        @click="openCart = !openCart"
      >
        <v-list-item-action>
          <v-icon>mdi-cart</v-icon>
        </v-list-item-action>
        <v-list-item-content>Carrinho</v-list-item-content>
      </v-list-item>

      <v-col align="center">
        <div>
          <v-text-field
              outlined
              dense
              hide-details="true"
              label="Pesquisar"
              placeholder="Bolo de Chocolate"
              prepend-inner-icon="mdi-magnify"
              @input="filterCakes($event)"

            ></v-text-field>
        </div>
      </v-col>
    </v-navigation-drawer>

    <v-app-bar class="custom-header">
      <span class="hidden-sm-and-up">
        <v-icon @click="sidebar = !sidebar">mdi-menu</v-icon>
      </span>
      <div style="display: flex; align-items: center; flex-grow: 1">
        <v-app-bar-title>
          <router-link
            class="title"
            to="/"
            tag="span"
            v-slot="{ href, navigate }"
            custom
          >
            <span class="title-home-page" :href="href" @click="navigate"
              >Home Cook</span
            >
          </router-link>
        </v-app-bar-title>
        <v-col align="center">
          <div class="search-box">
            <v-text-field
              outlined
              dense
              hide-details="true"
              label="Pesquisar"
              placeholder="Bolo de Chocolate"
              prepend-inner-icon="mdi-magnify"
              @input="filterCakes($event)"

            ></v-text-field>
          </div>
        </v-col>
      </div>
      <v-spacer></v-spacer>

      <v-toolbar-items class="hidden-xs-only">
        <v-btn depressed>
          <router-link
            class="colorFormat"
            to="/listProducts"
            v-slot="{ href, navigate }"
            custom
          >
            <a :href="href" @click="navigate">Produtos</a>
          </router-link>
        </v-btn>

        <v-btn depressed>
          <router-link
            class="colorFormat"
            to="/about"
            v-slot="{ href, navigate }"
            custom
          >
            <a :href="href" @click="navigate">Sobre Nós</a>
          </router-link>
        </v-btn>

        <v-menu
          v-model="menu"
          :close-on-content-click="false"
          :nudge-width="200"
          offset-x
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on">
              <v-icon>mdi-account</v-icon>
            </v-btn>
          </template>

          <v-card>
            <v-list v-if="isLogged">
              <v-list-item>
                <v-list-item-avatar>
                  <img
                    :src="generateAvatar(user.firstName, user.lastName)"
                    :alt="user.firstName"
                  />
                </v-list-item-avatar>

                <v-list-item-content>
                  <v-list-item-title
                    >{{ user.firstName }} {{ user.lastName }}</v-list-item-title
                  >
                  <v-list-item-subtitle>{{ user.email }}</v-list-item-subtitle>
                </v-list-item-content>

                <v-list-item-action>
                  <v-btn icon @click="logout()">
                    <v-icon>mdi-logout-variant</v-icon>
                  </v-btn>
                </v-list-item-action>
              </v-list-item>
            </v-list>

            <v-divider v-if="isLogged"></v-divider>

            <v-list v-if="isLogged">
              <v-list-item to="/account">
                <v-list-item-title>Conta</v-list-item-title>
              </v-list-item>
            </v-list>

            <v-list v-if="isLogged && role == 'ROLE_BAKER'">
              <v-list-item :to="'/listProducts/' + user.id">
                <v-list-item-title>Produtos</v-list-item-title>
              </v-list-item>
            </v-list>

            <v-list v-if="isLogged && role == 'ROLE_BAKER'">
              <v-list-item to="/orders">
                <v-list-item-title>Encomendas</v-list-item-title>
              </v-list-item>
            </v-list>

            <v-list v-if="isLogged">
              <v-list-item to="/changePassword">
                <v-list-item-title>Mudar Password</v-list-item-title>
              </v-list-item>
            </v-list>

            <v-list v-if="!isLogged">
              <v-list-item to="/login">
                <v-icon>mdi-login</v-icon>
                <v-list-item-title>Login</v-list-item-title>
              </v-list-item>
            </v-list>

            <v-list v-if="!isLogged">
              <v-list-item to="/register">
                <v-icon>mdi-account-plus</v-icon>
                <v-list-item-title>Criar Conta</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-card>
        </v-menu>
        <v-menu
          :close-on-content-click="false"
          :nudge-width="300"
          offset-x
          v-if="isLogged && role == 'ROLE_CLIENT'"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-btn v-bind="attrs" v-on="on">
              <v-icon>mdi-cart</v-icon>
            </v-btn>
          </template>

          <v-card>
            <v-list v-if="isLogged">
              <v-list-item>
                <v-list-item-content>
                  <v-list-item-title style="color: #a59d96;text-transform: uppercase;letter-spacing: 3px;"><b>Carrinho</b></v-list-item-title>
                  <v-list-item-subtitle style="color: #a59d96;">Produtos</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
            </v-list>
            <v-list>
              <v-list-item style="display: block;">
                <ShoppingCart />
              </v-list-item>
            </v-list>
          </v-card>
        </v-menu>
      </v-toolbar-items>
    </v-app-bar>
  </nav>
</template>

<script>
import ShoppingCart from "./ShoppingCartNew.vue";
import Mixins from "../mixins/mixin";

export default {
  name: "NavBar",

  components: {
    ShoppingCart,
  },

  mixins: [Mixins],
  data() {
    return {
      sidebar: false,
      search: "",
      openCart: false,
      menu: false,
      menuMobile: false,
    };
  },
  mounted() {
    this.isLoggedIn();
    this.currentRole();
    this.currentUser();
  },
  computed: {
    //place v-for in div with cake in filteredCakes

  },
  methods:{
    filterCakes(event){
      this.$router.push("/listProducts?filter="+event);
    }
  }
};
</script>

<style scoped>
.colorFormat {
  color: black;
}
.search-box {
  padding-left: 5%;
  width: 100%;
  display: flex;
}

.custom-header {
  background-color: #f7f7f7 !important;
}

.menu-mobile button {
  color: #757575;
  height: 0px !important;
  justify-content: end !important;
  min-width: 0px !important;
  padding: 0px !important;
}

.title {
  cursor: pointer;
  font-weight: 300;
}

.v-btn--is-elevated {
  box-shadow: 0px 0px 0px 0px !important;
}
/*
  .cart{
    z-index: 1
  } */

.title-home-page {
  font-family: "Grand Hotel", cursive !important;
  font-style: italic;
  font-size: 35px !important;
}
</style>