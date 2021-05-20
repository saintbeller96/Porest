<template>
  <div class="home-wrapper">
    <auth-form></auth-form>
    <section>
      <div class="box">
        <div class="square" style="--i:0;"></div>
        <div class="square" style="--i:1;"></div>
        <div class="square" style="--i:2;"></div>
        <div class="square" style="--i:3;"></div>
        <div class="square" style="--i:4;"></div>
        <div class="container">
          <div class="form">
            <form @submit.prevent>
              <p class="title">
                Email
              </p>
              <div class="inputBox">
                <input
                  type="email"
                  class="input"
                  v-model="userData.email"
                  placeholder="이메일 주소를 입력해주세요."
                  autocomplete="on"
                />
              </div>

              <p class="title">닉네임</p>
              <div class="inputBox">
                <input
                  type="text"
                  v-model="userData.nickname"
                  placeholder="닉네임을 입력해주세요."
                  autocomplete="off"
                />
              </div>

              <button type="submit" @click="submitForm" class="button">임시 비밀번호 발급</button>
              <div class="go-to-login-container">
                <span @click="goToLogin" class="go-to-login">로그인 하러 가기</span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { findPassword } from "@/api/auth";
import AuthForm from "@/components/auth/AuthForm";
export default {
  components: {
    AuthForm,
  },
  data() {
    return {
      userData: {
        email: "",
        nickname: "",
      },
    };
  },
  methods: {
    goToLogin() {
      this.$router.push({ name: "Login" });
    },
    async submitForm() {
      let res = await findPassword(this.userData);
    },
  },
};
</script>

<style scoped>
.home-wrapper {
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
  background-image: url("../../assets/image/sky3.png");
  background-position: 50% 50%;
  background-repeat: no-repeat;
  background-size: cover;
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.box {
  position: relative;
}

.box .square {
  position: absolute;
  backdrop-filter: blur(5px);
  background: rgba(255, 255, 255, 0.1);

  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: 100%;
  animation: move 10s linear infinite;
  animation-delay: calc(-1s * var(--i));
}

@keyframes move {
  0%,
  100% {
    transform: translateY(-40px);
  }
  50% {
    transform: translateY(40px);
  }
}

.box .square:nth-child(1) {
  top: -50px;
  right: -60px;
  width: 100px;
  height: 100px;
}
.box .square:nth-child(2) {
  top: 150px;
  left: -100px;
  width: 120px;
  height: 120px;
  z-index: 2;
}
.box .square:nth-child(3) {
  bottom: 50px;
  right: -60px;
  width: 80px;
  height: 80px;
  z-index: 2;
}
.box .square:nth-child(4) {
  bottom: -80px;
  left: 100px;
  width: 50px;
  height: 50px;
}
.box .square:nth-child(5) {
  top: -80px;
  left: 140px;
  width: 60px;
  height: 60px;
}
.container {
  position: relative;
  min-width: 27vw;
  /* max-width: 27vw; */
  min-height: 400px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  backdrop-filter: blur(5px);
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);

  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  margin: 5vh 0 5vh 0;
}

.form {
  position: relative;
  width: 100%;
  height: 100%;
  padding: 40px;
}

.inputBox {
  width: 100%;
  margin-top: 5px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.inputBox input {
  width: 100%;
  background: rgba(255, 255, 255, 0.2);
  border: none;
  outline: none;
  padding: 10px;
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  font-size: 12px;
  letter-spacing: 1px;
  color: #fff;
  box-shadow: 0 15px 15px rgba(0, 0, 0, 0.05);
  margin-bottom: 5px;
}

.form .inputBox input::placeholder {
  color: #fff;
}

.title {
  color: #fff;
  margin: 15px 0 8px 5px;
  font-size: 13px;
}

.redundancy_check {
  color: #fff;
  font-size: 5px;
  margin-right: 15px;
  float: right;
  cursor: pointer;
}

.redundancy_check2 {
  color: #fff;
  font-size: 5px;
  margin-right: 15px;
  float: right;
}

.error_message {
  color: #fff;
  font-size: 5px;
  margin: 3px 0 20px 5px;
}

.error_message_2 {
  color: #fff;
  font-size: 5px;
  margin: 0 0 10px 5px;
}

.button {
  width: 100%;
  background: rgba(255, 255, 255, 0.2);
  border: none;
  outline: none;
  padding: 9px;
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.7);
  border-right: 1px solid rgba(255, 255, 255, 0.7);
  border-bottom: 1px solid rgba(255, 255, 255, 0.7);
  margin-top: 25px;
  color: #fff;
  font-size: 15px;
  cursor: pointer;
}

.terms-check {
  color: #fff;
}

.go-to-login-container {
  margin-top: 20px;
  float: right;
}

.go-to-login {
  color: #fff;
  font-size: 10px;
  cursor: pointer;
}

.term {
  font-size: 15px;
  margin-left: 5px;
  cursor: pointer;
}
</style>
