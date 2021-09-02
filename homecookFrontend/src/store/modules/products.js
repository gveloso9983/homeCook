import shop from '../../service/product'

// initial state
const state = () => ({
  all: [],
  //byId: []
})

// getters
const getters = {}

// actions
const actions = {
  getAllProducts ({ commit }) {
    shop.getProducts(products => {
      commit('setProducts', products)
    })
  }
}

// mutations
const mutations = {
  setProducts (state, products) {
    state.all = products
    //state.byId = product.getById()
  },

  
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}