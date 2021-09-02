<template>
    <div>
      <RecoverPasswordForm :data="data"/>
    </div>
</template>

<script>
import RecoverPasswordForm from "@/components/auth/RecoverPasswordForm.vue";

export default {
  components: {
    RecoverPasswordForm
  },
  data () {
    return {
        data: {
          password: '',
          repeatPassword: '',
          showPassword: false,
          apiErrors: '',
          loading: false,
        }
    }
  }
}
</script>