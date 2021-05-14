<template>
  <div>
    <div class="images">
      <img src="../../assets/image/feeling/5.png" @click="getFeeling(5)" />
      <img src="../../assets/image/feeling/4.png" @click="getFeeling(4)" />
      <img src="../../assets/image/feeling/3.png" @click="getFeeling(3)" />
      <img src="../../assets/image/feeling/2.png" @click="getFeeling(2)" />
      <img src="../../assets/image/feeling/1.png" @click="getFeeling(1)" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    getFeeling(n) {
      this.$store.commit('getEmotionIndex', n);
      // this.$store.state.emotionIndex = n;
      console.log(this.$store.state.emotionIndex);
    },
  },
};
</script>

<style scoped>
.images {
  display: flex;
  justify-content: center;
}

.images img {
  width: 2.8vw;
  margin: 0 0.5vw 0 0.5vw;
  cursor: pointer;
  transition: 0.2s ease;
}

.images img:hover {
  transform: scale(1.2);
}
</style>
