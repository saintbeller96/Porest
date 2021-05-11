<template>
  <div class="intro-wrapper">
    <audio src="@/assets/audio/typing_cut.mp3"></audio>
    <div class="intro-entrance">
      <div class="entrance">입장하기</div>
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
import { startAnimation } from '@/assets/js/main/IntroPage.js';
export default {
  name: 'Intropage',
  data() {
    return {};
  },
  mounted() {
    startAnimation();
  },
  methods: {},
};
</script>

<style scoped src="@/assets/css/main/IntroPage.css"></style>
