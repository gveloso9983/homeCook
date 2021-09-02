import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/auth/Login.vue'
import ForgotPassword from '../views/auth/ForgotPassword.vue'
import RecoverPassword from '../views/auth/RecoverPassword.vue'
import ProductDetails from '../views/product/Details.vue'
import ProductAdd from '../views/product/Add.vue'
import ListProducts from '../views/product/List.vue'
import Checkout from '../views/product/Checkout.vue'
import Test from '../views/test.vue'
import ListProductsByBaker from '../views/product/ListByBaker.vue'
import Account from '../views/user/Account.vue'
import AccountEdit from '../views/user/Edit.vue'
import PageNotFound from '../views/PageNotFound.vue'
import ChangePassword from '../views/user/ChangePassword.vue'
import OrdersBaker from '../views/user/OrdersBaker.vue'
import { AuthService } from '../service/token'

Vue.use(require('vue-cookies'))
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/forgotPassword',
    name: 'ForgotPassword',
    component: ForgotPassword,
  },
  {
    path: '/recoverPassword/:id',
    name: 'RecoverPassword',
    component: RecoverPassword,
  },
  {
    path: '/product/add',
    name: 'ProductAdd',
    component: ProductAdd,
  },
  {
    path: '/product/:id',
    name: 'ProductDetails',
    component: ProductDetails,
  },
  {
    path: '/editProduct/:id',
    name: 'EditProductDetails',
    component: ProductAdd,
  },
  {
    path: '/listProducts',
    name: 'ListProducts',
    component: ListProducts,
  },
  {
    path: '/checkout',
    name: 'Checkout',
    component: Checkout,
  },
  {
    path: '/test',
    name: 'test',
    component: Test,
  },
  {
    path: '/orders',
    name: 'OrdersBaker',
    component: OrdersBaker,
  },
  {

    path: '/listProducts/:bakerId',
    name: 'ListProductsByBaker',
    component: ListProductsByBaker,
  },
  {
    path: '/account',
    name: 'Account',
    component: Account,
  },
  {
    path: '/account/edit',
    name: 'AccountEdit',
    component: AccountEdit,
  },
  {
    path: '/changePassword',
    name: 'ChangePassword',
    component: ChangePassword,
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
  },
  {
    path: '/register',
    name: 'Register',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import('../views/auth/Register.vue')
    }
  },
  { path: "*", component: PageNotFound }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// Auth behavior
router.beforeEach((to, from, next) => {
  const isAuthenticated = AuthService.getToken();

  if (isAuthenticated == '{}') {
    if (to.name == 'Account') next('/login') // Go to index
    if (to.name == 'AccountEdit') next('/login') // Go to index
    if (to.name == 'ProductAdd') next('/login') // Go to index
    if (to.name == 'Checkout') next('/login') // Go to index
    else next() // Not logged, it's free
  }

  const hasAuth = AuthService.authorization(isAuthenticated);

  // Login & Register flow
  if (to.name == 'Login' && hasAuth) next('/') // Go to index
  else if (to.name == 'Register' && !hasAuth) next() // Go to register
  else if (to.name == 'Register' && hasAuth) next('/') // Go to index
  else if (to.name == 'ForgotPassword' && !hasAuth) next() // Go to forgotPassword
  else if (to.name == 'ForgotPassword' && hasAuth) next('/') // Go to index
  else if (to.name == 'RecoverPassword' && !hasAuth) next() // Go to recoverPassword
  else if (to.name == 'RecoverPassword' && hasAuth) next('/') // Go to index
  // else if (to.name !== 'Login' && !hasAuth) next({ name: 'Login' }) // Go to login
  else next()
})

export default router
