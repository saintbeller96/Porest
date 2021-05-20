<template>
  <div class="random-mail">
    <!-- <div id="canvas"></div> -->
    <span @click="goOneStepBack" class="back">
      <i class="fas fa-arrow-left"></i>
    </span>
    <div class="random_title">당신을 기다리고 있는 편지가 있습니다.</div>
    <div class="random_subtitle">아래 우체통을 클릭해주세요.</div>
    <div class="click_arrow">
      <img src="../../assets/image/click_arrow1.png" alt="" />
    </div>
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
      <div
        v-for="(story, index) in stories"
        :key="index"
        @click="goToRootMailReply(story)"
      >
        <img src="../../assets/image/letter_1.png" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';
// import { startAnimation } from '@/assets/js/main/IntroPage.js';
import { fireworks } from '@/assets/js/mail/RandomMailPage.js';
import { getCandidatesOfStories } from '@/api/stories';
export default {
  name: 'RandomMail',
  data() {
    return {
      randomMails: [1, 2, 3, 4, 5, 6],
      stories: [],
      post_box_svg: require('../../assets/svg/postbox_1.svg'),
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
      await this.$store.dispatch('saveSelectedStory', story);
      setTimeout(() => {
        this.$router.push({ name: 'RootMailReply' });
      }, 800);
    },
    // goToRootMailReply(id) {
    //   this.$router.push({ name: 'RootMailReply', params: { storyId: id } });
    // },
    pop(e) {
      e.target.classList.add('pop-ball');
      const big = document.querySelector('.big');
      const mystery = document.querySelector('.mystery');
      const subtitle = document.querySelector('.random_subtitle');
      const clickarrow = document.querySelector('.click_arrow');

      big.classList.add('show');
      mystery.classList.add('show');
      subtitle.classList.add('hide');
      clickarrow.classList.add('hide');

      setTimeout(() => {
        fireworks();
      }, 3000);
    },
    goOneStepBack() {
      history.go(-1);
    },
  },
  mounted() {
    this.getRandomStories();
    // startAnimation();
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
};
</script>

<style scoped src="@/assets/css/mail/RandomMail.css"></style>
