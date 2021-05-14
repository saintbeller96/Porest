<template>
  <div class="feeling-record-background">
    <div class="wrapper" @click="move">
      <div class="calendar-area box fade-in">
        <calendar @get-target-date="getDate"></calendar>
      </div>
      <div class="diary-area box fade-in">
        <diary :getTargetDate="targetDate" @open-modal="openModal"> </diary>
      </div>
      <writing-modal v-if="isModalViewed" @close-modal="isModalViewed = false" class="modal">
        <div v-if="$store.state.diaryModalStatus === 'create'">
          <create-diary :getTargetDate="targetDate"></create-diary>
        </div>
        <div v-else-if="$store.state.diaryModalStatus === 'update'">
          <update-diary :getTargetDate="targetDate"></update-diary>
        </div>
      </writing-modal>
    </div>
    <!-- 물방울 영역 -->
    <!-- <div class="bubbles">
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
      <img src="../../assets/image/bubble.png" />
    </div> -->
  </div>
</template>

<script>
import Calendar from '@/components/feeling-record/Calendar';
import Diary from '@/components/feeling-record/Diary';
import CreateDiary from '@/components/feeling-record/CreateDiary';
import UpdateDiary from '@/components/feeling-record/UpdateDiary';
import WritingModal from '@/components/feeling-record/modal/WritingModal';

export default {
  components: {
    Calendar,
    Diary,
    WritingModal,
    CreateDiary,
    UpdateDiary,
  },
  data() {
    return {
      targetDate: [],
      isModalViewed: '',
    };
  },
  methods: {
    getDate(date) {
      this.targetDate = date;
    },
    openModal(modal) {
      this.isModalViewed = modal;
    },
    move() {
      const calendarArea = document.querySelector('.calendar-area');
      const diaryArea = document.querySelector('.diary-area');
      calendarArea.classList.add('show');
      diaryArea.classList.add('show');
    },
  },
};
</script>

<style scoped>
.feeling-record-background {
  height: 100vh;
  width: 100vw;
  margin: 0;
  padding: 0;
  /* 그리드 나누기 */
  /* display: grid; */
  /* grid-template-columns: repeat(6, 1fr); */
  box-sizing: border-box;
  /* position: fixed; */
  /* position: relative; */
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  background-image: url('../../assets/image/sky.jpg');
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}

.wrapper {
  width: 26vw;
  height: 70vh;
  position: relative;
}

.calendar-area {
  /* grid-column-start: 2;
  grid-column-end: 4;
  align-items: center;
  justify-content: center;
  display: flex; */
}

.calendar-area,
.diary-area {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  transition: 1s all;
}

.diary-area {
  /* grid-column-start: 4;
  grid-column-end: 6;
  align-items: center;
  justify-content: center;
  display: flex; */
  opacity: 0;
  z-index: -1;
}

.calendar-area.show {
  transform: translateX(-14vw);
}

@-webkit-keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
@-moz-keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
@keyframes fadeIn {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}

.diary-area.show {
  transform: translateX(14vw);
  z-index: 1;

  opacity: 0;
  -webkit-animation: fadeIn ease-in 1;
  -moz-animation: fadeIn ease-in 1;
  animation: fadeIn ease-in 1;

  -webkit-animation-fill-mode: forwards;
  -moz-animation-fill-mode: forwards;
  animation-fill-mode: forwards;

  -webkit-animation-duration: 1s;
  -moz-animation-duration: 1s;
  animation-duration: 1s;
}

.modal {
  z-index: 2;
}

.fade-in {
  opacity: 0;
  -webkit-animation: fadeIn ease-in 1;
  -moz-animation: fadeIn ease-in 1;
  animation: fadeIn ease-in 1;

  -webkit-animation-fill-mode: forwards;
  -moz-animation-fill-mode: forwards;
  animation-fill-mode: forwards;

  -webkit-animation-duration: 1s;
  -moz-animation-duration: 1s;
  animation-duration: 0.5s;
}

/* .fade-in.one {
  -webkit-animation-delay: 0.1s;
  -moz-animation-delay: 0.1s;
  animation-delay: 0.1s;
} */

/* .fade-in.two {
  -webkit-animation-delay: 0.7s;
  -moz-animation-delay: 0.7s;
  animation-delay: 0.7s;
} */

/* 물방울 영역 */
/* .bubbles img {
  width: 50px;
  animation: bubble 7s linear infinite;
}

.bubbles {
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-around;
  position: absolute;
  bottom: -70px;
}

@keyframes bubble {
  0% {
    transform: translateY(0);
    opacity: 0;
  }
  50% {
    transform: translateY(0);
    opacity: 1;
  }
  70% {
    transform: translateY(0);
    opacity: 1;
  }
  100% {
    transform: translateY(-80vh);
    opacity: 0;
  }
}

.bubbles img:nth-child(1) {
  animation-delay: 0s;
  width: 35px;
  z-index: -1000;
}
.bubbles img:nth-child(2) {
  animation-delay: 3s;
  width: 33px;
  z-index: -1000;
}
.bubbles img:nth-child(3) {
  animation-delay: 11s;
  width: 25px;
  z-index: -1000;
}
.bubbles img:nth-child(4) {
  animation-delay: 5s;
  width: 20px;
  z-index: -1000;
}
.bubbles img:nth-child(5) {
  animation-delay: 8s;
  width: 25px;
  z-index: -1000;
}
.bubbles img:nth-child(6) {
  animation-delay: 10s;
  width: 30px;
  z-index: -1000;
}
.bubbles img:nth-child(7) {
  animation-delay: 6s;
  width: 22px;
  z-index: -1000;
}
.bubbles img:nth-child(8) {
  animation-delay: 1s;
  width: 10px;
  z-index: -1000;
}
.bubbles img:nth-child(9) {
  animation-delay: 2s;
  width: 15px;
  z-index: -1000;
}
.bubbles img:nth-child(10) {
  animation-delay: 4s;
  width: 33px;
  z-index: -1000;
}
.bubbles img:nth-child(11) {
  animation-delay: 3s;
  width: 22px;
  z-index: -1000;
}
.bubbles img:nth-child(12) {
  animation-delay: 0.5s;
  width: 30px;
  z-index: -1000;
}
.bubbles img:nth-child(13) {
  animation-delay: 9s;
  width: 28px;
  z-index: -1000;
} */
</style>
