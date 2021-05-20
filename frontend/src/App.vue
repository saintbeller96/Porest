<template>
  <div id="app">
    <div v-if="$store.state.logoStatus" class="logo" @click="goToMain">
      <img src="@/assets/image/logo.png" />
    </div>
    <nav id="nav">
      <button class="nav-icon" id="nav-icon"><span></span></button>
      <ul v-if="$store.state.id" class="nav_ul">
        <li>
          <span class="nav-detail" @click="goToMailbox">우체통</span>
        </li>
        <li>
          <span class="nav-detail" @click="goToFeelingRecord">하루일기</span>
        </li>
        <li><span class="nav-detail" @click="goToVideoChat">마음나눔</span></li>
        <li><span class="nav-detail">하소연</span></li>
        <li><span class="nav-detail" @click="goToJoy">쉼터</span></li>
        <li @click="logout">로그아웃</li>
      </ul>
      <ul v-else class="nav_ul">
        <li>로그인</li>
      </ul>
    </nav>
    <router-view :user="user" />
  </div>
</template>

<script>
import db from '@/db.js';
import FireBase from 'firebase/app';
import 'firebase/auth';
import { init } from '@/assets/js/common/Nav.js';
export default {
  name: 'App',
  data() {
    return {
      user: null,
      rooms: [],
      loginState: false,
    };
  },
  methods: {
    logout() {
      // :TODO 삭제요청
      this.loginState = false;
      console.log('logout', this.$router.history.current.name);
      this.$store.dispatch('LOGOUT');
      FireBase.auth()
        .signOut()
        .then(() => {
          console.log('logout');
          this.user = null;
          if (this.$router.history.current.name != 'Login') {
            this.$router.push('/log/login');
          }
        });
    },
    goToMain() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push('/main/mainisland');
    },
    goToMailbox() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push('/mailbox');
    },
    goToFeelingRecord() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push('/feeling-record');
    },
    goToVideoChat() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push('/all/rooms');
    },
    goToJoy() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push('/joy');
    },
  },
  mounted() {
    init();
    FireBase.auth().onAuthStateChanged(user => {
      if (user) {
        console.log('user login request');
        this.loginState = !this.loginState;
        this.user = user;
        if (this.$store.state.uid == '' || this.$store.state.uid == 'null') {
          this.$store.dispatch('saveuUserUid', { firebaseData: this.user });
        }
      }
    });
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      this.$router.push({ name: 'Login' });
    } else {
      this.loginState = true;
    }
  },
};
</script>

<style src="@/assets/css/common/reset.css"></style>
<style>
.logout {
  position: fixed;
  width: 3rem;
  height: 3rem;
  bottom: 1rem;
  right: 1rem;
  z-index: 200;
  color: white;
}
@import '../node_modules/@syncfusion/ej2-base/styles/material.css';
@import '../node_modules/@syncfusion/ej2-buttons/styles/material.css';
@import '../node_modules/@syncfusion/ej2-popups/styles/material.css';
@import '../node_modules/@syncfusion/ej2-splitbuttons/styles/material.css';
@import '../node_modules/@syncfusion/ej2-inputs/styles/material.css';

/*-------- 폰트  (손글씨용)--------------*/
@font-face {
  /*사랑해아들체*/
  font-family: 'Love_son';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_07@1.0/Love_son.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

/*--------- 폰트(명언용)----------- */
@font-face {
  /*경기청년바탕*/
  font-family: 'GyeonggiBatang';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiBatang.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

/*------------ 폰트(굵은글씨용) -----------*/

@font-face {
  /*인피니티산스 ------> 메인 */
  font-family: 'InfinitySans-BoldA1';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/InfinitySans-BoldA1.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {
  /*서평원꺾깎체------>서브메인 */
  font-family: 'SLEIGothicTTF';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SLEIGothicTTF.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}

.nav-detail {
  color: inherit;
  text-decoration: none;
}

.logo {
  position: absolute;
  top: 0.6vh;
  left: 1rem;
  cursor: pointer;
  z-index: 100;
}

.logo img {
  width: 10vw;
}

#nav {
  position: absolute;
  top: 1rem;
  right: 1rem;
  /*  이거 떄문에 메뉴색이 배경 마다 바뀜*/
  /*    mix-blend-mode: difference;*/
  cursor: pointer;
  z-index: 100;
}

#nav a .r_rated {
  color: red;
}
.nav_ul {
  position: fixed;
  top: 45px;
  right: 6px;
  height: 100vh;
  z-index: 100;
  color: #fff;
  visibility: hidden;
  pointer-events: none;
  list-style: none;
  width: 35px;
}

.nav_ul li {
  text-transform: uppercase;
  letter-spacing: 2px;
  padding: 0.75em 0;
  writing-mode: vertical-lr;
  font-size: 1.1rem;
  font-family: 'InfinitySans-BoldA1';
  letter-spacing: 0.4rem;
}

nav.active ul {
  visibility: visible;
  pointer-events: initial;
  transition-delay: 0.2s;
}

.nav-icon {
  appearance: none;
  background: transparent;
  cursor: pointer;
  display: inline-block;
  height: 35px;
  position: fixed;
  top: 15px;
  right: 15px;
  transition: background 0.3s;
  width: 35px;
  border: 0;
  outline: 0;
  color: #fff;
}

.nav-icon span {
  position: absolute;
  top: 15px;
  left: 5px;
  background: #fff;

  display: block;
  height: 3px;
  right: 5px;
  transition: transform 0.3s;
}

.nav-icon span:before,
.nav-icon span:after {
  width: 100%;
  height: 3px;
  background: #fff;

  content: '';
  display: block;
  left: 0;
  position: absolute;
}

.nav-icon span:before {
  top: -8px;
}

.nav-icon span:after {
  bottom: -8px;
}

.active .nav-icon span {
  transform: rotate(90deg);
}
</style>
