<template>
    <div>
      <Edit :data="data"/>
    </div>
</template>

<script>
import Edit from "@/components/user/Edit.vue";

export default {
  components: {
    Edit
  },
  data () {
    return {
        data: {
          firstTime: true,
          id: '',
          snackbar: false,
          apiErrors: '',
          loading: false,
        }
    }
  }
}
</script>