<template>
    <div>
      <ForgotPasswordForm :data="data"/>
    </div>
</template>

<script>
import ForgotPasswordForm from "@/components/auth/ForgotPasswordForm.vue";

export default {
  components: {
    ForgotPasswordForm
  },
  data () {
    return {
        data: {
          email: '',
          apiErrors: '',
          loading: false,
        }
    }
  }
}
</script>