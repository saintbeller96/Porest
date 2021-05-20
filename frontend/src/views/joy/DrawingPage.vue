<template>
  <div class="drawing-wrapper amongus">
    <div class="back">
      <i class="fas fa-arrow-left" @click="moveToBack"></i>
    </div>
    <div id="content">
      <form>
        <div class="change__drawing__header">도안 선택하기</div>
        <select class="change__drawing ">
          <option class="draw" value="amongus">어몽어스</option>
          <option class="draw" value="pokect">포켓몬</option>
          <option class="draw" value="pichu">피츄</option>
          <option class="draw" value="uchu">우츠보트</option>
          <option class="draw" value="fire">파이어</option>
          <option class="draw" value="digdag">디그다그</option>
        </select>
        <div class="color__wrapper">
          <ejs-colorpicker
            id="color"
            v-model="value"
            @change="color"
          ></ejs-colorpicker>
          <div class="color-code" :data-value="value">{{ value }}</div>
          <div class="colo__header">: 색상</div>
        </div>
        <div class="thickness__wrapper">
          <input type="number" id="thickness" min="1" max="25" value="5" />
          <div class="thickness__header">: 펜 굵기</div>
        </div>
        <!-- color : <input type="color" id="color" /> -->
        <div class="controls__btns">
          <div class="undo">작업 취소</div>
          <div class="clear" colorformat="rgba">초기화</div>
        </div>
      </form>
      <canvas id="drawing-canvas"></canvas>
      <!-- <div class="bg-image"><img src="@/assets/image/healing.jpg" alt="" /></div> -->
    </div>
  </div>
</template>

<script>
import { init, colorValue } from '@/assets/js/joy/Drawing.js';

export default {
  name: 'Drawingpage',
  data() {
    return {
      value: null,
      image: '../../assets/image/amongus.jpg',
    };
  },
  components: {},
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  mounted() {
    init();
    const dropdownBtn = document.querySelector('.e-dropdown-btn');
    dropdownBtn.addEventListener('click', () => {
      const pick = document.querySelector('.e-hsv-color');
      const hex = document.querySelector('.e-hex');
      pick.addEventListener('click', () => {
        this.color(hex.value);
      });
    });
  },
  methods: {
    color(value) {
      colorValue(value);
    },
    moveToBack() {
      this.$router.go(-1);
    },
  },
};
</script>

<style scoped src="@/assets/css/joy/Drawing.css"></style>
