<template>
  <div class="dairy-container">
    다이어리
    <div v-if="getTargetDate.length === 0">
      <p>{{ month }}월 {{ today }}일</p>
    </div>
    <div v-else>
      <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
    </div>

    <div v-if="getTargetDate[0] <= year && getTargetDate[1] <= month && getTargetDate[2] <= today">
      <button @click="goToDairy">일기 쓰기</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    getTargetDate: Array,
  },
  data() {
    return {
      year: 0,
      month: 0,
      today: 0,
    };
  },
  methods: {
    goToDairy() {
      this.$router.push({ path: '/feeling-record/dairy', query: { date: this.getTargetDate } });
    },
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
  },
};
</script>

<style scoped>
.dairy-container {
  height: 60vh;
  width: 80%;
  background: rgba(255, 255, 255, 0.3);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  border-radius: 25px;
  margin: auto;
  position: relative;
  justify-content: center;
  padding: 6vh;
  margin-right: 6vw;
}
</style>
