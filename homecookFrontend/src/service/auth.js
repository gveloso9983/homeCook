import { http } from './configs'
import { AuthService } from './token'

export default {

    login(data) {
        return http.post('/auth/login', { email: data.email, password: data.password })
            .then(response => {
                AuthService.saveToken(response.data.token)
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    register(data) {
        return http.post('/auth/register',
            {
                firstName: data.firstName,
                lastName: data.lastName,
                phoneNumber: data.phoneNumber,
                category: data.select,
                birth: data.date,
                email: data.email,
                password: data.password
            }
        )
            .then(response => {
                AuthService.saveToken(response.data.token) // aqui tem de vir token!!!
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    forgotPassword(data) {
        return http.get('/v1/bpi/currentprice.json')
            .then(response => {
                return response
            })
            .catch(error => {
                return error
            })
    },

    recoverPassword(data) {
        return http.get('/v1/bpi/currentprice.json')
            .then(response => {
                return response
            })
            .catch(error => {
                return error
            })
    }
}