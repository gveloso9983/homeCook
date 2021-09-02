<template>
    <div>
      <Account :data="data"/>
    </div>
</template>

<script>
import Account from "@/components/user/Account.vue";

export default {
  components: {
    Account
  },
  data () {
    return {
        data: {
          apiUrl: process.env.VUE_APP_JAVA_API_URL,
          id: '',
          apiErrors: '',
          search: '',
          loading: false,
          products: null,
          productSelected: null,
          snackbar: false,
          invoices: null,
          comment: '',
          rating: 0,
          detailsItem: "",
          dialog: false,
          headers: [
          { text: 'ID', value: 'id' },
          { text: 'Data', value: 'date' },
          { text: 'Cidade', value: 'city' },
          { text: 'Morada', value: 'street' },
          { text: 'Preço (€)', value: 'total' },
          { text: "Detalhes", value: "actions", sortable: false },
        ],
        }
    }
  }
}
</script>