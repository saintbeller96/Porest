<template>
  <div class="dairy-container">
    <div class="diary-contents">
      <!-- 날짜 -->
      <div class="date-container">
        <div v-if="getTargetDate.length === 0">
          <p>{{ month }}월 {{ today }}일</p>
        </div>
        <div v-else>
          <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
        </div>
      </div>

      <!-- 선택한 감정 -->
      <div class="chosen-feeling">
        <img src="../../assets/image/feeling/5.png" class="menu-item" />
      </div>
      <div class="feeling-detail"><p>기분 최고!</p></div>

      <!-- 일기 내용 -->
      <div class="diary-detail">
        <p>오늘 이런 일들이 있었다.<br />재밌었다!</p>
      </div>

      <div v-if="getTargetDate[0] <= year && getTargetDate[1] <= month && getTargetDate[2] <= today">
        <button @click="openModal">일기 쓰기</button>
      </div>
      <div v-else-if="!getTargetDate.length">
        <button @click="openModal">일기 쓰기</button>
      </div>
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
      modal: true,
    };
  },
  methods: {
    openModal() {
      this.$emit('open-modal', this.modal);
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
@import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

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
  font-family: 'Gothic A1', sans-serif;
}

/* .diary-contents {
  width: 100%;
  height: 50%;
  border-radius: 5px;
  background-image: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);
  border-top: 1.5px solid rgba(255, 255, 255, 0.8);
  border-left: 1.5px solid rgba(255, 255, 255, 0.8);
  opacity: 1;
} */

.date-container {
  font-size: 17px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  font-weight: bold;
  margin-bottom: 3.5vh;
}

.chosen-feeling {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2vh;
}

.chosen-feeling img {
  width: 5vw;
}

.feeling-detail {
  display: flex;
  justify-content: center;
  font-size: 22px;
  font-family: 'Nanum Pen Script', cursive;
}

.diary-detail {
  /* color: #fff; */
  margin: 30px 0 10px 0;
  height: 18vh;
  display: flex;
  justify-content: center;
  line-height: 27px;
  text-align: center;
}
</style>
