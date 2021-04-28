import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import * as THREE from 'three';
import * as TrackballControls from 'three-trackballcontrols';
import * as ThreeStats from 'three-stats';
Vue.config.productionTip = false;

Vue.prototype.THREE = THREE;
Vue.prototype.TrackballControls = TrackballControls;
Vue.prototype.ThreeStats = ThreeStats;

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
