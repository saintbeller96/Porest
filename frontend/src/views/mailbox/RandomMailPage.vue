<template>
  <div class="random-mail">
    <!-- <div id="canvas"></div> -->

    <Star class="star"></Star>
    <canvas class="fireworks"></canvas>
    <!-- <div class="post_box_svg" @click="postClick"></div> -->
    <div class="random-ball-wrapper" @click="pop">
      <object :data="post_box_svg" type="image/svg+xml"></object>
      <!-- <div class="random_ball" @click="pop"></div> -->
    </div>
    <div class="big">
      <div></div>
      <div></div>
      <!-- <div></div> -->
    </div>
    <div class="mystery">
      <div v-for="(story, index) in stories" :key="index" @click="goToRootMailReply(story)">
        <img src="../../assets/image/letter_1.png" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
import Star from "@/components/common/Star.vue";
// import { startAnimation } from '@/assets/js/main/IntroPage.js';
import { fireworks } from "@/assets/js/mail/RandomMailPage.js";
import { getCandidatesOfStories } from "@/api/stories";
export default {
  name: "RandomMail",
  data() {
    return {
      randomMails: [1, 2, 3, 4, 5, 6],
      stories: [],
      post_box_svg: require("../../assets/svg/postbox_1.svg"),
    };
  },
  components: {
    Star,
  },
  methods: {
    async getRandomStories() {
      this.stories = await getCandidatesOfStories();
    },
    async goToRootMailReply(story) {
      await this.$store.dispatch("saveSelectedStory", story);
      this.$router.push({ name: "RootMailReply" });
    },
    // goToRootMailReply(id) {
    //   this.$router.push({ name: 'RootMailReply', params: { storyId: id } });
    // },
    pop(e) {
      e.target.classList.add("pop-ball");
      const big = document.querySelector(".big");
      const mystery = document.querySelector(".mystery");
      big.classList.add("show");
      mystery.classList.add("show");
      setTimeout(() => {
        fireworks();
      }, 3000);
    },
    postClick(e) {
      console.log(e.target);
    },
  },
  mounted() {
    this.getRandomStories();
    // startAnimation();
  },
};
</script>

<style scoped src="@/assets/css/mail/RandomMail.css"></style>
