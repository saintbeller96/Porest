import Vue from "vue";
import VueRouter from "vue-router";
// import store from '@/store/index';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    redirect: "/commingsoon",
  },
  {
    path: "/main",
    name: "Main",
    component: () => import("@/views/main/MainPage.vue"),
  },
  {
    path: "/main/mainisland",
    name: "MainIsland",
    component: () => import("@/views/main/MainIslandPage.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("@/views/auth/LoginPage.vue"),
  },
  {
    path: "/signup",
    name: "Signup",
    component: () => import("@/views/auth/SignupPage.vue"),
  },
  {
    path: "/test",
    name: "Test",
    component: () => import("@/views/test/Test.vue"),
  },
  {
    path: "/mailbox",
    name: "Mailbox",
    component: () => import("@/views/mailbox/MailboxPage.vue"),
  },
  {
    path: "/mailbox/letters",
    name: "WriteLetter",
    component: () => import("@/views/mailbox/WriteLetterPage.vue"),
  },
  {
    path: "/mailbox/random-mail",
    name: "RandomMail",
    component: () => import("@/views/mailbox/RandomMailPage.vue"),
  },
  {
    path: "/mailbox/random-mail/rootmail/reply/:storyId",
    name: "RootMailReply",
    component: () => import("@/views/mailbox/RootMailReplyPage.vue"),
  },
  {
    path: "/mailbox/my-mailbox/letter-detail/letter-reply",
    name: "LetterReply",
    component: () => import("@/views/mailbox/LetterReplyPage.vue"),
  },
  {
    path: "/mailbox/received",
    name: "MyReceivedMail",
    component: () => import("@/views/mailbox/MyReceivedMailPage.vue"),
  },
  {
    path: "/home",
    name: "Home",
    component: () => import("@/views/test/Home.vue"),
  },
  {
    path: "/rooms",
    name: "RoomsPage",
    component: () => import("@/views/room/RoomsPage.vue"),
  },
  {
    path: "/checkin/:hostID/:roomID",
    name: "CheckIn",
    component: () => import("@/views/room/CheckInPage.vue"),
    props: true,
  },
  {
    path: "/chat/:hostID/:roomID",
    name: "Chat",
    component: () => import("@/views/room/ChatRoomPage.vue"),
  },
  {
    path: "/profile",
    name: "Profile",
    component: () => import("@/views/profile/ProfilePage.vue"),
  },
  {
    path: "/commingsoon",
    name: "Commingsoon",
    component: () => import("@/views/main/CommingsoonPage.vue"),
  },
  {
    path: "/feeling-record",
    name: "FeelingRecord",
    component: () => import("@/views/feeling-record/FeelingRecordPage.vue"),
  },
  {
    path: "/feeling-record/dairy",
    name: "Dairy",
    component: () => import("@/views/feeling-record/DairyPage.vue"),
  },
  {
    path: "/drawing",
    name: "Drawing",
    component: () => import("@/views/joy/DrawingPage.vue"),
  },
  {
    path: "/all/rooms",
    name: "AllRoom",
    component: () => import("@/views/room/AllRoomPage.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
