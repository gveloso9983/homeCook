<template>

<v-container class="innerContainer">
    <v-row class="inside">

        <v-col cols="12" md="12" sm="12" xs="12">
            <div class="innerLogin innerAuth" style="width:100%">
                <h2 class="loginTitle">Recuperar Password</h2>
                <validation-observer
                    align-self="auto" ml-4
                    id = "observer"
                    ref="observer"
                    v-slot="{ invalid }">

                    <form @submit.prevent="submit" >
                        <v-container>
                            <v-row>
                                <v-col cols="12" sm="12" >
                                    <validation-provider
                                    v-slot="{ errors }"
                                    name="password"
                                    :rules="{
                                        required: true,
                                        min:6
                                    }"
                                    :vid=data.password
                                    >

                                    <v-text-field
                                        solo
                                        v-model="data.password"
                                        :append-icon="data.showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                        :error-messages="errors"
                                        :type="data.showPassword ? 'text' : 'password'"
                                        name="password"
                                        label="Nova Password"
                                        hint="Pelos menos, 6 caracteres"
                                        @click:append="data.showPassword =! data.showPassword"
                                        >
                                    </v-text-field>
                                    </validation-provider>
                                </v-col>

                                <v-col cols="12" sm="12">
                                    <validation-provider
                                        v-slot="{ errors }"
                                        name="repeatPassword"
                                        :rules="{
                                            required: true,
                                            confirmed: data.password,
                                            min:6
                                        }">
                                        <v-text-field
                                            solo
                                            v-model="data.repeatPassword"
                                            :append-icon="data.showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                            :error-messages="errors"
                                            :type="data.showPassword ? 'text' : 'password'"
                                            name="repeatPassword"
                                            label="Repetir Password"
                                            hint="Pelos menos, 6 caracteres"
                                            data-vv-as="password"
                                            @click:append="data.showPassword =! data.showPassword"
                                            >
                                        </v-text-field>
                                    </validation-provider>

                                    <div v-if="data.loading">
                                        <Loading/>
                                    </div>

                                    <v-btn v-else block class="btn-confirm-color" type="submit" :disabled="invalid">Confirmar</v-btn>

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
        data: function () {
            return {
                id: this.$route.params.id,
            }
        },
        props: ['data'],
        methods: {
            async submit () {
                const result = await this.$refs.observer.validate()
                if (result) this.processRequest()
            },
            processRequest() {
                this.data.loading = true;
                Auth.recoverPassword(this.data).then(response => {
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
