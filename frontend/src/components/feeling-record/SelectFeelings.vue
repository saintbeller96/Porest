<template>
  <div class="feeling-container">
    <div class="images">
      <img src="../../assets/image/feeling/5.png" @click="getFeeling(5)" class="img5" />
      <img src="../../assets/image/feeling/4.png" @click="getFeeling(4)" class="img4" />
      <img src="../../assets/image/feeling/3.png" @click="getFeeling(3)" class="img3" />
      <img src="../../assets/image/feeling/2.png" @click="getFeeling(2)" class="img2" />
      <img src="../../assets/image/feeling/1.png" @click="getFeeling(1)" class="img1" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      check: [],
    };
  },
  methods: {
    getFeeling(n) {
      // this.$store.commit('getEmotionIndex', n);
      if (this.check.length === 0) {
        this.check.push(n);
        const selected = document.querySelector(`.img${n}`);
        selected.classList.toggle('selected');
        this.$store.commit('getEmotionIndex', n);
      } else {
        let a = this.check.pop();
        const selected1 = document.querySelector(`.img${a}`);
        const selected2 = document.querySelector(`.img${n}`);
        if (a === n) {
          selected1.classList.toggle('selected');
          this.$store.commit('getEmotionIndex', 0);
        } else if (a !== n) {
          this.check.push(n);
          selected1.classList.toggle('selected');
          selected2.classList.toggle('selected');
          this.$store.commit('getEmotionIndex', n);
        }
      }
    },
  },
  mounted() {
    if (this.$store.state.emotionIndex !== 0) {
      let n = this.$store.state.emotionIndex;
      this.check.push(n);
      const selected = document.querySelector(`.img${n}`);
      selected.classList.toggle('selected');
    }
  },
};
</script>

<style scoped>
.feeling-container {
  height: 5.7vh;
}

.images {
  display: flex;
  justify-content: center;
}

.images img {
  width: 2.6vw;
  margin: 0 0.6vw 0 0.6vw;
  cursor: pointer;
  transition: 0.1s ease;
  filter: opacity(0.7) drop-shadow(0 0 0 white);
}

.images img:hover {
  transform: scale(1.3);
  filter: none;
}

.img1.selected {
  transform: scale(1.3);
  filter: none;
}
.img2.selected {
  transform: scale(1.3);
  filter: none;
}
.img3.selected {
  transform: scale(1.3);
  filter: none;
}
.img4.selected {
  transform: scale(1.3);
  filter: none;
}
.img5.selected {
  transform: scale(1.3);
  filter: none;
}
</style>
