<template>
  <v-container class="innerContainer">
    <v-row class="inside">
      <v-col cols="12" md="12" sm="12" xs="12">
        <div class="innerLogin innerAuth" style="width: 100%">
          <h2 class="loginTitle">Alterar Password</h2>
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
                  <v-col cols="12" sm="12">
                    <validation-provider
                      v-slot="{ errors }"
                      name="currentPassword"
                      :rules="{
                        required: true,
                        min: 6,
                      }"
                      :vid="data.currentPassword"
                    >
                      <v-text-field
                        solo
                        v-model="data.currentPassword"
                        :append-icon="
                          data.showCurrentPassword ? 'mdi-eye' : 'mdi-eye-off'
                        "
                        :error-messages="errors"
                        :type="data.showCurrentPassword ? 'text' : 'password'"
                        name="password"
                        label="Password Atual"
                        hint="No mínimo 6 caracteres"
                        @click:append="data.showCurrentPassword = !data.showCurrentPassword"
                      ></v-text-field>
                    </validation-provider>
                  </v-col>

                  <v-col cols="12" sm="12">
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
                        label="Nova Password"
                        hint="No mínimo 6 caracteres"
                        @click:append="data.showPassword = !data.showPassword"
                      ></v-text-field>
                    </validation-provider>
                  </v-col>
                  <v-col cols="12" sm="12">
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
                          data.showPasswordConfirm ? 'mdi-eye' : 'mdi-eye-off'
                        "
                        :error-messages="errors"
                        :type="data.showPasswordConfirm ? 'text' : 'password'"
                        name="repeatPassword"
                        label="Confirmar Password"
                        hint="No mínimo 6 caractéres"
                        data-vv-as="password"
                        @click:append="data.showPasswordConfirm = !data.showPasswordConfirm"
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
                  Confirmar
                </v-btn>
              </v-container>
            </form>
          </validation-observer>
        </div>
      </v-col>

      <v-snackbar v-model="data.snackbar" color="green">
        Password atualizada com sucesso!

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
    save(date) {
      this.$refs.menu.save(date);
    },
    async submit() {
      const result = await this.$refs.observer.validate();
      if (result) this.processRequest();
    },
    processRequest() {
      this.data.snackbar = true
      this.data.currentPassword = ""
      this.data.password = ""
      this.data.repeatPassword = ""
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