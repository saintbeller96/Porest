<template>
  <div class="home-wrapper">
    <!-- <auth-form></auth-form> -->
    <div class="letter">
      <div class="type"></div>
    </div>
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
              <p class="welcome">Welcome to POREST :)</p>
              <p class="title">
                Email
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

              <p class="title">비밀번호</p>
              <div class="inputBox">
                <input type="password" v-model="password" placeholder="8~20자의 영문, 숫자 입력" autocomplete="off" />
              </div>
              <p v-if="!isValidPwd && password.length < 8" class="error_message">8자 이상의 비밀번호를 입력해주세요.</p>
              <p v-else-if="!isValidPwd && password.length > 20" class="error_message">
                20자 이하의 비밀번호를 입력해주세요.
              </p>
              <button @click="submitForm" class="button">Login</button>
              <div class="go-to-find-password-container">
                <span @click="goToFindPassword" class="go-to-find-password">비밀번호 찾기</span>
              </div>
              <div class="go-to-signup-container">
                <span @click="goToSignup" class="go-to-signup">회원가입</span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>
    <div class="white-show"></div>

    <div id="canvas"></div>
  </div>
</template>

<script>
import { validateEmail, validatePwd } from '@/utils/validation';
import { startAnimation } from '@/assets/js/main/IntroPage.js';
import FireBase from 'firebase/app';
import 'firebase/auth';
import AuthForm from '@/components/auth/AuthForm';
import { typing } from '@/assets/js/main/typing.js';

export default {
  components: {
    AuthForm,
  },
  data() {
    return {
      email: '',
      nickname: '',
      password: '',
    };
  },
  computed: {
    isValidEmail() {
      return this.email === '' || validateEmail(this.email);
    },
    isValidPwd() {
      return this.password === '' || validatePwd(this.password);
    },
    checkForm() {
      return validateEmail(this.email) && validatePwd(this.password);
    },
  },
  methods: {
    goToSignup() {
      this.$router.push({ name: 'Signup' });
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
    goToFindPassword() {
      this.$router.push({ name: 'FindPassword' });
    },
    async submitForm() {
      console.log('login');
      try {
        await this.$store.dispatch('LOGIN', {
          email: this.email,
          password: this.password,
        });
        console.log('이동');
        this.fireBaseLogin();
        setTimeout(() => {
          const whiteShow = document.querySelector('.white-show');
          whiteShow.classList.add('active');
        }, 1000);
        this.$router.push('/intro');
      } catch (error) {
        alert('이메일이나 비밀번호를 다시 확인해주세요.');
      }
    },
    fireBaseLogin() {
      console.log('login');
      FireBase.auth()
        .signInWithEmailAndPassword(this.email, this.password)
        .then(
          response => {
            console.log('response status', response);
          },
          error => (this.error = error.message),
        );
    },
  },
  mounted() {
    startAnimation();
    typing();
  },
};
</script>

<style scoped>
.home-wrapper {
  margin: 0;
  padding: 0;
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
  background: radial-gradient(ellipse at bottom, #1b2735 0%, #090a0f 100%);

  /* background-image: url('../../assets/image/sky3.png');
  background-position: 50% 50%;
  background-repeat: no-repeat;
  background-size: cover; */
}
.type {
  width: 100%;
  position: absolute;
  font-size: 2rem;
  top: 15%;
  left: 50%;
  color: #fff;
  transform: perspective(1200px) translate3d(-50%, 0, -200px);
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
} */

/* @keyframes move {
  0%,
  100% {
    transform: translateY(-40px);
  }
  50% {
    transform: translateY(40px);
  }
} */

/* .box .square:nth-child(1) {
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
  min-width: 25vw;
  /* max-width: 27vw; */
  min-height: 450px;
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  backdrop-filter: blur(15px);
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

.welcome {
  font-size: 20px;
  margin-bottom: 30px;
  color: #fff;
  font-weight: bold;
}

.title {
  color: #fff;
  margin: 15px 0 8px 5px;
  font-size: 13px;
}

.error_message {
  color: #fff;
  font-size: 5px;
  margin: 3px 0 20px 5px;
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

.go-to-signup-container {
  margin-top: 20px;
  float: right;
}

.go-to-signup {
  color: #fff;
  font-size: 10px;
  cursor: pointer;
}

.go-to-find-password-container {
  margin-top: 20px;
  float: left;
}

.go-to-find-password {
  color: #fff;
  font-size: 10px;
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

.white-show {
  position: absolute;
  top: 50%;
  left: 50%;
  opacity: 0;
  z-index: -1;
  width: 0%;
  height: 0%;
  border-radius: 100%;
  transform: translate3d(-50%, -50%, 1000px);
  /* transform-origin: 50% 50%; */
  background-color: #fff;
}

.active {
  animation: 0.45s fade forwards ease-in;
}

@keyframes fade {
  100% {
    width: 1000%;
    height: 2000%;
    opacity: 1;
    z-index: 30;
    transform: translate3d(-50%, -50%, -1000px);
  }
}
</style>
