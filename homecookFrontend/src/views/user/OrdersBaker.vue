<template>
    <div>
      <OrdersBaker :data="data"/>
    </div>
</template>

<script>
import OrdersBaker from "@/components/user/OrdersBaker.vue";

export default {
  components: {
    OrdersBaker
  },
  data () {
    return {
        data: {
          id: '',
          apiErrors: '',
          search: '',
          loading: false,
          products: null,
          productSelected: null,
          snackbar: false,
          ordersToDo: null,
          ordersDone: null,
          detailsItem: "",
          dialog: false,
          headers: [
          { text: '#ID', value: 'id' },
          { text: 'Data', value: 'deliveryDate' },
          { text: 'Produto', value: 'productName' },
          { text: 'Quantidade', value: 'quantity' },
          { text: 'Morada', value: 'address' },
          { text: "Ações", value: "actions", sortable: false },
        ],
        }
    }
  }
}
</script>