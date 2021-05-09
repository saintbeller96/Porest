import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import UUID from 'vue-uuid';
import { ColorPickerPlugin } from '@syncfusion/ej2-vue-inputs';
import { enableRipple } from '@syncfusion/ej2-base';

enableRipple(true);
Vue.use(UUID);
Vue.use(ColorPickerPlugin);
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
