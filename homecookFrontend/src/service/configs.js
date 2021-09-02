import axios from 'axios'

axios.defaults.withCredentials = false  // enable axios post cookie

export const http = axios.create({
  baseURL: process.env.VUE_APP_JAVA_API_URL
})
