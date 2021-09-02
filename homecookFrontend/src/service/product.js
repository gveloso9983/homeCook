import { http } from './configs'
import { AuthService } from './token'

function today() {
    var today = new Date();

    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();

    if (dd < 10) dd = '0' + dd;
    if (mm < 10) mm = '0' + mm;

    today = yyyy + '-' + mm + '-' + dd;

    return today;
}

export default {

    getById(id) {
        return http.get('/products/' + id)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },
    getEachImg(id) {

        return http.get('/images/class/' + id)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    addProduct(data) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        let ingredients = []
        for (let index = 0; index < data.ingredients.length; index++) {
            const element = data.ingredients[index];
            ingredients.push({ name: element })
        }
        const formData = new FormData();

        formData.append('name', data.name);
        formData.append('categoryId', data.category);
        formData.append('description', data.description);
        formData.append('ingredients', JSON.stringify(ingredients));
        formData.append('price', data.price);
        formData.append('weight', data.weight);
        data.files.forEach(file  => {
            formData.append('files', file);
        });


        if(data.id){
            formData.append('addedfiles', data.manualFiles)
            return http.put('/products/'+ data.id, formData)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
        }else{
            return http.post('/products/', formData)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
        }

    },

    addCart(id, quantity) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.post('/shoppingcart/', { productId: id, quantity: quantity.toString() })
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getCategories() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/category/list')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getProducts (cb) {
        setTimeout(() => cb(products), 100)
      },


    getAllProducts() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/product/list')
            .then(response => {
                return response
        })
            .catch(error => {
                return error.response
            })
    },

    getLast() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/products/list', {
                params: {
                    order_by: 'id',
                    sort: 'desc',
                    limit: 8
                }
            })
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    getBetter() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/products/list', {
                params: {
                    order_by: 'rating',
                    sort: 'desc',
                    limit: 4
                }
            })
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    listCartProducts() {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.get('/shoppingcart/')
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },

    removeCartProduct(id) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.delete('/shoppingcart/' + id)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
        },

    addComment(data) {

        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        const newData = {
            productId: data.productId,
            date: today(),
            rate: data.rating,
            comment: data.comment
        }

        return http.post('/products/createComment', newData)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })

    },
    parcialEdit(item){
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        return http.put('/products/partialEdit', item)
            .then(response => {
                return response
            })
            .catch(error => {
                return error.response
            })
    },
    getAllProductsFilters(filters) {
        const token = AuthService.getToken()
        http.defaults.headers.common['Authorization'] = token;

        const listParams = {
            categories: '',
            prices: '',
            ratings: '',
            page: 1,
            limit: 20,
            name:''
        }

        if (filters.categories) {
            filters.categories.forEach(element => {
                listParams.categories += element + ","
            });

            // Remove quotation marks
            listParams.categories.replace('"', '')
        }

        if (filters.prices) listParams.prices = filters.prices;
        if (filters.ratings) listParams.ratings = filters.ratings;
        if (filters.page) listParams.page = filters.page;
        if (filters.limit) listParams.limit = filters.limit;
        if (filters.name) listParams.name = filters.name;

        return http.get('/products/list', {
            params: {
                categories: listParams.categories,
                prices: listParams.prices,
                ratings: listParams.ratings,
                page: listParams.page,
                limit: listParams.limit,
                name: listParams.name
            }
        })
        .then(response => {
            return response
        })
        .catch(error => {
            return error.response
        })
    },





}