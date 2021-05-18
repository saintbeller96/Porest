<template>
  <div id="drawing-wrapper">
    <div id="content">
      <form>
        <div class="undo">Undo</div>
        <ejs-colorpicker
          id="color"
          v-model="value"
          @change="color"
        ></ejs-colorpicker>
        <div>
          color code :
          <div class="color-code" :data-value="value">{{ value }}</div>
        </div>
        <div class="clear" colorformat="rgba">Clear</div>
        Thiskness :
        <input type="number" id="thickness" min="1" max="25" value="5" />
        <!-- color : <input type="color" id="color" /> -->
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
    };
  },
  components: {},
  mounted() {
    init();
  },
  methods: {
    color() {
      colorValue(this.value);
    },
  },
};
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

#drawing-wrapper {
  /* width: 100vw; */
  /* height: 100vh; */
  width: 100vw;
  height: 100vh;
  background-image: url('../../assets/image/amongus.jpg');
  background-position: 50% 50%;
  background-repeat: no-repeat;
  background-size: contain;
  overflow: hidden;
}

#drawing-canvas {
  width: 100%;
  height: 100%;
}
#content {
  width: 100vw;
  height: 100vh;
  margin: 0 auto;
  border: 1px solid black;
  cursor: pointer;
}

form {
  position: absolute;
  width: 280px;
  background-color: antiquewhite;
  padding: 10px;
}

.bg-image {
  position: absolute;
  top: 0;
  left: 0;
}
</style>
