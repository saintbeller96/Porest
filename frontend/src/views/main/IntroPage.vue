<template>
  <div class="intro-wrapper">
    <div class="intro-entrance">
      <div class="entrance">입장하기</div>
    </div>
    <!-- <div class="letter">
      <div class="type"></div>

      <div class="header">당신의 오늘은</div>
      <div class="header">수많은 별보다</div>
      <div class="header">더 아름답습니다.</div>
    </div> -->
    <div id="canvas"></div>
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
