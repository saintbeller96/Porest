<template>
  <div class="intro-wrapper">
    <audio src="@/assets/audio/typing_cut.mp3"></audio>
    <div class="intro-entrance">
      <div class="entrance">입장하기</div>
    </div>
    <div class="magic">
      <div class="random-ball-wrapper" @click="pop">
        <div class="random_ball" @click="pop">
          <Star class="star"></Star>
        </div>
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
    </div>
    <div class="skip-btn">넘어가기</div>
    <div id="canvas"></div>
    <div class="white-show"></div>
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';

import { startAnimation } from '@/assets/js/main/IntroPage.js';
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
  },
  methods: {
    pop(e) {
      e.target.classList.add('pop-ball');
      const big = document.querySelector('.big');
      const mystery = document.querySelector('.mystery');
      big.classList.add('show');
      mystery.classList.add('show');
    },
  },
};
</script>

<style scoped src="@/assets/css/main/IntroPage.css"></style>
