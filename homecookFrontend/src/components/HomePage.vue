<template>
  <div class="background-img">
    <Carousel />

    <Products />

    <BestRating />

    <h5 class="title-home">Quero receber promoções e novos produtos!</h5>
    <form @submit.prevent="submit">
      <v-container>
        <v-row>
          <v-col>
            <v-text-field solo label="Email"></v-text-field>
          </v-col>
        </v-row>

        <v-row>
          <v-col align="center">
            <v-btn class="btn-confirm-color">Subscrever</v-btn>
          </v-col>
        </v-row>
      </v-container>
    </form>
  </div>
</template>

<script>
import Carousel from "@/components/partials/Carousel.vue";
import Products from "@/components/partials/Products.vue";
import BestRating from "@/components/partials/BestRating.vue";

export default {
  components: {
    Carousel,
    Products,
    BestRating,
  },
};
</script>

<style scoped>
/* .background-img {
  background: url('../assets/background-img.jpg');
} */
</style>