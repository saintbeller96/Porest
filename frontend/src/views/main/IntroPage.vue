<template>
  <div class="intro-wrapper">
    <!-- <Star class="star"></Star> -->

    <div class="logo"></div>
    <!-- <audio src="@/assets/audio/typing_cut.mp3"></audio> -->
    <!-- <div class="intro-entrance"> -->
    <!-- <div class="entrance">입장하기</div> -->
    <!-- </div> -->
    <div class="magic">
      <div class="random-ball-wrapper">
        <div class="random_ball"></div>
      </div>
      <div class="big">
        <div></div>
        <div></div>
        <div></div>
        <!-- <div></div> -->
        <!-- <div></div> -->
      </div>
    </div>
    <div class="letter">
      <div class="type"></div>
      <div class="text_intro">
        당신의 마음 속 이야기, POREST 세상 속에서 들려주세요.
      </div>
    </div>
    <div class="skip-btn" @click="skip">넘어가기</div>
    <div id="canvas"></div>
    <!-- <div class="white-show"></div> -->
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';
import { startAnimation } from '@/assets/js/main/IntroPage.js';

import { typing } from '@/assets/js/main/typing.js';
export default {
  name: 'Intropage',
  data() {
    return {};
  },
  components: {
    Star,
  },
  mounted() {
    startAnimation();
    typing();
  },
  methods: {
    skip() {
      this.$emit('skip');
    },
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

<style scoped src="@/assets/css/main/IntroPage.css"></style>
