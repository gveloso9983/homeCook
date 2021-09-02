
import jwt_decode from "jwt-decode";
import Vue from 'vue'
Vue.use(require('vue-cookies'))

const AUTH_KEY = "Authorization";
const AUTH_CONTENT = "Bearer";

const AuthService = {
    getToken() {
        return $cookies.get(AUTH_KEY) || '{}'
    },

    saveToken(token) {
        $cookies.set(AUTH_KEY, AUTH_CONTENT + " " + token);
    },

    removeToken() {
        $cookies.remove(AUTH_KEY);
    },

    authorization(token) {
        var decoded = jwt_decode(token);

        // It's expired
        if (Date.now() >= decoded.exp * 1000) {
            AuthService.removeToken();
            return false;
        }

        if (decoded.roles && decoded.sub) return true
        else return false
    },

    role() {
        const token = AuthService.getToken();
        var decoded = jwt_decode(token);

        if (decoded.roles && decoded.sub) return decoded.roles
        else return false
    }
};

export { AuthService };