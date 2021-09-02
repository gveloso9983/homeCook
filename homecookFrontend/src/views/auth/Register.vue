<template>
  <div class="register">
    <RegisterForm :data="data" />
  </div>
</template>

<script>
import RegisterForm from "@/components/auth/RegisterForm.vue";

export default {
  name: "Register",
  components: {
    RegisterForm,
  },
  data() {
    return {
      data: {
        firstTime: true,
        firstName: "",
        lastName: "",
        showPassword: false,
        name: "",
        phoneNumber: "",
        email: "",
        date: null,
        menu: false,
        select: null,
        items: ["Pasteleiro", "Comprador"],
        password: "",
        repeatPassword: "",
        checkbox: null,
        apiErrors: "",
        loading: false,
      },
    };
  },
  mounted() {},
};
</script>