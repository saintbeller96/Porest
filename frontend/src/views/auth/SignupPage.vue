<template>
  <div class="home-wrapper">
    <!-- <auth-form></auth-form> -->
    <section>
      <div class="box">
        <!-- <div class="square" style="--i:0;"></div>
        <div class="square" style="--i:1;"></div>
        <div class="square" style="--i:2;"></div>
        <div class="square" style="--i:3;"></div>
        <div class="square" style="--i:4;"></div> -->
        <div class="container">
          <div class="form">
            <form @submit.prevent>
              <p class="title">
                Email
                <span
                  v-if="!emailRedundancy || !isValidEmail || this.email.length === 0"
                  class="redundancy_check"
                  @click="checkEmail"
                  >중복확인</span
                >
                <span v-else class="redundancy_check2">중복확인 완료</span>
              </p>
              <div class="inputBox">
                <input
                  type="email"
                  class="input"
                  v-model="email"
                  placeholder="이메일 주소를 입력해주세요."
                  autocomplete="on"
                />
              </div>
              <p v-if="!isValidEmail" class="error_message">
                잘못된 이메일 양식입니다.
              </p>
              <p v-else-if="!emailRedundancy && email" class="error_message">
                이메일 중복 확인을 진행해주세요
              </p>

              <!-- 이메일 인증 부분 start -->
              <div v-if="emailRedundancy">
                <span v-if="!verify" class="redundancy_check" @click="checkVerify">이메일 인증</span>
                <span v-else class="redundancy_check2">이메일 인증 완료</span>
              </div>
              <div v-if="emailRedundancy" class="inputBox">
                <input
                  type="text"
                  class="input"
                  v-model="code"
                  placeholder="이메일 인증코드를 입력해주세요"
                  autocomplete="off"
                />
              </div>
              <!-- 이메일 인증 부분  end -->

              <p class="title">닉네임</p>
              <div class="inputBox">
                <input type="text" v-model="nickname" placeholder="닉네임을 입력해주세요." autocomplete="off" />
              </div>

              <p class="title">비밀번호</p>
              <div class="inputBox">
                <input type="password" v-model="password1" placeholder="8~20자의 영문, 숫자 입력" autocomplete="off" />
              </div>
              <p v-if="!isValidPwd && password1.length < 8" class="error_message">
                8자 이상의 비밀번호를 입력해주세요.
              </p>
              <p v-else-if="!isValidPwd && password1.length > 20" class="error_message">
                20자 이하의 비밀번호를 입력해주세요.
              </p>

              <p class="title">비밀번호 확인</p>
              <div class="inputBox">
                <input
                  type="password"
                  v-model="password2"
                  placeholder="비밀번호를 다시 입력해주세요."
                  autocomplete="off"
                />
              </div>
              <p v-if="!isValidPwdConfirm" class="error_message">
                다시 비밀번호를 확인해주세요.
              </p>

              <p class="title">가입 약관 동의</p>
              <div class="terms-check">
                <div class="accordion">
                  <register-terms></register-terms>
                </div>

                <p v-if="!isTermsChecked" class="error_message_2">
                  이용 약관을 확인해주세요.
                </p>
                <input type="checkbox" name="terms" value="true" v-model="terms" />
                <span class="term" @click="checkTerms">약관 확인</span>
              </div>
              <button type="submit" @click="submitForm" class="button">Sign up</button>
              <div class="go-to-login-container">
                <span @click="goToLogin" class="go-to-login">로그인 하러 가기</span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <div id="canvas"></div>
  </div>
</template>

<script>
import { signupUser, emailCheck, emailVerify, verifyCheck } from '@/api/auth';
import { startAnimation } from '@/assets/js/main/IntroPage.js';

import FireBase from 'firebase/app';
import 'firebase/auth';
import { validateEmail, validatePwd } from '@/utils/validation';
import AuthForm from '@/components/auth/AuthForm';
import RegisterTerms from '@/components/auth/RegisterTerms';
export default {
  components: {
    AuthForm,
    RegisterTerms,
  },
  data() {
    return {
      email: '',
      nickname: '',
      password1: '',
      password2: '',
      code: '',
      terms: false,
      emailRedundancy: false,
      verify: false,
    };
  },
  computed: {
    isValidEmail() {
      return this.email === '' || validateEmail(this.email);
    },
    isValidPwd() {
      return this.password1 === '' || validatePwd(this.password1);
    },
    isValidPwdConfirm() {
      return this.password2 === '' || this.password1 === this.password2;
    },
    isTermsChecked() {
      return this.terms === true;
    },
    checkForm() {
      return (
        validateEmail(this.email) &&
        validatePwd(this.password1) &&
        this.password1 === this.password2 &&
        this.username !== '' &&
        this.terms === true &&
        this.emailRedundancy
      );
    },
  },
  methods: {
    goToLogin() {
      this.$router.push({ name: 'Login' });
    },
    checkTerms() {
      this.terms = !this.terms;
    },

    // register() {
    //   if (!this.error) {
    //     FireBase.auth()
    //       .createUserWithEmailAndPassword(this.email, this.password1)
    //       .then(
    //         userCred => {
    //           return userCred.user
    //             .updateProfile({
    //               nickname: this.nickname,
    //             })
    //             .then(() => {
    //               this.$router.push('/home');
    //             });
    //         },
    //         error => (this.error = error.message),
    //       );
    //   }
    // },
    async submitForm() {
      if (this.checkForm) {
        try {
          await signupUser({
            email: this.email,
            nickname: this.nickname,
            password: this.password1,
            code: this.code,
          });
          await this.$store.dispatch('LOGIN', {
            email: this.email,
            password: this.password1,
          });
          await FireBase.auth()
            .createUserWithEmailAndPassword(this.email, this.password1)
            .then(
              userCred => {
                return userCred.user
                  .updateProfile({
                    nickname: this.nickname,
                  })
                  .then(() => {
                    this.$router.push('/log/login');
                  });
              },
              error => (this.error = error.message),
            );
        } catch (error) {
          alert(error);
        }
      } else {
        alert('모든 항목을 입력해주세요.');
      }
    },
    async checkEmail() {
      if (this.email.length < 1 || !this.isValidEmail) {
        alert('사용하실 이메일 주소를 올바르게 입력해주세요.');
      } else {
        try {
          let { data } = await emailCheck({
            email: this.email,
          });
          this.emailRedundancy = data.redundancy;
          if (!this.emailRedundancy) {
            alert('이미 존재하는 이메일 주소입니다.');
          } else {
            await emailVerify({ email: this.email });
          }
        } catch (error) {
          alert(error);
        }
      }
    },
    async checkVerify() {
      //기본적인 코드만 넣어놨습니다.
      this.verify = await verifyCheck({
        email: this.email,
        code: this.code,
      });
    },
  },
  mounted() {
    startAnimation();
  },
};
</script>

<style scoped>
.home-wrapper {
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
  background: radial-gradient(ellipse at bottom, #1b2735 0%, #090a0f 100%);

  /* background-image: url('../../assets/image/sky3.png');
  background-position: 50% 50%;
  background-repeat: no-repeat;
  background-size: cover; */
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

/* .box {
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
} */
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

.verify_button {
  width: 100%;
  background: rgba(255, 255, 255, 0.2);
  border: none;
  outline: none;
  padding: 9px;
  border-radius: 10px;
  margin-top: 5px;
  border: 1px solid rgba(255, 255, 255, 0.7);
  border-right: 1px solid rgba(255, 255, 255, 0.7);
  border-bottom: 1px solid rgba(255, 255, 255, 0.7);
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

#canvas {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 100;
  pointer-events: none;
}
</style>
