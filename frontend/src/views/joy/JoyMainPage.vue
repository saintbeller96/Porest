<template>
  <div class="join__main__wrapper">
    <div class="joy__category__wrapper">
      <div class="joy__items" @click="moveToHealingVR">VR 영상 시청</div>
      <div class="joy__items" @click="moveToHealingMusic">힐링 음악 감상</div>
      <div class="joy__items" @click="moveToHealingSketch">힐링 스케치북</div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Joymainpage',
  data() {
    return {};
  },
  mounted() {},
  methods: {
    moveToHealingMusic() {
      this.$router.push({ name: 'HealingMusic' });
    },
    moveToHealingSketch() {
      this.$router.push({ name: 'Drawing' });
    },
    moveToHealingVR() {
      this.$router.push({ name: 'VrRoom' });
    },
  },
};
</script>

<style scoped src="@/assets/css/joy/JoyMainPage.css"></style>
