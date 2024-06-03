import { createApp } from 'vue'
import "./assets/management-styles.css";
import "./assets/main.css";
import "./assets/base.css";

import App from './App.vue'
import router from './router/index.ts'; 

const app = createApp(App);
app.use(router);
app.mount('#app');
