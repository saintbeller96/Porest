import Vue from "vue";
import Router from "vue-router";
import HelloWorld from "@/components/HelloWorld";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "HelloWorld",
      component: HelloWorld
    },
    {
      path: "/test",
      name: "test",
      component: () => import("@/components/Test.vue")
    },
    {
      path: "/videochat",
      name: "Video",
      component: () => import("@/view/VideoChat.vue")
    },
    {
      path: "/room/:roomId",
      name: "Room",
      component: () => import("@/view/RoomView.vue")
    }
  ]
});
