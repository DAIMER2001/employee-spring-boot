import { createApp } from 'vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/js/dist/modal'
import 'bootstrap-icons/font/bootstrap-icons'
// import './style.css'
import App from './App.vue'

import router from './Router.js'

createApp(App).use(router).mount('#app')
