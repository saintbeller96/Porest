import Vue from 'vue';
import VueRouter from 'vue-router';
// import store from '@/store/index';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/main',
  },
  {
    path: '/main',
    name: 'Main',
    component: () => import('@/views/main/MainPage.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/auth/LoginPage.vue'),
  },
  {
    path: '/signup',
    name: 'Signup',
    component: () => import('@/views/auth/SignupPage.vue'),
  },
  {
    path: '/test',
    name: 'Test',
    component: () => import('@/views/test/Test.vue'),
  },
  {
    path: '/3d',
    name: '3D',
    component: () => import('@/views/test/3D.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
