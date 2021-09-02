import { http } from './configs'
import { AuthService } from './token'

export default {

    edit(data) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;
        const role = AuthService.role()

        const newData = {
            firstName: data.firstName,
            lastName: data.lastName,
            phoneNumber: data.phoneNumber,
            userId: data.id,
            birth: data.birthDate,
            category: (role == 'ROLE_BAKER' ? 'pasteleiro' : 'comprador')
        }

        return http.put('/auth/editRegister', newData)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getCurrent() {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/users/currentUsername')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    addAddress(data) {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.post('/address/', {postalCode: data.postalCode, street: data.street, city: data.city })
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    deleteAddress(id) {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.delete('/address/' + id)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getAddress() {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/address/list')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    editAddress(data) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        const newData = {
            postalCode: data.postalCode,
            street: data.street,
            city: data.city,
            addressId: data.id,
        }

        return http.put('/address/'+ data.id, newData)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getCurrentAddress(id) {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/address/'+ id)
            .then(response => {
               return response
            })
            .catch(error => {
                return error.response
            })
    },
}