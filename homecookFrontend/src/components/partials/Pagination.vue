<template>
    <v-pagination
            v-model="page"
            :length="totalPages"
            total-visible="7"
            @input="handlePageChange"
        ></v-pagination>
</template>

<script>
import Product from '../../service/product.js'

export default {
    data () {
    return {
        data: {
            page: 1,
            totalItems: 8,
            totalPages: 0,
            }
        }
    },
  
    methods: {
            getRequestParams(page, pageSize) {
                let params = {}

                if (page) {
                    params["page"] = page - 1;
                }

                if (pageSize) {
                    params["size"] = pageSize;
                }

                return params;
            },

            retrieveProducts() {
                const params = this.getRequestParams(
                this.page,
                this.pageSize
            );

            Product.getAllProducts(params)
                .then((response) => {
                const  totalPages  = response.data;
                this.totalPages = totalPages;

                console.log(response.data);
                })
                .catch((e) => {
                console.log(e);
                });    
            },
        
            handlePageChange(value) {
                this.page = value;
                this.retrieveProducts();
                },

            handlePageSizeChange(size) {
                this.pageSize = size;
                this.page = 1;
                this.retrieveProducts();
            },

            mounted() {
                this.retrieveProducts();
            },
    },
}
</script>