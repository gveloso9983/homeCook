import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import '../src/assets/css/style.css'
import { extend, ValidationProvider, ValidationObserver, setInteractionMode } from 'vee-validate';
import { required, digits, max, email, regex, min, confirmed } from 'vee-validate/dist/rules'
import Vuex from 'vuex'
import store from './store'
//import * as types from './store/mutation-types'
// import store from './store/store'
Vue.use(Vuex)
Vue.component ('ValidationObserver', ValidationObserver);
Vue.component ('ValidationProvider', ValidationProvider);
Vue.component ('setInteractionMode', setInteractionMode);
Vue.component ('extend', extend);
import User from '../src/service/user';



setInteractionMode('eager')

extend('required', {
  ...required,
  message: 'Campo é obrigatório.',
})

extend('digits', {
  ...digits,
  message: '{_field_} tem de ter {length} digitos. ({_value_})',
})

extend('max', {
  ...max,
  message: '{_field_} não pode ser maior que {length} caractéres',
})

extend('email', {
  ...email,
  message: 'O campo Email está inválido.',
})

extend('regex', {
  ...regex,
  message: '{_field_} {_value_} não começa por um par válido (91/93/96)'/*{regex}'*/,
})

extend('min', {
  ...min,
  message: 'O campo {_field_} deve ter, pelos menos, {length} caracteres.',
})

extend('confirmed', {
  ...confirmed,
  message: 'As Passwords não correspondem.',
})




Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: function (h) { return h(App) }
}).$mount('#app')
