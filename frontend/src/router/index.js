import Vue from 'vue';
import VueRouter from 'vue-router';
// import store from '@/store/index';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/login',
  },
  {
    path: '/main',
    name: 'MainIsland',
    component: () => import('@/views/main/MainIslandPage.vue'),
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
    path: '/intro',
    name: 'Intro',
    component: () => import('@/views/main/IntroPage.vue'),
  },
  {
    path: '/find-password',
    name: 'FindPassword',
    component: () => import('@/views/auth/FindPasswordPage.vue'),
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
    path: '/mailbox/random-mail',
    name: 'RandomMail',
    component: () => import('@/views/mailbox/RandomMailPage.vue'),
  },
  {
    path: '/mailbox/random-mail/rootmail/reply',
    name: 'RootMailReply',
    component: () => import('@/views/mailbox/RootMailReplyPage.vue'),
    props: true,
  },
  {
    path: '/mailbox/received',
    name: 'MyReceivedMail',
    component: () => import('@/views/mailbox/MyReceivedMailPage.vue'),
    props: true,
  },
  {
    path: '/rooms',
    name: 'RoomsPage',
    component: () => import('@/views/room/RoomsPage.vue'),
  },
  {
    path: '/checkin/:hostID/:roomID',
    name: 'CheckIn',
    component: () => import('@/views/room/CheckInPage.vue'),
    props: true,
  },
  {
    path: '/profile',
    name: 'Profile',
    component: () => import('@/views/profile/ProfilePage.vue'),
  },
  {
    path: '/commingsoon',
    name: 'Commingsoon',
    component: () => import('@/views/main/CommingsoonPage.vue'),
  },
  {
    path: '/feeling-record',
    name: 'FeelingRecord',
    component: () => import('@/views/feeling-record/FeelingRecordPage.vue'),
  },
  {
    path: '/drawing',
    name: 'Drawing',
    component: () => import('@/views/joy/DrawingPage.vue'),
  },
  {
    path: '/all/rooms',
    name: 'AllRoom',
    component: () => import('@/views/room/AllRoomPage.vue'),
  },
  {
    path: '/joy/vr',
    name: 'VrRoom',
    component: () => import('@/views/joy/VrRoomPage.vue'),
  },
  {
    path: '/star3d',
    name: 'Star3D',
    component: () => import('@/components/common/Star3D.vue'),
  },
  {
    path: '/mailbox/intro',
    name: 'MailBoxIntro',
    component: () => import('@/views/mailbox/MailBoxIntro.vue'),
  },
  {
    path: '/joy',
    name: 'JoyMainPage',
    component: () => import('@/views/joy/JoyMainPage.vue'),
  },
  {
    path: '/joy/healing/music',
    name: 'HealingMusic',
    component: () => import('@/views/joy/HealingMusicPage.vue'),
  },
  {
    path: '/admin/ban-report',
    name: 'BanReport',
    component: () => import('@/views/admin/BanReportPage.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
