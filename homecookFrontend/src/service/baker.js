import { http } from './configs'
import { AuthService } from './token'

export default {

    getProducts() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/baker/products')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    deleteProduct(id, action) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.put('/products/' + id + '/saleStatus', {onSale: action == "Ativar" ? "true" : "false"})
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

}