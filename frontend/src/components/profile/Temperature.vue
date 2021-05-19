<template>
  <div class="body">
    <div class="temp-container">
      <span class="percent-count text" id="percentCount"></span>
      <span class="description"><span class="temp">°C&nbsp;</span>입니다.</span>
    </div>

    <div class="progress-bar">
      <div class="progress" id="progress"></div>
    </div>
    <!-- <h1 class="text">Hello</h1> -->
  </div>
</template>

<script>
export default {
  mounted() {
    this.progress();
  },
  methods: {
    progress() {
      let prg = document.getElementById('progress');
      let percent = document.getElementById('percentCount');
      let counter = 1;
      let progress = 1;
      let id = setInterval(frame, 40);
      let temperature = this.$store.state.temperature;

      function frame() {
        if (counter == temperature) {
          clearInterval(id);
        } else {
          progress += 1;
          counter += 1;
          prg.style.width = progress + '%';
          percent.innerHTML = counter;
        }
      }
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.body {
  font-family: 'MaplestoryOTFBold';
}

.temp-container {
  display: flex;
  justify-content: center;
  margin-bottom: 3vh;
}

.temp {
  color: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
}

.description {
  color: #fff;
  font-size: 1.35vw;
}

.percent-count {
  text-align: center;
}

.progress-bar {
  width: 10vw;
  height: 2.7vh;
  background-image: linear-gradient(to top, #dfe9f3 0%, white 100%);
  margin: 2vh auto;
  padding: 0.4vh;
  border-radius: 13px;
  opacity: 0.8;
}

/*  */
.progress {
  width: 10vw;
  height: 2vh;
  border-radius: 10px;
  background-image: linear-gradient(120deg, #f093fb 0%, #f5576c 100%);
}

/* 글씨체 */
::selection {
  background-color: #c3cfe2;
}

.text {
  text-transform: uppercase;
  /* background-image: linear-gradient(to top, #dfe9f3 0%, white 100%); */
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  font-size: 1.5vw;
  background-image: linear-gradient(to top, #fddb92 0%, #d1fdff 100%);
}
</style>
