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
                이메일
                <span
                  style="color: #6FFFC4"
                  v-if="emailRedundancy && isValidEmail && email.length > 4"
                  class="redundancy_check"
                  >중복확인 완료</span
                >
                <!-- <span v-else class="redundancy_check2">중복확인 완료</span> -->
              </p>
              <div class="inputBox">
                <input
                  type="email"
                  class="input"
                  v-model="email"
                  placeholder="이메일 주소를 입력해주세요"
                  autocomplete="on"
                  @blur="checkEmail"
                  @focus="setCodeInput"
                />
              </div>
              <p
                style="color: #FF6A89"
                v-if="!isValidEmail"
                class="error_message"
              >
                잘못된 이메일 양식입니다
              </p>
              <p
                style="color: #FF6A89"
                v-else-if="!emailRedundancy && email"
                class="error_message"
              >
                다음 텝으로 이동하면 이메일 중복체크를 진행합니다
              </p>

              <!-- 이메일 인증 부분 start -->
              <p class="title" v-if="emailRedundancy">
                인증코드
                <span class="redundancy_check" style="color: #6FFFC4; font-size: 8px" v-if="verify">인증완료</span>
                <!-- <span v-else class="redundancy_check2">중복확인 완료</span> -->
              </p>
              <div v-if="emailRedundancy" class="inputBox">
                <input
                  type="text"
                  class="input_verify"
                  v-model="code"
                  placeholder="인증코드를 입력해주세요"
                  autocomplete="off"
                  @blur="checkVerify"
                />
                <div
                  class="re_send_button"
                  v-if="!verify && remainTime >= '3:00'"
                  @click="sendEmail"
                >
                  전송
                </div>
                <div
                  class="re_send_button"
                  v-else-if="!verify && remainTime == '0:00'"
                  @click="sendEmail"
                >
                  재전송
                </div>
                <span
                  class="timer"
                  v-else-if="!verify"
                  v-text="remainTime"
                ></span>
              </div>
              <p
                style="color: #FF6A89"
                v-if="
                  !verify &&
                    emailRedundancy &&
                    code.length < 1 &&
                    remainTime < '3:00'
                "
                class="error_message"
              >
                다음 텝으로 이동하면 인증코드 확인을 진행합니다
              </p>
              <p
                style="color: #FF6A89"
                v-else-if="!verify && emailRedundancy && code.length == 5"
                v-text="verifyCodeText"
                class="error_message"
              ></p>
              <!-- 이메일 인증 부분  end -->

              <p class="title">닉네임</p>
              <div class="inputBox">
                <input
                  type="text"
                  v-model="nickname"
                  placeholder="닉네임을 입력해주세요"
                  autocomplete="off"
                />
              </div>
              <p
                style="color: #FF6A89"
                v-if="nickname.length > 20"
                class="error_message"
              >
                20자 이하의 닉네임을 입력해주세요.
              </p>

              <p class="title">비밀번호</p>
              <div class="inputBox">
                <input
                  type="password"
                  v-model="password1"
                  placeholder="8~20자의 영문, 숫자 입력"
                  autocomplete="off"
                />
              </div>
              <p
                style="color: #FF6A89"
                v-if="!isValidPwd && password1.length < 8"
                class="error_message"
              >
                8자 이상의 비밀번호를 입력해주세요.
              </p>
              <p
                style="color: #FF6A89"
                v-else-if="!isValidPwd && password1.length > 20"
                class="error_message"
              >
                20자 이하의 비밀번호를 입력해주세요.
              </p>

              <p class="title">비밀번호 확인</p>
              <div class="inputBox">
                <input
                  type="password"
                  v-model="password2"
                  placeholder="비밀번호를 다시 입력해주세요"
                  autocomplete="off"
                />
              </div>
              <p
                style="color: #FF6A89"
                v-if="!isValidPwdConfirm"
                class="error_message"
              >
                다시 비밀번호를 확인해주세요.
              </p>

              <p class="title">가입 약관 동의</p>
              <div class="terms-check">
                <div class="accordion">
                  <register-terms></register-terms>
                </div>

                <p
                  style="color: #FF6A89"
                  v-if="!isTermsChecked"
                  class="error_message_2"
                >
                  이용 약관을 확인해주세요.
                </p>
                <input
                  type="checkbox"
                  name="terms"
                  value="true"
                  v-model="terms"
                />
                <span class="term" @click="checkTerms">약관 확인</span>
              </div>
              <button type="submit" @click="submitForm" class="button">
                Sign up
              </button>
              <div class="go-to-login-container">
                <span @click="goToLogin" class="go-to-login"
                  >로그인 하러 가기</span
                >
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <div id="canvas"></div>

    <!-- 
        bottom-left
        bottom-center
        bottom-right
        top-left
        top-center
        top-right
         -->
    <div>
      <snackbar :infinity="infinity" :position="position">
        {{ snackbarText }}
        <button class="close-btn" @click="$store.state.snackbarStatus = false">close</button>
      </snackbar>
    </div>
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
import Snackbar from '@/components/common/Snackbar';
export default {
  components: {
    AuthForm,
    RegisterTerms,
    Snackbar,
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
      checkedEmailList: [],

      verify: false,
      verifyCodeText: "다음 텝으로 이동하면 인증코드 확인을 진행합니다",
      remainTime: "3:00",
      //snackbar
      position: "top-center",
      infinity: false,
      snackbarText: '',
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
        this.emailRedundancy &&
        this.code !== ''
      );
    },
  },
  methods: {
    setCodeInput() {
      this.verify = false;
      this.remainTime = '3:34';
      this.emailRedundancy = false;
    },
    verifyTime() {
      var timeArray = this.remainTime.split(/[:]+/);
      var min = timeArray[0];
      var sec = timeArray[1] - 1;

      //초 설정
      if (sec < 10 && sec >= 0) {
        sec = '0' + sec;
      } else if (sec < 0) {
        sec = 59;
      }

      //분 설정
      if (sec == 59) {
        min = min - 1;
      }

      this.remainTime = min + ':' + sec;
      if (this.remainTime == '3:33' || (min == 0 && sec == 0)) {
        clearTimeout(this.verifyTime);
        this.remainTime = '3:00';
        return;
      }
      setTimeout(this.verifyTime, 1000);
    },

    goToLogin() {
      this.$router.push({ name: 'Login' });
    },
    checkTerms() {
      this.terms = !this.terms;
    },
    async submitForm() {
      if (this.checkForm) {
        try {
          let res = await signupUser({
            email: this.email,
            nickname: this.nickname,
            password: this.password1,
            code: this.code,
          });
          //회원 가입 실패시 snackbar
          if (!res.status) {
            this.$store.dispatch("saveSnackbarStatus", true);
            this.snackbarText = res.message;
          }
          await this.$store.dispatch("LOGIN", {
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
                    this.$router.push({ name: 'Login' });
                  });
              },
              error => (this.error = error.message),
            );
        } catch (error) {
          this.$store.dispatch("saveSnackbarStatus", true);
          this.snackbarText = error;
        }
      } else {
        this.$store.dispatch("saveSnackbarStatus", true);
        this.snackbarText = "모든 항목을 입력해주세요.";
      }
    },
    async checkEmail() {
      if (this.email.length < 1 || !this.isValidEmail) {
        this.$store.dispatch("saveSnackbarStatus", true);
        this.snackbarText = "사용하실 이메일 주소를 올바르게 입력해주세요.";
      } else {
        try {
          let checkEmailList = false;
          this.checkedEmailList.forEach(element => {
            if (element.email == this.email) checkEmailList = true;
          });
          if (!checkEmailList) {
            var res = await emailCheck({
              email: this.email,
            });

            if (!res.status) {
              this.$store.dispatch("saveSnackbarStatus", true);
              this.snackbarText = res.message;
              return;
            }

            //이메일 인증 결과 데이터를 통해 redundancy 저장
            this.emailRedundancy = res.data.redundancy;
            if (!this.emailRedundancy) {
              this.$store.dispatch("saveSnackbarStatus", true);
              this.snackbarText = "이미 존재하는 이메일 주소입니다.";
            } else {
              this.checkedEmailList.push({
                email: this.email,
                remainTime: this.remainTime,
              });
            }
          } else {
            this.emailRedundancy = true;
          }
        } catch (error) {
          this.$store.dispatch("saveSnackbarStatus", true);
          this.snackbarText = error;
        }
      }
    },
    async sendEmail() {
      var res = await emailVerify({ email: this.email });
      this.$store.dispatch("saveSnackbarStatus", true);
      this.snackbarText = res.message;
      this.remainTime = "3:00";
      this.verifyTime();
    },
    async checkVerify() {
      let res = await verifyCheck({
        email: this.email,
        code: this.code,
      });
      this.verify = res.data.verify;
      this.verifyCodeText = this.verify ? this.verifyCodeText : "인증코드가 다릅니다";
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
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
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
.inputBox input:hover {
  background: rgba(255, 255, 255, 0.25);
}
.inputBox input:focus {
  background: rgba(255, 255, 255, 0.3);
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
.button:hover {
  background: rgba(255, 255, 255, 0.3);
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
.timer {
  color: #ffffff;
  font-size: 15px;
  text-align: center;
}
.re_send_button {
  width: 30%;
  height: 100%;
  text-align: center;
  background: rgba(255, 255, 255, 0.2);
  padding: 10px;
  border: none;
  outline: none;
  border-radius: 10px;
  border: 1px solid rgba(255, 255, 255, 0.7);
  border-right: 1px solid rgba(255, 255, 255, 0.7);
  border-bottom: 1px solid rgba(255, 255, 255, 0.7);
  color: #fff;
  letter-spacing: 1px;
  margin: 0 5px 5px 0;
  font-size: 12px;
  cursor: pointer;
}
.re_send_button:hover {
  background: rgba(255, 255, 255, 0.3);
}
.input_verify {
  width: 70%;
  height: 100%;
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
  margin-right: 5px;
}
</style>
