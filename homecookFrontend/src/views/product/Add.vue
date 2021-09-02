<template>
  <div>
    <Add :data="data" />
  </div>
</template>

<script>
import Add from "@/components/product/Add.vue";

export default {
  components: {
    Add,
  },
  data() {
    return {
      data: {
        snackbar: false,
        name: "",
        description: "",
        price: "",
        weight: "",
        categoryItems: [],
        ingredient: "",
        ingredients: [],
        apiErrors: "",
        files: [],
        loading: false,
      },
    };
  },
};
</script>