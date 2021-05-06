<template>
  <div class="active-record-container">
    <div id="tabs">
      <button
        v-for="(tab, index) in tabs"
        :key="index"
        :class="{ active: currentTab === index }"
        @click="currentTab = index"
      >
        {{ tab }}
      </button>
      <div class="tab-content">
        <div v-show="currentTab == 0">tab content 1</div>
        <div v-show="currentTab == 1">tab content 2</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: '#tabs',
  data() {
    return {
      currentTab: 0,
      tabs: ['내 사연', '답변한 사연'],
    };
  },
};
</script>

<style scoped>
.active-record-container {
  height: 42vh;
  width: 100%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  z-index: 12;
  border-radius: 25px;
  margin: auto;
  position: relative;
}
</style>
