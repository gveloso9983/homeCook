<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <div class="innerLogin innerAuth" style="width: 100%">
          <h2 class="loginTitle">Registar</h2>
          <validation-observer
            align-self="auto"
            ml-4
            id="observer"
            ref="observer"
            v-slot="{ invalid }"
          >
            <form @submit.prevent="submit">
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="PrimeiroNome"
                      rules="required"
                    >
                      <v-text-field
                        solo
                        v-model="data.firstName"
                        :error-messages="errors"
                        label="Primeiro Nome"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="Apelido"
                      rules="required"
                    >
                      <v-text-field
                        solo
                        v-model="data.lastName"
                        :error-messages="errors"
                        label="Apelido"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="Número de Telemóvel"
                      :rules="{
                        required: true,
                        digits: 9,
                        regex: '^(91|92|93|96)\\d{7}$',
                      }"
                    >
                      <v-text-field
                        type= "number"
                        solo
                        v-model="data.phoneNumber"
                        :counter="9"
                        :error-messages="errors"
                        label="Número de Telemóvel"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>

                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="email"
                      rules="required|email"
                    >
                      <v-text-field
                        solo
                        v-model="data.email"
                        :error-messages="errors"
                        label="E-mail"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="categoria"
                      rules="required"
                    >
                      <v-select
                        solo
                        v-model="data.select"
                        :items="data.items"
                        :error-messages="errors"
                        label="Tipo de Utilizador"
                        data-vv-name="select"
                        required
                      ></v-select>
                    </validation-provider>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="Data"
                      rules="required"
                    >
                      <v-menu
                        ref="menu"
                        v-model="data.menu"
                        :close-on-content-click="false"
                        transition="scale-transition"
                        offset-y
                        min-width="auto"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            :error-messages="errors"
                            v-model="data.date"
                            label="Data de Nascimento"
                            prepend-icon="mdi-calendar"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                            required
                          />
                        </template>
                        <v-date-picker
                          ref="picker"
                          v-model="data.date"
                          :max="maxAge()"
                          min="1910-01-01"
                          @change="save"
                          color="#a59d96"
                          locale="pt-pt"
                        />
                      </v-menu>
                    </validation-provider>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="password"
                      :rules="{
                        required: true,
                        min: 6,
                      }"
                      :vid="data.password"
                    >
                      <v-text-field
                        solo
                        v-model="data.password"
                        :append-icon="
                          data.showPassword ? 'mdi-eye' : 'mdi-eye-off'
                        "
                        :error-messages="errors"
                        :type="data.showPassword ? 'text' : 'password'"
                        name="password"
                        label="Password"
                        hint="No mínimo 6 caracteres"
                        @click:append="data.showPassword = !data.showPassword"
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                  <v-col cols="12" sm="6">
                    <validation-provider
                      v-slot="{ errors }"
                      name="repeatPassword"
                      :rules="{
                        required: true,
                        confirmed: data.password,
                        min: 6,
                      }"
                    >
                      <v-text-field
                        solo
                        v-model="data.repeatPassword"
                        :append-icon="
                          data.showPassword ? 'mdi-eye' : 'mdi-eye-off'
                        "
                        :error-messages="errors"
                        :type="data.showPassword ? 'text' : 'password'"
                        name="repeatPassword"
                        label="Confirmar Password"
                        hint="No mínimo 6 caractéres"
                        data-vv-as="password"
                        @click:append="data.showPassword = !data.showPassword"
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <p v-if="data.apiErrors" class="error-output">{{data.apiErrors}}</p>

                <p class="forgot-account forgot-password text-right">
                  <a href="login">Já tem conta? Faça login!</a>
                </p>

                <validation-provider
                  v-slot="{ errors }"
                  rules="required"
                  name="checkbox"
                >
                  <v-checkbox
                    v-model="data.checkbox"
                    :error-messages="errors"
                    value="1"
                    label="Concordo com os Termos e Condições"
                    type="checkbox"
                    required
                  ></v-checkbox>
                </validation-provider>

                <div v-if="data.loading">
                  <Loading />
                </div>

                <v-btn
                  v-else
                  class="mr-4 btn btn-confirm-color"
                  type="submit"
                  :disabled="invalid"
                >
                  Registar
                </v-btn>
                <v-btn @click="clear"> Limpar </v-btn>
              </v-container>
            </form>
          </validation-observer>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Auth from "../../service/auth";
import Loading from "@/components/partials/Loading.vue";

export default {
  // data: () => (),

  components: {
    Loading,
  },
  props: ["data"],
  watch: {
    menu(val) {
      val && setTimeout(() => (this.$refs.picker.activePicker = "YEAR"));
    },
  },

  methods: {
    save(date) {
      this.$refs.menu.save(date);
      this.data.date = date
    },

    submit() {
      const result = this.$refs.observer.validate();
      if (result) this.processRequest();
    },

    clear() {
      this.data.firstName = "";
      this.data.lastName = "";
      this.data.phoneNumber = "";
      this.data.email = "";
      this.data.select = null;
      this.data.password = "";
      this.data.repeatPassword = "";
      this.data.checkbox = null;
      this.data.date = null;
      this.$refs.observer.reset();
    },
    maxAge() {
      var date = new Date();
      date.setMonth(date.getMonth() - (12 * 18));

      if (this.data.firstTime) {
        this.data.date = date.toISOString().substr(0, 10)
        this.data.firstTime = false;
      }

      return date.toISOString().substr(0, 10)
    },
    processRequest() {
      this.data.loading = true;
      Auth.register(this.data)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = response.data;
          } else {
            window.location.href = "/";
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        })
        .finally((response) => {
          this.data.loading = false;
        });
    },
  },
};
</script>

<codepen-resources lang="json">
  {
    "js": ["https://cdn.jsdelivr.net/npm/vee-validate@3.x/dist/vee-validate.js"]
  }
</codepen-resources>
<style scoped>
.regi {
  width: 50%;
  background-color: #fff;
  border: none;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgb(0 0 0 / 10%), 0 8px 16px rgb(0 0 0 / 10%);
  box-sizing: border-box;
}
.btn {
  width: 50%;
  transition: all 0.2s ease-out;
}

.forgot-account {
  font-size: 11px;
  margin-left: 5px;
}
</style>