<template>

<v-container class="innerContainer">
    <v-row class="inside ">

        <v-col cols="12" md="12" sm="12" xs="12">
            <div class="innerLogin innerAuth" style="width:100%">
                <h2 class="loginTitle">Encontrar conta</h2>
                <validation-observer
                    align-self="auto" ml-4
                    id = "observer"
                    ref="observer"
                    v-slot="{ invalid }">

                    <form @submit.prevent="submit" >
                        <v-container>
                            <v-row>
                                <v-col
                                    cols="12"
                                    sm="12">
                                    <validation-provider
                                        v-slot="{ errors }"
                                        name="email"
                                        rules="required|email">
                                        <v-text-field
                                            solo
                                            v-model="data.email"
                                            :error-messages="errors"
                                            label="E-mail"
                                            required
                                        ></v-text-field>
                                    </validation-provider>

                                    <div v-if="data.loading">
                                        <Loading/>
                                    </div>

                                    <v-btn v-else block class="btn-confirm-color" type="submit" :disabled="invalid">Recuperar</v-btn>
                                </v-col>

                            </v-row>
                        </v-container>
                    </form>
                </validation-observer>
            </div>
        </v-col>

    </v-row>
</v-container>

</template>

<script>
    import Auth from '../../service/auth';
    import Loading from "@/components/partials/Loading.vue";

    export default {
        components: {
            Loading
        },
        props: ['data'],
        methods: {
            async submit () {
                const result = await this.$refs.observer.validate()
                if (result) this.processRequest()
            },
            processRequest() {
                this.data.loading = true;
                Auth.forgotPassword(this.data).then(response => {
                    if (response.status == 400) {
                        this.data.apiErrors = error;
                    } else {
                        console.log("sucesso miguel!");
                        console.log(response.data);
                    }
                    }).catch(error => {
                        this.data.apiErrors = error;
                    }).finally(response => {
                        this.data.loading = false;
                    })
            }
        },
    }
</script>
