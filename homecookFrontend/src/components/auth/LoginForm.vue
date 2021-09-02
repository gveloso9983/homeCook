<template>

<v-container class="innerContainer">
    <v-row class="inside">

        <v-col cols="12" md="6" sm="12" xs="12">
            <div class="innerAuth">
                <h2 class="loginTitle">Bem-Vindo</h2>
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
                                </v-col>

                                <v-col
                                    cols="12"
                                    sm="12">
                                    <validation-provider
                                        v-slot="{ errors }"
                                        name="password"
                                        :rules=" {
                                            required: true,
                                            min:6
                                        } "
                                        :vid=data.password>

                                        <v-text-field
                                            solo
                                            v-model="data.password"
                                            :append-icon="data.showPassword ? 'mdi-eye' : 'mdi-eye-off'"
                                            :error-messages="errors"
                                            :type="data.showPassword ? 'text' : 'password'"
                                            name="password"
                                            label="Password"
                                            hint="Pelos menos, 6 caracteres"
                                            @click:append="data.showPassword =! data.showPassword">
                                        </v-text-field>

                                    <p v-if="data.apiErrors" class="error-output">{{data.apiErrors}}</p>

                                    <p class="forgot-password"><a href="forgotPassword">Esqueceu-se da password?</a></p>

                                    </validation-provider>

                                    <div v-if="data.loading">
                                        <Loading/>
                                    </div>

                                    <v-btn v-else block class="btn-confirm-color" type="submit" :disabled="invalid">Entrar</v-btn>

                                </v-col>
                            </v-row>
                        </v-container>
                    </form>
                </validation-observer>
            </div>
        </v-col>

        <v-col class="or" cols="12" md="2" sm="12" xs="12">
            <div class="orLine"></div>
            <div class="orLabel">Ou</div>
        </v-col>

        <v-col cols="12" md="4" sm="12" xs="12" class="ofVisible">
            <div class="addPadding"><img src="../../assets/logotipoRedondo.png" style="height: 70px;margin-left: -5px;margin-top:-10px;" />
                <h5 class="registerT">Criar nova conta</h5>
                <div class="registerBorder">
                    <div class="widthFixed">
                        <a class="registerButton" href="register">
                            <div class="iDiv"><v-icon large>mdi-plus-circle</v-icon></div>
                            <div class="registerText">Registar</div>
                        </a>
                    </div>
                </div>
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
                Auth.login(this.data).then(response => {
                    if (response.status == 400) {
                        this.data.apiErrors = response.data;
                    } else {
                        window.location.href = "/";
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

<style scoped>

.registerT {
    width: 100%;
}

.forgot-password {
    text-align: right;
    font-size: 10px;
}

.ofVisible{
    overflow: visible;
}

.addPadding{
    padding: 8px 0 16px 0;
    text-align: center;
}

.registerBorder {
    flex: 0 0 33.3333%;
    margin: 0 0 20px 0;
}

.widthFixed {
    width: 160px;
    margin: auto;
}

.registerButton {
    border-radius: 8px;
    box-shadow: 0 0 0 1px #dddfe2;
    display: block;
    transition: all .2s ease-out;
    text-decoration: none;
}

.iDiv {
    align-items: center;
    background-color: #f5f6f7;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    display: flex;
    height: 160px;
    justify-content: center;
    width: 160px;
}

.inside {
    display: flex;
    margin: auto;
}

.registerText {
    border-bottom-left-radius: 8px;
    border-bottom-right-radius: 8px;
    padding: 12px;
    width: 100%;
    text-align:center;
    color:#1d2124!important
}

.or {
    position: relative;
    width: 20%;
    display: flex;
    align-items: center;
    margin: 10px 0px 10px 0px;
}

.orLine {
    width: 50%;
    border-right: 1px solid #aaa;
    height: 80%;
}

.orLabel {
    background: white;
    color: #aaa;
    left: 50%;
    position: absolute;
    text-transform: uppercase;
    padding: 2px;
    transform: translate(-50%);
}

@media only screen and (max-width: 959px) {
    .orLine {
        width: 80%;
        border-top: 1px solid #aaa;
        height: unset;
        margin: 0 auto;
    }
}

</style>