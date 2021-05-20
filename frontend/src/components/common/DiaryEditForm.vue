<template>
  <div class="writing-diary-container">
    <div class="close-btn" @click="closeModal">
      <i class="fas fa-times"></i>
    </div>
    <div class="date-container">
      <div v-if="$store.state.targetDate.length === 0">
        <p>{{ month }}월 {{ today }}일 {{ days[day] }}요일</p>
      </div>
      <div v-else>
        <p>
          {{ $store.state.targetDate[1] }}월 {{ $store.state.targetDate[2] }}일
          {{ $store.state.targetDate[3] }}요일
        </p>
      </div>
    </div>
    <p class="title">오늘의 기분</p>
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
      <slot
        name="span"
        :createDiary="createDiary"
        :updateDiary="updateDiary"
        :deleteDiary="deleteDiary"
      ></slot>
    </p>
  </div>
</template>

<script>
import SelectFeelings from '@/components/feeling-record/SelectFeelings';
import SelectStickers from '@/components/feeling-record/SelectStickers';
import {
  createEmotion,
  updateEmotion,
  deleteEmotionDetail,
  getEmotionsOfRecord,
  getEmotionDetail,
} from '@/api/emotions';

export default {
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
      feeling: 0,
      imageUrl: '',
    };
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
    this.day = date.getDay();

    // update일경우
    const id = this.$store.state.targetDateId;
    if (id) {
      try {
        (this.content = this.$store.state.targetDateDetail['content']),
          (this.feeling = this.$store.state.targetDateDetail['feeling']),
          (this.imageUrl = this.$store.state.targetDateDetail['imageUrl']);
      } catch (error) {
        console.log(error);
      }
    }
  },
  computed: {
    checkForm() {
      return (
        this.content !== '' &&
        this.$store.state.emotionIndex !== 0 &&
        this.$store.state.selectedSticker !== ''
      );
    },
  },
  methods: {
    async createDiary() {
      if (this.checkForm) {
        try {
          this.conversion();
          await createEmotion({
            content: this.content,
            feeling: this.$store.state.emotionIndex,
            imageUrl: this.$store.state.selectedSticker,
          });
          this.$store.commit('getTargetDateDetail', {
            content: this.content,
            feeling: this.$store.state.emotionIndex,
            imageUrl: this.$store.state.selectedSticker,
          });
          this.loadDiaryCalendar();
          alert('생성이 완료됐습니다.');
          this.$store.commit('getModalStatus', false);
        } catch (error) {
          console.log(error);
        }
      } else {
        alert('모든 항목을 입력해주세요');
      }
    },
    async updateDiary() {
      // this.checkUpdateForm();
      if (this.checkForm) {
        try {
          const id = this.$store.state.targetDateId;
          await updateEmotion(id, {
            content: this.content,
            feeling: this.$store.state.emotionIndex,
            imageUrl: this.$store.state.selectedSticker,
          });
          this.loadDiaryDetail(this.$store.state.targetDateId);
          this.loadDiaryCalendar();
          alert('수정이 완료되었습니다.');
          this.$store.commit('getModalStatus', false);
          this.$store.commit('getCalendarRefreshStatus', true);
        } catch (error) {
          console.log(error);
        }
      } else {
        alert('모든 항목을 입력해주세요');
      }
    },
    checkUpdateForm() {
      if (this.$store.state.emotionIndex === 0) {
        this.feeling = this.$store.getters.getUpdateFeeling;
      } else {
        this.feeling = this.$store.state.targetDateDetail['feeling'];
      }
      if (this.$store.state.selectedSticker === '') {
        this.imageUrl = this.$store.getters.getUpdateEmotion;
      } else {
        this.imageUrl = this.$store.state.targetDateDetail['imageUrl'];
      }
    },
    async deleteDiary() {
      try {
        const id = this.$store.state.targetDateId;
        await deleteEmotionDetail(id);
        this.loadDiaryCalendar();
        this.$store.commit('getTargetDateDetail', '');
        this.$store.commit('getSelectedSticker', '');
        this.$store.commit('getEmotionIndex', 0);
        this.$store.commit('getStickerIndex', 0);
        alert('삭제가 완료되었습니다.');
        this.$store.commit('getModalStatus', false);
      } catch (error) {
        console.log(error);
      }
    },
    async loadDiaryDetail(n) {
      const id = n;
      if (id > 0) {
        try {
          const { data } = await getEmotionDetail(id);
          this.$store.commit('getTargetDateDetail', data);
        } catch (error) {
          console.log(error);
        }
      } else {
        this.$store.commit('getTargetDateDetail', '');
      }
    },
    async loadDiaryCalendar() {
      try {
        let month = 0;
        let year = 0;
        if (this.$store.state.targetDate.length > 0) {
          month = this.$store.state.targetDate[1];
          year = this.$store.state.targetDate[0];
        } else {
          month = this.month;
          year = this.year;
        }
        let { data } = await getEmotionsOfRecord(month, year);
        let emotionList = data;
        // this.$store.commit('getThisMonthFeelings', emotionList);
        let dates2 = this.$store.state.thisMonth.map(v => v.slice());
        for (let a = 0; a < dates2.length; a++) {
          for (let b = 0; b < dates2[a].length; b++) {
            if (
              (a === 0 && dates2[a][b] > 10) ||
              ((a === 4 || a === 5) && dates2[a][b] < 10)
            ) {
              continue;
            } else {
              for (let c = 0; c < emotionList.length; c++) {
                if (dates2[a][b] === emotionList[c]['day']) {
                  let feelNum = emotionList[c]['feeling'] - 1;
                  dates2[a][b] = String(feelNum) + '!';
                }
              }
            }
          }
        }
        this.$store.commit('getThisMonthEmoji', dates2);
      } catch (error) {
        console.log(error);
      }
    },
    closeModal() {
      this.$store.commit('getModalStatus', false);
    },
    conversion() {
      // textarea 의 줄바꿈 부분을 <br/>로 변경
      let str = this.content;
      str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
      this.content = str;
    },
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
/* @import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap'); */

@font-face {
  font-family: 'UhBeemysen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

.writing-diary-container {
  padding: 1.7%;
  width: 23vw;
  height: 100%;
  font-family: 'UhBeemysen';
  /* font-family: 'Nanum Pen Script', cursive; */
  /* font-family: 'Gothic A1', sans-serif; */
}

.diary-square {
  /* border: 1px solid #979797; */
  width: 100%;
  min-height: 24vh;
  margin-top: 2vh;
}

.date-container {
  margin-top: 5vh;
  font-size: 1.8vw;
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
  background: #fffcf5;
  /* border: 1px solid rgba(0, 0, 0, 0.1); */
  border: none;
  width: 100%;
  height: 20vh;
  padding: 12px;
  font-weight: bold;
  font-size: 1.7vw;
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
  font-size: 1.7vw;
  font-weight: bold;
  margin-top: 2.8vh;
  color: #525252;
}

.save-btn {
  margin-top: 1.5vh;
  margin-bottom: 1.1vh;
  margin-right: 0.5vw;
  text-align: right;
}

.save-btn span {
  cursor: pointer;
  color: #525252;
  font-size: 1.8vw;
  font-weight: bold;
  margin-left: 1vw;
}

.save-btn span:hover {
  color: #35ae6d;
}

.close-btn {
  display: flex;
  float: right;
  margin-top: 2vh;
  cursor: pointer;
}
</style>
