<template>
  <div class="ban__wrapper">
    <div class="exitBtn" @click="exit">떠나기</div>
    <div class="ban__inner">
      <div class="inner__title">
        답변을 보낸 사용자를 신고하시겠습니까?
      </div>
      <div class="inner__content">
        <div class="violence">
          욕설 및 폭언으로 인해 신고합니다.
        </div>
        <div class="sexuel">
          성적인 대화 및 음란한 단어 사용으로 인해 신고합니다.
        </div>
        <div class="subject">
          주제에 맞지 않는 답변으로 인해 신고합니다.
        </div>
      </div>
      <div class="inner__footer" @click="ban">
        신고하기
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Banmodal',
  data() {
    return {
      banState: 1,
    };
  },
  mounted() {
    this.animation();
  },
  methods: {
    ban() {
      console.log(this.banState);
    },
    animation() {
      const violence = document.querySelector('.violence');
      const sexuel = document.querySelector('.sexuel');
      const subject = document.querySelector('.subject');
      violence.addEventListener('click', () => {
        this.banState = 1;
        subject.classList.remove('active');
        sexuel.classList.remove('active');
        violence.classList.add('active');
      });
      sexuel.addEventListener('click', () => {
        this.banState = 2;
        subject.classList.remove('active');
        sexuel.classList.add('active');
        violence.classList.remove('active');
      });
      subject.addEventListener('click', () => {
        this.banState = 3;
        subject.classList.add('active');
        sexuel.classList.remove('active');
        violence.classList.remove('active');
      });
    },
    exit() {
      this.$emit('exit');
    },
  },
};
</script>

<style scoped>
.ban__wrapper {
  position: absolute;
  top: 0%;
  left: 0%;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(0, 0, 0, 0.8);
}
.exitBtn {
  position: absolute;
  font-family: 'InfinitySans-BoldA1';
  top: 30%;
  left: 68%;
  letter-spacing: 2px;
  cursor: pointer;
  color: #fff;
}

.ban__inner {
  font-family: 'GyeonggiBatang';

  width: 40rem;
  height: 20rem;
  border-radius: 1rem;
  backdrop-filter: blur(5px);
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  background: rgba(255, 255, 255, 0.2);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  padding: 1rem;
}

.inner__title {
  font-size: 1.5rem;
  /* font-weight: 600; */
  color: #fff;
}
.inner__content {
  font-size: 1.5rem;
  /* font-weight: 600; */
  color: #fccb90;
}
.subject,
.sexuel,
.violence {
  font-size: 1.1rem;
  margin: 1.3rem 0;
  cursor: pointer;
  transition: all 0.5s;
}
.subject:hover,
.sexuel:hover,
.violence:hover {
  color: #ff9a9e;
}
.subject.active,
.sexuel.active,
.violence.active {
  color: #ff9a9e;
}

.inner__footer {
  color: #fff;
  cursor: pointer;
}
</style>
