<template>
    <div>
      <LoginForm :data="data"/>
    </div>
</template>

<script>
import LoginForm from "@/components/auth/LoginForm.vue";

export default {
  components: {
    LoginForm
  },
  data () {
    return {
        data: {
          showPassword: false,
          email: '',
          password: '',
          apiErrors: '',
          loading: false,
        }
    }
  }
}
</script>