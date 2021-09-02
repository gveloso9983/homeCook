<template>
    <div>
      <Details :data="data"/>
    </div>
</template>

<script>
import Details from "@/components/product/Details.vue";

export default {
  components: {
    Details
  },
  data () {
    return {
        data: {
          apiUrl: process.env.VUE_APP_JAVA_API_URL,
          id: '',
          apiErrors: '',
          images: [],
          loading: false,
          rating: 0,
          quantity: 1,
          minToDecrementQty: true,
          load: false,
          imagesRetrieved: [],
        }
    }
  }
}
</script>