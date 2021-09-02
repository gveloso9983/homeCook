<template>
  <v-app app>
    <span><NavBar /></span>

    <v-main>
      <router-view />
    </v-main>
    <span><Footer /></span>
  </v-app>
</template>

<script>
import NavBar from "./components/partials/NavBar";
import Footer from "./components/partials/Footer";
import HomePage from "./components/HomePage";

export default {
  name: "App",
  components: {
    NavBar,
    HomePage,
    Footer,
  },

  data: () => ({
  }),
};
</script>