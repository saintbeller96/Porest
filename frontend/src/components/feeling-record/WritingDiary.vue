<template>
  <div class="writing-diary-container">
    <div class="date-container">
      <div v-if="getTargetDate.length === 0">
        <p>{{ month }}월 {{ today }}일 수요일</p>
      </div>
      <div v-else>
        <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일 수요일</p>
      </div>
    </div>
    <p class="title">오늘의 기분</p>
    <div class="feeling-container">
      <select-feelings></select-feelings>
    </div>
    <!-- <div class="line"></div> -->
    <p class="title">
      <span>오늘의 일기</span>
      <span class="sticker" @click="openModal">스티커 추가</span>
    </p>
    <div class="diary-square">
      <div class="writing-container">
        <textarea name="" id="" rows="5"></textarea>
      </div>
    </div>
    <p class="save-btn">
      <span>저장</span>
    </p>
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
  openModal() {
    this.$emit('open-modal', this.modal);
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
/* @import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap'); */

@font-face {
  font-family: 'UhBeemysen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

.writing-diary-container {
  padding: 8px;
  width: 23vw;
  height: 100%;
  font-family: 'UhBeemysen';
  /* font-family: 'Nanum Pen Script', cursive; */
  /* font-family: 'Gothic A1', sans-serif; */
}

.diary-square {
  border: 1px solid #979797;
  width: 100%;
  min-height: 33vh;
  /* padding: 8%; */
  margin-top: 2vh;
  /* border-radius: 5px; */
}

.date-container {
  margin-top: 3vh;
  font-size: 25px;
  font-weight: bold;
  text-align: center;
}

.line {
  width: 1.8vw;
  height: 1px;
  background: #959595;
  margin-bottom: 3vh;
  margin-top: 1vh;
}

.writing-container {
  position: static;
  display: flex;
  justify-content: center;
  /* align-items: center; */
}

.writing-container textarea {
  background: #fdf6e8;
  /* border: 1px solid rgba(0, 0, 0, 0.1); */
  border: none;
  width: 100%;
  height: 30vh;
  padding: 12px;
  font-weight: bold;
  font-size: 25px;
  /* min-height: 200px; */
  /* max-height: 400px; */
  resize: vertical;
  border-radius: 5px;
  opacity: 0.9;
  outline-style: none;
  line-height: 30px;
  font-family: 'UhBeemysen';
}

.feeling-container {
  margin-top: 2vh;
}

.title {
  font-size: 21px;
  font-weight: bold;
  margin-top: 3vh;
  color: #525252;
}

.sticker {
  font-size: 17px;
  float: right;
  margin-top: 1vh;
  cursor: pointer;
}

.sticker:hover {
  color: #35ae6d;
}

.save-btn {
  margin-top: 3vh;
  text-align: right;
}

.save-btn span {
  cursor: pointer;
  color: #525252;
  font-size: 25px;
  font-weight: bold;
}

.save-btn span:hover {
  color: #35ae6d;
}
</style>
