<template>
  <div class="text-wrapper">
    <h1>Scroll</h1>
    <div class="progress">
      <span class="progress-bar"></span>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Test',
  data() {
    return {};
  },
  mounted() {
    this.scrollEffect();
  },
  methods: {
    scrollEffect() {
      let scrollTop = 0;
      let bar = document.querySelector('.progress-bar');

      window.addEventListener('scroll', () => {
        scrollTop = document.documentElement.scrollTop;
        console.log('scrollTop', scrollTop);
        let per = Math.ceil((scrollTop / (document.body.scrollHeight - window.innerHeight)) * 100);
        console.log('per', per);
        bar.style.width = per + '%';
      }),
        false;
    },
  },
};
</script>

<style scoped>
.text-wrapper {
  height: 600vh;
  background: linear-gradient(150deg, red, orange, yellow, green, indigo, purple, black);
}

h1 {
  color: #fff;
}

.progress {
  width: 100%;
  height: 5px;
  position: fixed;
  top: 0;
  left: 0;
  background-color: #000;
  z-index: 10;
}

.progress-bar {
  position: absolute;
  width: 0%;
  height: 5px;
  top: 0;
  left: 0;
  background-color: yellow;
  z-index: 11;
}
</style>
