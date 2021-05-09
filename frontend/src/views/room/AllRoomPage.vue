<template>
  <div class="rooms-wrapepr">
    <section class="star-wrapper">
      <div id="stars"></div>
      <div id="stars2"></div>
      <div id="stars3"></div>
    </section>
    <div class="card-main-wrapper">
      <div class="card-inner-wrapper">
        <div class="card">1</div>
        <div class="card">2</div>
        <div class="card">3</div>
        <div class="card">4</div>
        <div class="card">4</div>
        <div class="card">4</div>
        <div class="card">4</div>
        <div class="card">4</div>
      </div>
    </div>
    <div class="prev-button button">prev</div>
    <div class="next-button button">next</div>
  </div>
</template>

<script>
import { init } from '@/assets/js/AllRoomPage.js';
export default {
  name: 'Allroompage',
  data() {
    return {};
  },
  mounted() {
    init();
  },
  methods: {},
};
</script>

<style scoped src="@/assets/css/AllRoomPage.css"></style>
