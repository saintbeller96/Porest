<template>
  <div class="writing-diary-container">
    <div class="date-container">
      <div v-if="getTargetDate.length === 0">
        <p>{{ month }}월 {{ today }}일</p>
      </div>
      <div v-else>
        <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
      </div>
    </div>
    <div class="line"></div>
    <div class="feeling-container">
      <select-feelings></select-feelings>
    </div>
    <div class="writing-container">
      <textarea name="" id="" rows="5"></textarea>
    </div>
    <button class="button">등록</button>
  </div>
</template>

<script>
import SelectFeelings from '@/components/feeling-record/SelectFeelings';
export default {
  props: {
    getTargetDate: Array,
  },
  components: {
    SelectFeelings,
  },
  data() {
    return {
      year: 0,
      month: 0,
      today: 0,
      modal: true,
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
/* @import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap'); */
@import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap');

.writing-diary-container {
  padding: 10%;
  max-width: 100%;
  height: 200px;
  /* font-family: 'Nanum Pen Script', cursive; */
  font-family: 'Gothic A1', sans-serif;
}

.date-container {
  position: static;
  font-size: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.line {
  width: 10vw;
  height: 1px;
  background: #959595;
  display: flex;
  margin: 0 auto;
  margin-bottom: 3vh;
  margin-top: 2vh;
}

.feeling-container {
  position: static;
}

.writing-container {
  position: static;
  margin-top: 13vh;
  /* width: 100px; */
  display: flex;
  justify-content: center;
  align-items: center;
}

.writing-container textarea {
  background: #fff;
  border: 1px solid rgba(0, 0, 0, 0.1);
  width: 100%;
  padding: 12px;
  font-size: 15px;
  min-height: 200px;
  max-height: 400px;
  resize: vertical;
  border-radius: 5px;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.8);
  margin-bottom: 20px;
  opacity: 0.9;
  outline-style: none;
  line-height: 25px;
  font-family: 'Gothic A1', sans-serif;
}

.button {
  width: 100%;
  border: none;
  outline: none;
  padding: 9px;
  border-radius: 5px;
  border: 1px solid rgba(255, 255, 255, 0.7);
  border-right: 1px solid rgba(255, 255, 255, 0.7);
  border-bottom: 1px solid rgba(255, 255, 255, 0.7);
  /* margin-top: 25px; */
  color: #fff;
  font-size: 15px;
  cursor: pointer;
  background-image: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  /* background-image: linear-gradient(-20deg, #ddd6f3 0%, #faaca8 100%, #faaca8 100%); */
}
</style>
