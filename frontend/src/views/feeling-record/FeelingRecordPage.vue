<template>
  <div class="feeling-record-background">
    <div class="calendar-area box fade-in one">
      <calendar @get-target-date="getDate"></calendar>
    </div>
    <div class="diary-area box fade-in two">
      <diary :getTargetDate="targetDate" @open-modal="openModal"> </diary>
      <modal v-if="isModalViewed" @close-modal="isModalViewed = false">
        <writing-diary :getTargetDate="targetDate"></writing-diary>
      </modal>
    </div>
    <div class="bubbles">
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
    </div>
  </div>
</template>

<script>
import Calendar from '@/components/feeling-record/Calendar';
import Diary from '@/components/feeling-record/Diary';
import WritingDiary from '@/components/feeling-record/WritingDiary';
import Modal from '@/components/common/Modal';
export default {
  components: {
    Calendar,
    Diary,
    Modal,
    WritingDiary,
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
  },
};
</script>

<style scoped>
.feeling-record-background {
  height: 100vh;
  width: 100vw;
  display: grid;
  /* background-image: linear-gradient(135deg, #a8edea 10%, #fed6e3 100%); */
  /* 그리드 나누기 */
  grid-template-columns: repeat(6, 1fr);
  box-sizing: border-box;
  position: fixed;

  /* background-image: url('../../assets/image/407.jpg'); */
  background-image: url('../../assets/image/sky.jpg');
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}

.calendar-area {
  grid-column-start: 2;
  grid-column-end: 4;
  align-items: center;
  justify-content: center;
  display: flex;
}

.diary-area {
  grid-column-start: 4;
  grid-column-end: 6;
  align-items: center;
  justify-content: center;
  display: flex;
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

.fade-in {
  opacity: 0; /* make things invisible upon start */
  -webkit-animation: fadeIn ease-in 1; /* call our keyframe named fadeIn, use animattion ease-in and repeat it only 1 time */
  -moz-animation: fadeIn ease-in 1;
  animation: fadeIn ease-in 1;

  -webkit-animation-fill-mode: forwards; /* this makes sure that after animation is done we remain at the last keyframe value (opacity: 1)*/
  -moz-animation-fill-mode: forwards;
  animation-fill-mode: forwards;

  -webkit-animation-duration: 1s;
  -moz-animation-duration: 1s;
  animation-duration: 1s;
}

.fade-in.one {
  -webkit-animation-delay: 0.3s;
  -moz-animation-delay: 0.3s;
  animation-delay: 0.3s;
}

.fade-in.two {
  -webkit-animation-delay: 0.7s;
  -moz-animation-delay: 0.7s;
  animation-delay: 0.7s;
}

.bubbles img {
  width: 50px;
  animation: bubble 6s linear infinite;
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
  animation-delay: 1s;
  width: 33px;
  z-index: -1000;
}
.bubbles img:nth-child(3) {
  animation-delay: 3s;
  width: 25px;
  z-index: -1000;
}
.bubbles img:nth-child(4) {
  animation-delay: 4.5s;
  width: 20px;
  z-index: -1000;
}
.bubbles img:nth-child(5) {
  animation-delay: 2s;
  width: 25px;
  z-index: -1000;
}
.bubbles img:nth-child(6) {
  animation-delay: 6s;
  width: 30px;
  z-index: -1000;
}
.bubbles img:nth-child(7) {
  animation-delay: 7s;
  width: 35px;
  z-index: -1000;
}
.bubbles img:nth-child(8) {
  animation-delay: 5s;
  width: 35px;
  z-index: -1000;
}
.bubbles img:nth-child(9) {
  animation-delay: 2s;
  width: 35px;
  z-index: -1000;
}
.bubbles img:nth-child(10) {
  animation-delay: 6s;
  width: 33px;
  z-index: -1000;
}
.bubbles img:nth-child(11) {
  animation-delay: 3s;
  width: 22px;
  z-index: -1000;
}
</style>
