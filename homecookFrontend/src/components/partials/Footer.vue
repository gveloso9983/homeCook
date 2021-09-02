<template>
  <v-footer padless>
    <v-row class="text-center" style="margin-top: 10px;">
      <v-col cols="12" sm="4">
        <v-icon>mdi-swap-horizontal-circle-outline</v-icon> Devoluções
        <p class="footer-color" style="font-size: 12px">Não são permitidas.</p>
      </v-col>

      <v-col cols="12" sm="4">
        <v-icon>mdi-google-maps</v-icon> Entregas
        <p class="footer-color" style="font-size: 12px">
          Portugal continental e ilhas.
        </p>
      </v-col>

      <v-col cols="12" sm="4">
        <v-icon>mdi-at</v-icon> Email
        <p class="footer-color" style="font-size: 12px">geral@homecook.pt</p>
      </v-col>
    </v-row>

    <v-col class="text-center" cols="12">
      <v-card flat tile class="custom-footer lighten-1 black--text text-center">
        <v-card-text>
          <v-btn
            v-for="icon in icons"
            :key="icon"
            class="mx-4 black--text"
            icon
          >
            <v-icon size="24px">
              {{ icon }}
            </v-icon>
          </v-btn>
        </v-card-text>

        <v-card-text class="black--text pt-0 footer-color">
          Sejam bem-vindos ao website HomeCook! <br />
          Aqui podem desfrutar das melhores iguarias caseiras a preços
          imbatíveis. O website complenta os seus clientes com uma doçaria
          variada, desde bolos de aniversário, miniaturas e bolos
          personalizáveis.
        </v-card-text>

        <v-row class="text-left">
          <v-col cols="2"></v-col>
          <v-col class="footer-color" cols="12" md="4" sm="4">
            <b>Minha Conta</b>
            <li class="li-footer">
              <router-link
                class="footer-color"
                to="/account"
                v-slot="{ href, navigate }"
                custom
              >
                <a :href="href" @click="navigate">Perfil</a>
              </router-link>
            </li>
            <li class="li-footer">
              <router-link
                class="footer-color"
                to="#"
                v-slot="{ href, navigate }"
                custom
              >
                <a href="/about" @click="navigate">Privacidade</a>
              </router-link>
            </li>
          </v-col>

          <v-col cols="12" md="4" sm="4">
            <b class="footer-color">Política de Privacidade e de Cookies</b>
            <li class="li-footer">
              <router-link
                class="footer-color"
                to="/about"
                v-slot="{ href, navigate }"
                custom
              >
                <a href="/about" @click="navigate">Termos e Condições</a>
              </router-link>
            </li>
            <li class="li-footer">
              <router-link
                class="footer-color"
                to="/about"
                v-slot="{ href, navigate }"
                custom
              >
                <a href="/about" @click="navigate">Cookies</a>
              </router-link>
            </li>
          </v-col>
        </v-row>

        <v-divider></v-divider>

        <v-card-text class="footer-color">
          © {{ new Date().getFullYear() }} — HomeCook Online - Todos os direitos
          reservados.
        </v-card-text>
      </v-card>
    </v-col>
  </v-footer>
</template>

<script>
export default {
  data: () => ({
    icons: ["mdi-facebook", "mdi-twitter", "mdi-instagram"],
  }),
};
</script>

<style scoped>
.custom-footer {
  background-color: #f7f7f7 !important;
}

.li-footer {
  list-style-type: none;
}

.footer-color {
  color: #00000099 !important;
}
</style>