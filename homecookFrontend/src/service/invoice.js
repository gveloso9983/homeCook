import { http } from './configs'
import { AuthService } from './token'

function dateFormat(date) {
    const dd = String(date.getDate()).padStart(2, '0');
    const mm = String(date.getMonth() + 1).padStart(2, '0'); //January is 0!
    const yyyy = date.getFullYear();

    const newDate = yyyy + '-' + mm + '-' + dd;

    return newDate;
}

export default {

    getInvoices() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/invoice/list')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getProducts() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/invoice/products')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getInvoiceById(id) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/invoice/' + id)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    sendInvoice(id, date) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;
        const deliveryDate = dateFormat(date)

        return http.post('/shoppingcart/buy', { addressId: id, deliveryDate: deliveryDate })
    },

    getOrdersToDo() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/baker/orders/toDo')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getOrdersDone() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/baker/orders/done')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    updateToDone(id, status) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.post('/invoice_lines/' + id + '/state', { done: status })
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },
}

