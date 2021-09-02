<template>
  <v-container>
    <h2 align="center">Todos os produtos</h2>
    <v-divider></v-divider>
    <br />
    <Filters />
  </v-container>
</template>

<script>
import Filters from "../../components/partials/Filters.vue";

export default {
  props: ["data"],

  components: {
    Filters
  },

  data() {
    return {
      info: {
        apiErrors: "",
        loading: false,
      },
    };
  },
};
</script>