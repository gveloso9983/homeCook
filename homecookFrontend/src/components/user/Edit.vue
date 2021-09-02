<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <div class="innerLogin innerAuth" style="width: 100%">
          <h2 class="loginTitle">Editar Perfil</h2>
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
                      rules="required|max:15"
                    >
                      <v-text-field
                        solo
                        v-model="user.firstName"
                        :counter="15"
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
                      rules="required|max:15"
                    >
                      <v-text-field
                        solo
                        v-model="user.lastName"
                        :counter="15"
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
                        solo
                        v-model="user.phoneNumber"
                        :counter="9"
                        :error-messages="errors"
                        label="Número de Telemóvel"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>

                  <v-col cols="12" sm="6">
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
                          v-model="user.birthDate"
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
                        v-model="user.birthDate"
                        :max="maxAge()"
                        min="1910-01-01"
                        @change="save"
                        color="#a59d96"
                        locale="pt-pt"
                      />
                    </v-menu>
                  </v-col>
                </v-row>

                <v-row>
                  <v-col cols="12" sm="12">
                    <validation-provider
                      v-slot="{ errors }"
                      name="email"
                      rules="required|email"
                    >
                      <v-text-field
                        solo
                        v-model="user.email"
                        :error-messages="errors"
                        label="E-mail"
                        required
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                </v-row>

                <p v-if="data.apiErrors" class="error-output">
                  {{ data.apiErrors }}
                </p>

                <div v-if="data.loading">
                  <Loading />
                </div>

                <v-btn
                  v-else
                  class="mr-4 btn btn-confirm-color"
                  type="submit"
                  block
                  :disabled="invalid"
                >
                  Editar
                </v-btn>
              </v-container>
            </form>
          </validation-observer>
        </div>
      </v-col>

      <v-snackbar v-model="data.snackbar" color="green">
        Atualizado com sucesso!

        <template v-slot:action="{ attrs }">
          <v-btn text v-bind="attrs" @click="data.snackbar = false">
            <v-icon> mdi-close </v-icon>
          </v-btn>
        </template>
      </v-snackbar>
    </v-row>
  </v-container>
</template>

<script>
import User from "../../service/user";
import Mixins from "../mixins/mixin";

export default {
  mixins: [Mixins],
  mounted() {
    this.currentUser();
  },
  props: ["data"],
  methods: {
    maxAge() {
      var date = new Date();
      date.setMonth(date.getMonth() - 12 * 18);

      if (this.data.firstTime) {
        this.data.birthDate = date.toISOString().substr(0, 10);
        this.data.firstTime = false;
      }

      return date.toISOString().substr(0, 10);
    },
    save(date) {
      this.$refs.menu.save(date);
    },
    async submit() {
      const result = await this.$refs.observer.validate();
      if (result) this.processRequest();
    },
    processRequest() {
      User.edit(this.$data.user)
        .then((response) => {
          if (response.status == 400) {
            this.data.apiErrors = response.data;
          } else {
            this.data.apiErrors = "";
            this.data.snackbar = true;
          }
        })
        .catch((error) => {
          this.data.apiErrors = error;
        });
    },
  },
};
</script>

<style scoped>
.upload-avatar {
  position: relative;
  z-index: 9999;
  display: grid;
  opacity: 0;
}
</style>