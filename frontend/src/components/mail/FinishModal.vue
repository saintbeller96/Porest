<template>
  <div class="finish__wrapper">
    <div class="exitBtn" @click="exit">떠나기</div>
    <div class="finish__inner">
      <div class="state__choice__wrapper">
        <div class="state__title">
          답변 받으신 내용이 어떠셨나요?
        </div>
        <div class="state__choice">
          <div class="good active">
            좋았어요<img src="../../assets/image/feeling/5.png" alt="" />
          </div>
          <div class="normal">
            별로였어요<img src="../../assets/image/feeling/4.png" alt="" />
          </div>
          <div class="bad">
            안좋았어요<img src="../../assets/image/feeling/1.png" alt="" />
          </div>
        </div>
      </div>
      <div class="inner__title">
        같은 고민을 가진 다른 분들에게 사연을 공개하시겠습니까?
      </div>
      <div class="inner__content">
        <div class="public" @click="publicState == true">
          네. 저와 같은 분들을 위해서 공유하겠습니다.
        </div>
        <div class="nonpublic" @click="publicState == false">
          아니요. 저는 공유하지 않겠습니다.
        </div>
      </div>
      <div class="inner__footer" @click="finish">
        사연 끝마치기
      </div>
    </div>
  </div>
</template>

<script>
import { finishLetter } from '@/api/letters';

export default {
  name: 'Finishmodal',
  data() {
    return {
      publicState: false,
      likeState: '',
    };
  },
  props: ['counselId'],
  mounted() {
    this.animation();
  },
  methods: {
    finish() {
      let letterData = {
        counselId: this.counselId.counselId,
        evaluate: this.likeState,
        open: this.publicState,
      };
      finishLetter(letterData);
      this.exit();
    },
    animation() {
      const publicBtn = document.querySelector('.public');
      const nonpublicBtn = document.querySelector('.nonpublic');
      publicBtn.addEventListener('click', () => {
        nonpublicBtn.classList.remove('active');
        publicBtn.classList.add('active');
      });
      nonpublicBtn.addEventListener('click', () => {
        nonpublicBtn.classList.add('active');
        publicBtn.classList.remove('active');
      });

      const good = document.querySelector('.good');
      const normal = document.querySelector('.normal');
      const bad = document.querySelector('.bad');
      good.addEventListener('click', () => {
        this.likeState = 'GOOD';
        good.classList.add('active');
        normal.classList.remove('active');
        bad.classList.remove('active');
      });
      normal.addEventListener('click', () => {
        this.likeState = 'NORMAL';
        good.classList.remove('active');
        normal.classList.add('active');
        bad.classList.remove('active');
      });
      bad.addEventListener('click', () => {
        this.likeState = 'BAD';
        good.classList.remove('active');
        normal.classList.remove('active');
        bad.classList.add('active');
      });
    },
    exit() {
      this.$emit('exit');
    },
  },
};
</script>

<style scoped>
.finish__wrapper {
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

.finish__inner {
  font-family: 'GyeonggiBatang';

  width: 40rem;
  height: 30rem;
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
.state {
  width: 100%;
}

.inner__title,
.state__title {
  font-size: 1.5rem;
  /* font-weight: 600; */
  color: #fff;
}
.inner__content,
.state__choice {
  font-size: 1.5rem;
  /* font-weight: 600; */
  color: #fccb90;
}
.public,
.nonpublic {
  font-size: 1.1rem;
  margin: 1.3rem 0;
  cursor: pointer;
  transition: all 0.5s;
}
.public:hover,
.nonpublic:hover {
  color: #ff9a9e;
}
.public.active,
.nonpublic.active {
  color: #ff9a9e;
}

.inner__footer {
  color: #fff;
  cursor: pointer;
}

.state__choice {
  display: flex;
  font-size: 1rem;
  margin-top: 1rem;
  justify-content: space-between;
}

.good,
.normal,
.bad {
  text-align: center;
  width: 5rem;
  height: 5rem;
  cursor: pointer;
}
.good.active,
.normal.active,
.bad.active {
  color: #ff9a9e;
}

.good img,
.normal img,
.bad img {
  margin: 0.3rem;
  width: 90%;
  height: 90%;
}
</style>
