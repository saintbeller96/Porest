<template>
  <div class="dairy-background">
    <div class="dairy-area">
      <div class="dairy-container">
        <div v-if="getTargetDate.length === 0">
          <p>{{ year }}년 {{ month }}월 {{ today }}일</p>
        </div>
        <div v-else>
          <p>{{ getTargetDate[0] }}년 {{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
        </div>
        <i class="far fa-laugh-squint"></i>
        <i class="far fa-smile"></i>
        <i class="far fa-meh-blank"></i>
        <i class="far fa-meh"></i>
        <i class="far fa-sad-tear"></i>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      getTargetDate: this.$route.query.date,
      year: 0,
      month: 0,
      today: 0,
    };
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
.dairy-background {
  height: 100vh;
  width: 100vw;
  display: grid;
  background-image: linear-gradient(135deg, #a8edea 10%, #fed6e3 100%);
  /* 그리드 나누기 */
  grid-template-columns: repeat(3, 1fr);
  box-sizing: border-box;
}

.dairy-area {
  grid-column-start: 2;
  grid-column-end: 3;
  align-items: center;
  justify-content: center;
  display: flex;
}

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
}
</style>
