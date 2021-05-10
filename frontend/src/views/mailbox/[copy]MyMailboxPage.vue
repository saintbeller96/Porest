<template>
  <div>
    <img src="@/assets/image/flower.jpg" class="background" />
    <div class="mailbox-container">
      <img src="@/assets/image/mailbox.png" class="mailbox" />
    </div>
    <div class="mail-list-intro">
      <p>내 우체통 페이지</p>
      <p>편지 리스트 보여지는 곳</p>
    </div>
    <!-- <button @click="goToLetterDetail">편지 디테일 이동</button> -->
    <!-- <div>
      <img src="@/assets/image/envelope.png" class="envelope" />
    </div> -->

    <!-- 편지 봉투 -->
    <div class="envelope" @click="goToLetterDetail">
      <div class="envelope-cap"></div>
      <div class="latter-form">
        <p>어제 이런 일이 있었습니다</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToLetterDetail() {
      this.$router.push({ name: 'LetterDetail' });
    },
  },
};
</script>

<style scoped>
.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.mailbox-container {
  display: flex;
  justify-content: center;
}

.mailbox {
  position: absolute;
  width: 350px;
  /* width: 25vw; */
  /* max-width: 23vw; */
  pointer-events: none;
  margin-top: 35vh;
}

.mail-list-intro {
  position: relative;
  font-size: 1.5em;
  color: white;
}

button {
  position: relative;
}

/* .envelope {
  position: absolute;
  width: 10vw;
} */

.envelope {
  width: 16.6vw;
  /* 봉투 열릴때 파란 부분 */
  height: 24.45vh;
  background: #fec040;
  /* margin: 0vh auto 0; */
  margin-left: 20vw;
  position: relative;
  cursor: pointer;
}
.envelope:after,
.envelope:before {
  content: '';
  position: absolute;
  left: 0;
  bottom: 0;
  border-style: solid;
  border-width: 24.45vh 0 0 16.6vw;
  border-color: rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) #ffd274;
  z-index: 5;
}
.envelope:after {
  border-width: 24.45vh 16.6vw 0 0;
  border-color: rgba(0, 0, 0, 0) #ffe2a4 rgba(0, 0, 0, 0) rgba(0, 0, 0, 0);
}
.envelope .envelope-cap {
  position: absolute;
  left: 0;
  top: -1.74vh;
  width: 100%;
  height: 1.74vh;
  z-index: 20;
  background: #fec040;
  transition: 0.2s 0.2s ease-in;
  transform-origin: 50% 100% 0;
  transform: rotateX(180deg);
}
.envelope .envelope-cap:after {
  content: '';
  border-style: solid;
  border-width: 0 8.3vw 12.61vh 8.3vw;
  border-color: rgba(0, 0, 0, 0) rgba(0, 0, 0, 0) #fec040 rgba(0, 0, 0, 0);
  position: absolute;
  left: 0;
  bottom: 100%;
}
.envelope .latter-form {
  background: #fff;
  padding: 1.5vh;
  width: 12.89vw;
  height: 18vh;
  position: absolute;
  left: 1.09vw;
  bottom: 0;
  z-index: 3;
  line-height: 2;
  transition: 0.2s ease-in;
  font-size: 0.7em;
}
.envelope .latter-form textarea {
  display: block;
  width: 100%;
}
.envelope .latter-form .latter-control {
  border: none;
  outline: none;
  border-bottom: 1px solid #000;
}
.envelope .latter-form .latter-btn {
  border: 1px solid #333;
  background: #fff;
  padding: 0.94vh 2.62vw;
  border-radius: 10px;
  font-size: 8px;
  float: right;
  cursor: pointer;
}
.envelope .latter-form .latter-btn:hover {
  background: #000;
  color: #fff;
}
.envelope:hover .latter-form {
  bottom: 7.63vw;
  transition: 0.3s 0.3s ease-in;
}
.envelope:hover .envelope-cap {
  transform: rotateX(0deg);
  transition: 0.3s ease-in;
  z-index: 2;
}
</style>
