import shop from '../../service/product'

// initial state
// shape: [{ id, quantity }]
const state = () => ({
    items: [],
    checkoutStatus: null
  })

// getters
const getters = {
    cartProducts: (state, getters, rootState) => {
      return state.items.map(({ id, quantity }) => {
        const product = rootState.products.all.find(product => product.id === id)
        return {
          id: product.id,
          title: product.title,
          price: product.price,
          quantity
        }
      })
    },

    cartTotalPrice: (state, getters) => {
        return getters.cartProducts.reduce((total, product) => {
        return total + product.price * product.quantity
        }, 0)
      }
    }

    // actions
const actions = {
    
    checkout ({ commit, state }, products) {
      const savedCartItems = [...state.items]
      commit('setCheckoutStatus', null)
      // empty cart
      commit('setCartItems', { items: [] })
      shop.buyProducts(
        products,
        () => commit('setCheckoutStatus', 'successful'),
        () => {
          commit('setCheckoutStatus', 'failed')
          // rollback to the cart saved before sending the request
          commit('setCartItems', { items: savedCartItems })
        }
      )
    },

    addProductToCart ({ state, commit }, product) {
        commit('setCheckoutStatus', null)
        
          const cartItem = state.items.find(item => item.id === product.id)
          if (!cartItem) {
            commit('pushProductToCart', { id: product.id })
            console.log(state.items)
          } else {
            commit('incrementItemQuantity', cartItem)
            console.log(state.items)
          }
      },
      
      removeProductFromCart ({ state, commit }, product) {
        // commit('setCheckoutStatus', null)
          const cartItem = state.items.find(item => item.id === product.id)
          console.log(cartItem)
          console.log(state.items)
          if (cartItem) {
            commit('spliceProductFromCart', { id: product.id })
            console.log(state.items)
          } 
          
        }
      }
    
    // mutations
    const mutations = {
      pushProductToCart (state, { id }) {
        state.items.push({
          id,
          quantity: 1
        })
      },
      
      spliceProductFromCart (state, { id }) {
        for(let i = 0; i < state.items.length; i++){
          if(state.items[i]['id'] == id){
            state.items.splice(i,1)
            i--
          }
        }
      },
    
      incrementItemQuantity (state, { id }) {
        const cartItem = state.items.find(item => item.id === id)
        cartItem.quantity++
      },
    
      setCartItems (state, { items }) {
        state.items = items
      },
    
      setCheckoutStatus (state, status) {
        state.checkoutStatus = status
      }
    }
    
    export default {
      namespaced: true,
      state,
      getters,
      actions,
      mutations
    }