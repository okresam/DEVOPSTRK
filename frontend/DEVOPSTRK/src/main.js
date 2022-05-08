import { createApp } from 'vue'
import App from './App.vue'
import './index.css'
import store from "./store.js"
import router from './router.js'

createApp(App).use(router).use(store).mount('#app')
