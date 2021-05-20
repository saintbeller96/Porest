<template>
  <div class="dairy-container">
    <div class="diary-contents">
      <!-- 날짜 -->
      <div class="date-container">
        <div v-if="$store.state.targetDate.length === 0">
          <span>{{ today }}일 {{ days[day] }}요일</span>
          <img
            :src="todaysFeelingImg[$store.getters.getFeeling]"
            class="emotion"
          />
          <span
            class="setting-btn"
            v-if="$store.state.targetDateDetail"
            @click="openUpdateModal"
            ><i class="fas fa-cog"></i
          ></span>
        </div>
        <div v-else>
          <span
            >{{ $store.state.targetDate[2] }}일
            {{ $store.state.targetDate[3] }}요일</span
          >
          <img
            :src="todaysFeelingImg[$store.getters.getFeeling]"
            class="emotion"
          />
          <span
            class="setting-btn"
            v-if="$store.state.targetDateDetail"
            @click="openUpdateModal"
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
        <p v-html="$store.state.targetDateDetail['content']"></p>
      </div>
      <div
        v-if="
          $store.state.targetDate[0] === year &&
            $store.state.targetDate[1] === month &&
            $store.state.targetDate[2] === today &&
            $store.state.targetDateDetail === ''
        "
      >
        <div class="writing-btn">
          <span @click="openCreateModal" class="btn">
            오늘의 감정 기록하기
            <span class="pencil"><i class="fas fa-pencil-alt"></i></span>
          </span>
        </div>
      </div>
      <div
        v-else-if="
          $store.state.targetDate.length === 0 &&
            $store.state.targetDateDetail === ''
        "
      >
        <div class="writing-btn">
          <span @click="openCreateModal" class="btn">
            오늘의 감정 기록하기
            <span class="pencil"><i class="fas fa-pencil-alt"></i></span>
          </span>
        </div>
      </div>

      <div
        class="description"
        v-if="
          ($store.state.targetDate[0] < year &&
            $store.state.targetDateDetail === '') ||
            ($store.state.targetDate[0] === year &&
              $store.state.targetDate[1] < month &&
              $store.state.targetDateDetail === '') ||
            ($store.state.targetDate[0] === year &&
              $store.state.targetDate[1] === month &&
              $store.state.targetDate[2] < today &&
              $store.state.targetDateDetail === '')
        "
      >
        기록된 감정이 없어요 ㅠㅠ
      </div>
      <div
        class="description"
        v-else-if="
          ($store.state.targetDate[0] >= year &&
            $store.state.targetDate[1] > month &&
            $store.state.targetDateDetail === '') ||
            ($store.state.targetDate[0] === year &&
              $store.state.targetDate[1] === month &&
              $store.state.targetDate[2] > today)
        "
      >
        기록될 날을 기다리고 있어요!
      </div>
    </div>
  </div>
</template>

<script>
export default {
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
      this.$store.commit('getModalStatus', true);
      this.$store.commit('getDiaryModalStatus', 'update');
      this.$store.commit(
        'getEmotionIndex',
        this.$store.state.targetDateDetail['feeling'],
      );
      let a = Number(
        this.$store.state.targetDateDetail['imageUrl'].slice(0, 2),
      );
      this.$store.commit('getStickerIndex', a);
      this.$store.commit(
        'getSelectedSticker',
        this.$store.state.targetDateDetail['imageUrl'],
      );
    },
    openCreateModal() {
      this.$store.commit('getModalStatus', true);
      this.$store.commit('getDiaryModalStatus', 'create');
      this.$store.commit('getStickerIndex', 0);
      this.$store.commit('getEmotionIndex', 0);
    },
  },
  created() {
    const date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.today = date.getDate();
    this.day = date.getDay();
    console.log(this.$store.state.targetDateDetail);
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Gothic+A1:wght@300&family=Nanum+Pen+Script&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');

@font-face {
  font-family: 'UhBeemysen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

.dairy-container {
  width: 27vw;
  height: 61vh;
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
  font-family: 'UhBeemysen';
  overflow: hidden;
}

.date-container {
  font-size: 2vw;
  font-weight: bold;
  margin-bottom: 8vh;
}

.emotion {
  width: 1.6vw;
  margin-left: 0.5vw;
}

.setting-btn {
  /* color: #635ac1; */
  color: #fff;
  float: right;
  font-size: 20px;
  margin-top: -10px;
  margin-right: -10px;
  cursor: pointer;
}

.setting-btn:hover {
  transform: scale(1.2);
  color: #fff;
}

.chosen-sticker {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2vh;
}

.chosen-sticker img {
  width: 7vw;
}

.diary-detail {
  margin: 4.1vh 0 1.38vh 0;
  padding: 0 2vw 0 2vw;
  height: 18vh;
  display: flex;
  justify-content: center;
  line-height: 4.4vh;
  text-align: center;
  text-align: justify;
  font-size: 2.2vw;
  overflow-y: scroll;
}
::-webkit-scrollbar {
  width: 0.3vw;
}
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: #e2deff;
  border-radius: 6px;
  opacity: 0.1;
}

.writing-btn {
  height: 25vh;
  font-size: 2vw;
  font-weight: bold;
  display: flex;
  align-items: center;
  justify-content: center;
}

.description {
  color: #4d4d4d;
  height: 25vh;
  font-size: 2vw;
  font-weight: bold;
  display: flex;
  align-items: center;
  justify-content: center;
}

.btn {
  opacity: 0.8;
  cursor: pointer;
  transition: 0.1s ease-in;
  display: flex;
}

.pencil {
  font-size: 15px;
  margin-top: 5px;
  margin-left: 6px;
}
.btn:hover {
  opacity: 1;
  color: #fff;
}
</style>
