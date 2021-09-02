import User from '../../service/user';
import Product from '../../service/product';
import { AuthService } from '../../service/token';

export default {
    data: function () {
        return {
            user: '',
            role: '',
            categoryItems: [],
            isLogged: false,
            cakeData: '',
            filters: {
                prices: "0, 100",
                page: 1,
                limit: 12,
                categories:[],
                ratings:0,
                name: ''
            },
            products:0,
            selectedAddress: [],
            isLogged: false
        }
    },
    methods: {
        async all(){
            await Product.getAllProductsFilters(this.filters)
            .then((response) => {
                this.cakeData = response;
                this.products = this.cakeData.data.productListElem;
                return this.cakeData;
            })
            .catch((error) => {
                console.log(error);
            })
        },
        async kk(){
            await this.all();
        },
        generateAvatar(firstName, lastName) {
            const fullName = firstName + " " + lastName;

            if (firstName == 'load') acronym = 'A carregar...'
            else {
                var matches = fullName.match(/\b(\w)/g);
                var acronym = matches.join('');
            }

            return "https://via.placeholder.com/550/000000/FFFFFF/?text=" + acronym;
        },
        currentUser() {
            User.getCurrent().then((response) => {
                this.user = response.data
                return this.user;
            })
                .catch((error) => {
                    return error.response
                });
        },
        getCategories() {
            Product.getCategories().then((response) => {
                this.categoryItems = response.data
                return this.categoryItems;
            })
                .catch((error) => {
                    return error.response
                });
        },
        getSelectedAddres(id){
            User.getCurrentAddress(id)
            .then((response) => {
                this.selectedAddress = response.data
                return this.selectedAddress
            })
        },
        currentRole() {
            this.role = AuthService.role();
        },
        actionMinusPlusBtn(action, field) {
            if (action == "decrement") this.data[field] -= 1;
            else if (action == "increment") this.data[field] += 1;
        },
        isLoggedIn() {
            const isAuthenticated = AuthService.getToken();
            this.isLogged = AuthService.authorization(isAuthenticated);
        },
        logout() {
            AuthService.removeToken();
            window.location.href = "/login";
        }
    }
};