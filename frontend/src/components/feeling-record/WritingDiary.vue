<template>
  <div class="writing-diary-container">
    <div class="date-container">
      <div v-if="getTargetDate.length === 0">
        <p>{{ month }}월 {{ today }}일 {{ days[day] }}요일</p>
      </div>
      <div v-else>
        <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일 {{ getTargetDate[3] }}요일</p>
      </div>
    </div>
    <p class="title">오늘의 기분</p>
    {{ content }}
    <div class="feeling-container">
      <select-feelings></select-feelings>
    </div>
    <p class="title">
      스티커 추가하기
    </p>
    <div class="sticker-container">
      <select-stickers></select-stickers>
    </div>
    <p class="title">오늘의 일기</p>
    <div class="diary-square">
      <div class="writing-container">
        <textarea name="" id="" rows="5" v-model="content"></textarea>
      </div>
    </div>
    <p class="save-btn">
      <span @click="createDiary">저장</span>
    </p>
  </div>
</template>

<script>
import SelectFeelings from '@/components/feeling-record/SelectFeelings';
import SelectStickers from '@/components/feeling-record/SelectStickers';
import { createEmotion } from '@/api/emotions';

export default {
  props: {
    getTargetDate: Array,
  },
  components: {
    SelectFeelings,
    SelectStickers,
  },
  data() {
    return {
      year: 0,
      month: 0,
      today: 0,
      days: ['일', '월', '화', '수', '목', '금', '토'],
      content: '',
    };
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
    this.day = date.getDay();
  },
  methods: {
    async createDiary() {
      try {
        console.log(this.content);
        console.log(this.$store.state.emotionIndex);
        console.log(this.$store.state.selectedSticker);
        await createEmotion({
          content: this.content,
          feeling: this.$store.state.emotionIndex,
          imageUrl: this.$store.state.selectedSticker,
        });
        alert('성공');
      } catch (error) {
        console.log(error);
      }
    },
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
  min-height: 24vh;
  margin-top: 2vh;
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
  height: 20vh;
  padding: 12px;
  font-weight: bold;
  font-size: 25px;
  resize: none;
  opacity: 0.9;
  outline-style: none;
  line-height: 30px;
  font-family: 'UhBeemysen';
}
::-webkit-scrollbar {
  width: 0.3vw;
}
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: #35ae6d;
  border-radius: 6px;
}

.feeling-container {
  margin-top: 2vh;
}

.sticker-container {
  margin-top: 2vh;
}

.title {
  font-size: 21px;
  font-weight: bold;
  margin-top: 3vh;
  color: #525252;
}

.save-btn {
  margin-top: 2vh;
  margin-right: 0.5vw;
  text-align: right;
}

.save-btn span {
  cursor: pointer;
  color: #525252;
  font-size: 27px;
  font-weight: bold;
}

.save-btn span:hover {
  color: #35ae6d;
}
</style>
