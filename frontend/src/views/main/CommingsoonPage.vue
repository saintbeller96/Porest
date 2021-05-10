<template>
  <div class="container">
    <div class="count_cover">
      <h1 id="headline">POREST</h1>
      <div id="countdown">
        <div class="times">
          <li><span id="days"></span>days</li>
          <li><span id="hours"></span>Hours</li>
          <li><span id="minutes"></span>Minutes</li>
          <li><span id="seconds"></span>Seconds</li>
        </div>
      </div>
      <p class="title">COMMING SOON</p>
      <div class="message">
        <div id="content">
        </div>
      </div>
    </div>
    <div class="plane_cover">
      <div id="world">
      </div>
    </div>
  </div>
</template>

<script>
import {init} from '@/assets/js/CommingsoonPage.js';
export default {
  mounted(){
    init();
  }
}
</script>

<style scoped src="@/assets/css/CommingsoonPage.css">
.container {
  overflow: hidden;
}
</style>