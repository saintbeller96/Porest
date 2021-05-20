<template>
  <div class="feeling-record-background">
    <span @click="goOneStepBack" class="oneStepBack">
      <i class="fas fa-arrow-left"></i>
    </span>
    <div class="wrapper" @click="move">
      <div class="calendar-area box fade-in">
        <calendar></calendar>
      </div>
      <div class="diary-area box fade-in">
        <diary> </diary>
      </div>
      <writing-modal v-if="$store.state.modalControl" class="modal">
        <div v-if="$store.state.diaryModalStatus === 'create'">
          <create-diary></create-diary>
        </div>
        <div v-else-if="$store.state.diaryModalStatus === 'update'">
          <update-diary></update-diary>
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
      days: ['일', '월', '화', '수', '목', '금', '토'],
    };
  },
  methods: {
    move() {
      // if (this.$store.state.targetDate.length === 0) {
      //   const date = new Date();
      //   let year = date.getFullYear();
      //   let month = date.getMonth() + 1;
      //   let today = date.getDate();
      //   let day = date.getDay();
      //   this.$store.commit('getTargetDate', [year, month, today, this.days[day]]);
      // }
      const calendarArea = document.querySelector('.calendar-area');
      const diaryArea = document.querySelector('.diary-area');
      calendarArea.classList.add('show');
      diaryArea.classList.add('show');
    },
    goOneStepBack() {
      history.go(-1);
    },
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  // created() {
  //   this.$store.dispatch('LOGIN', {
  //     email: 'najse77@naver.com',
  //     password: 'lemon1234',
  //   });
  // },
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

/* .back {
  position: absolute;
  display: inline-block;
  z-index: 30;
}

.back i {
  position: absolute;
  top: 1rem;
  left: 1rem;
  font-size: 1.5rem;
  cursor: pointer;
  color: #fff;
} */

.wrapper {
  width: 27vw;
  height: 72vh;
  position: relative;
}

.calendar-area {
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

.oneStepBack {
  position: absolute;
  top: 1rem;
  left: 1rem;
  font-size: 1.3vw;
  color: #fff;
  cursor: pointer;
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
