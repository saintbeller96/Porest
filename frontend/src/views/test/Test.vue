<template>
  <div class="text-wrapper">
    <h1>Scroll</h1>
    <div class="progress">
      <span class="progress-bar"></span>
    </div>
    <div class="cloud-wrap">
      <img src="../../assets/image/cloud.png" alt="Cloud" />
      <img src="../../assets/image/cloud.png" alt="Cloud" />
      <img src="../../assets/image/cloud.png" alt="Cloud" />
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
      let cloudWrap = document.querySelector('.cloud-wrap');
      window.addEventListener('scroll', () => {
        scrollTop = document.documentElement.scrollTop;
        console.log('scrollTop', scrollTop);
        let per = Math.ceil((scrollTop / (document.body.scrollHeight - window.innerHeight)) * 100);
        console.log('per', per);
        // horizontal
        bar.style.width = per + '%';

        // vertical
        // bar.style.height = per + '%';

        //cloud
        cloudWrap.style.transform = 'translate(0,' + scrollTop / 1.4 + 'px)';
      }),
        false;
    },
  },
};
</script>

<style scoped>
.text-wrapper {
  overflow-x: hidden;
  padding: 1rem;
  height: 600vh;
  background: linear-gradient(150deg, red, orange, yellow, green, indigo, purple, black);
}

h1 {
  color: #333;
  font-size: 2rem;
  margin-bottom: 1rem;
}

/* horizontal */
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

/* vertical */
/* .progress {
  width: 4px;
  height: 140px;
  position: fixed;
  top: 40%;
  left: 10px;
  background-color: #000;
  z-index: 10;
}

.progress-bar {
  position: absolute;
  width: 4px;
  height: 0px;
  top: 0;
  left: 0;
  background-color: yellow;
  z-index: 11;
} */

section {
  position: relative;
  width: 400px;
  background-color: rgba(0, 0, 0, 0.9);
  margin: 20px auto;
  padding: 10px 20px;
  z-index: 10;
}

p {
  color: #fff;
  font-size: 15px;
}

.cloud-wrap {
  position: absolute;
}
.cloud-wrap img {
  position: absolute;
  width: 400px;
  top: 0;
  left: 0;
}

/* 구름 각각 위치 잡아주기 */
.cloud-wrap img:nth-child(1) {
  top: -100px;
  left: 500px;
}
.cloud-wrap img:nth-child(2) {
  top: 800px;
  left: 0px;
}
.cloud-wrap img:nth-child(3) {
  top: 1800px;
  left: 400px;
}
</style>
