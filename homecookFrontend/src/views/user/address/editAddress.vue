<template>
    <div>
      <EditAddress :data="data"/>
    </div>
</template>

<script>
import EditAddress from "@/components/user/EditAddress.vue";

export default {
  components: {
    EditAddress
  },
  data () {
    return {
        data: {
          id: '',
          apiErrors: '',
          loading: false,
        }
    }
  }
}
</script>