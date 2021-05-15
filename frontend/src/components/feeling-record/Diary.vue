<template>
  <div class="dairy-container">
    <div class="diary-contents">
      <!-- 날짜 -->
      <div class="date-container">
        <div v-if="getTargetDate.length === 0">
          <span>{{ today }}일 {{ days[day] }}요일</span>
          <span class="setting-btn" v-if="$store.state.targetDateDetail" @click="openUpdateModal"
            ><i class="fas fa-cog"></i
          ></span>
        </div>
        <div v-else>
          <span>{{ getTargetDate[2] }}일 {{ getTargetDate[3] }}요일</span>
          <img :src="todaysFeelingImg[$store.getters.getFeeling]" class="emotion" />
          <span class="setting-btn" v-if="$store.state.targetDateDetail" @click="openUpdateModal"
            ><i class="fas fa-cog"></i
          ></span>
        </div>
      </div>

      <!-- 선택한 이모지 -->
      <div class="chosen-sticker" v-if="$store.state.targetDateDetail">
        <img :src="todaysSticker[$store.getters.getStickerIndex]" />
      </div>

      <!-- 일기 내용 -->
      <div class="diary-detail" v-if="$store.state.targetDateDetail">
        <p>{{ $store.state.targetDateDetail['content'] }}</p>
      </div>

      <div
        v-if="
          (getTargetDate[0] === year &&
            getTargetDate[1] === month &&
            getTargetDate[2] === today &&
            !$store.state.targetDateDetail) ||
            (getTargetDate.length === 0 && !$store.state.targetDateDetail)
        "
      >
        <button @click="openCreateModal">일기 쓰기</button>
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
      day: 0,
      modal: true,
      days: ['일', '월', '화', '수', '목', '금', '토'],
      detail: {},
      todaysFeelingImg: [
        require('../../assets/image/feeling/1.png'),
        require('../../assets/image/feeling/2.png'),
        require('../../assets/image/feeling/3.png'),
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
      todaysSticker: [
        require('../../assets/image/sticker/1.png'),
        require('../../assets/image/sticker/2.png'),
        require('../../assets/image/sticker/3.png'),
        require('../../assets/image/sticker/4.png'),
        require('../../assets/image/sticker/5.png'),
        require('../../assets/image/sticker/6.png'),
        require('../../assets/image/sticker/7.png'),
        require('../../assets/image/sticker/8.png'),
        require('../../assets/image/sticker/9.png'),
        require('../../assets/image/sticker/10.png'),
        require('../../assets/image/sticker/11.png'),
        require('../../assets/image/sticker/12.png'),
        require('../../assets/image/sticker/13.png'),
        require('../../assets/image/sticker/14.png'),
        require('../../assets/image/sticker/15.png'),
        require('../../assets/image/sticker/16.png'),
        require('../../assets/image/sticker/17.png'),
        require('../../assets/image/sticker/18.png'),
        require('../../assets/image/sticker/19.png'),
        require('../../assets/image/sticker/20.png'),
        require('../../assets/image/sticker/21.png'),
        require('../../assets/image/sticker/22.png'),
        require('../../assets/image/sticker/23.png'),
        require('../../assets/image/sticker/24.png'),
        require('../../assets/image/sticker/25.png'),
        require('../../assets/image/sticker/26.png'),
        require('../../assets/image/sticker/27.png'),
        require('../../assets/image/sticker/28.png'),
        require('../../assets/image/sticker/29.png'),
        require('../../assets/image/sticker/30.png'),
        require('../../assets/image/sticker/31.png'),
        require('../../assets/image/sticker/32.png'),
        require('../../assets/image/sticker/33.png'),
        require('../../assets/image/sticker/34.png'),
        require('../../assets/image/sticker/35.png'),
        require('../../assets/image/sticker/36.png'),
        require('../../assets/image/sticker/37.png'),
        require('../../assets/image/sticker/38.png'),
        require('../../assets/image/sticker/39.png'),
        require('../../assets/image/sticker/40.png'),
        require('../../assets/image/sticker/41.png'),
        require('../../assets/image/sticker/42.png'),
        require('../../assets/image/sticker/43.png'),
        require('../../assets/image/sticker/44.png'),
        require('../../assets/image/sticker/45.png'),
        require('../../assets/image/sticker/46.png'),
        require('../../assets/image/sticker/47.png'),
        require('../../assets/image/sticker/48.png'),
        require('../../assets/image/sticker/49.png'),
        require('../../assets/image/sticker/50.png'),
      ],
    };
  },
  methods: {
    openUpdateModal() {
      this.$emit('open-modal', this.modal);
      this.$store.commit('getDiaryModalStatus', 'update');
    },
    openCreateModal() {
      this.$emit('open-modal', this.modal);
      this.$store.commit('getDiaryModalStatus', 'create');
    },
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
    this.day = date.getDay();
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

@font-face {
  font-family: 'UhBeemysen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

.dairy-container {
  width: 26vw;
  height: 61vh;
  background: rgba(255, 255, 255, 0.38);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  border-radius: 25px;
  margin: auto;
  position: relative;
  justify-content: center;
  padding: 6vh;
  font-family: 'UhBeemysen';
}

.date-container {
  font-size: 25px;
  font-weight: bold;
  margin-bottom: 8vh;
}

.emotion {
  width: 1.6vw;
  margin-left: 0.5vw;
}

.setting-btn {
  color: #635ac1;
  /* color: #fff; */
  float: right;
  font-size: 15px;
  opacity: 0.8;
  margin-top: -10px;
  margin-right: -10px;
  cursor: pointer;
}

.setting-btn:hover {
  opacity: 0.8;
  color: #fff;
}

.chosen-sticker {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2vh;
}

.chosen-sticker img {
  width: 6vw;
}

.feeling-detail {
  display: flex;
  justify-content: center;
  font-size: 22px;
  font-family: 'Nanum Pen Script', cursive;
}

.diary-detail {
  margin: 4.1vh 0 1.38vh 0;
  padding: 0 2vw 0 2vw;
  height: 18vh;
  display: flex;
  justify-content: center;
  line-height: 32px;
  text-align: center;
  text-align: justify;
  font-size: 32px;
}
</style>
