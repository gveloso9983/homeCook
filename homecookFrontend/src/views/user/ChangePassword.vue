<template>
    <div>
      <ChangePassword :data="data"/>
    </div>
</template>

<script>
import ChangePassword from "@/components/user/ChangePassword.vue";

export default {
  components: {
    ChangePassword
  },
  data () {
    return {
        data: {
          id: '',
          snackbar: false,
          apiErrors: '',
          loading: false,
          showCurrentPassword: false,
          showPassword: false,
          showPasswordConfirm: false,
        }
    }
  }
}
</script>