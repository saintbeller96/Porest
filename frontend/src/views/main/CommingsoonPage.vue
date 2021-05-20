<template>
  <div class="container">
    <div class="count_cover">
      <h1 id="headline">POREST</h1>
      <div id="countdown">
        <div class="times">
          <li><span id="days">0</span>days</li>
          <li><span id="hours">0</span>Hours</li>
          <li><span id="minutes">0</span>Minutes</li>
          <li><span id="seconds" v-text="count"></span>Seconds</li>
        </div>
      </div>
      <p class="title">COMMING SOON</p>
      <div class="message">
        <div id="content"></div>
      </div>
    </div>
    <div class="plane_cover">
      <div id="world"></div>
    </div>
  </div>
</template>

<script>
import { init } from '@/assets/js/CommingsoonPage.js';
export default {
  data() {
    return {
      count: 5,
    };
  },
  mounted() {
    init();
    const second = document.querySelector('#seconds');
    const header = document.querySelector('#headline');
    header.addEventListener('click', () => {
      let sett = setInterval(() => {
        if (this.count > 0) {
          second.innerHTML = this.count--;
        } else {
          this.$router.push({ name: 'Login' });
        }
      }, 1000);
      setTimeout(() => {
        clearInterval(sett);
      }, 6000);
    });
  },
};
</script>

<style scoped src="@/assets/css/CommingsoonPage.css">
.container {
  overflow: hidden;
}
</style>
