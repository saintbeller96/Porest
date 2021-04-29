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
    path: '/auth',
    name: 'Auth',
    component: () => import('@/views/auth/AuthPage.vue'),
  },
  {
    path: '/mailbox',
    name: 'Mailbox',
    component: () => import('@/views/mailbox/MailboxPage.vue'),
  },
  {
    path: '/mailbox/letters',
    name: 'WriteLetter',
    component: () => import('@/views/mailbox/WriteLetterPage.vue'),
  },
  {
    path: '/mailbox/my-mailbox',
    name: 'MyMailbox',
    component: () => import('@/views/mailbox/MyMailboxPage.vue'),
  },
  {
    path: '/mailbox/my-mailbox/letter-detail',
    name: 'LetterDetail',
    component: () => import('@/views/mailbox/LetterDetailPage.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
