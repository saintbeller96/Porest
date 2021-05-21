<template>
  <div id="app">
    <audio id="audio-player1" loop="false">
      <source src="../src/assets/audio/introvoice.mp3" type="audio/mpeg" />
      <p class="sr-only">
        Your browser does not support the audio element.
      </p>
    </audio>
    <div class="music__player">
      <div class="music-player__wrapper">
        <div class="music-player music-player--disabled" id="music-container">
          <audio id="audio-player" loop>
            <source
              src="../src/assets/audio/backgroundMusic.mp3"
              type="audio/mpeg"
            />
            <p class="sr-only">
              Your browser does not support the audio element.
            </p>
          </audio>

          <div class="music-player__bar music-player__bar1"></div>
          <div class="music-player__bar music-player__bar2"></div>
          <div class="music-player__bar music-player__bar3"></div>
          <div class="music-player__bar music-player__bar4"></div>

          <button
            @click.prevent="controlMusic('play')"
            class="music-player__button music-player__play"
          >
            <span class="sr-only">Play</span>
          </button>
          <button
            @click.prevent="controlMusic('pause')"
            class="music-player__button music-player__pause"
          >
            <span class="sr-only">Pause</span>
          </button>
        </div>
      </div>
    </div>
    <nav id="nav">
      <button class="nav-icon" id="nav-icon"><span></span></button>
      <ul v-if="$store.state.id" class="nav_ul">
        <li @click="goToMain">
          <span class="nav-detail">홈</span>
        </li>
        <li @click="goToMailbox">
          <span class="nav-detail">우체통</span>
        </li>
        <li @click="goToFeelingRecord">
          <span class="nav-detail">하루일기</span>
        </li>
        <li @click="goToVideoChat"><span class="nav-detail">마음나눔</span></li>
        <li @click="goToJoy"><span class="nav-detail">쉼터</span></li>
        <li @click="logout" class="nav-detail">로그아웃</li>
      </ul>
      <ul v-else class="nav_ul">
        <li>로그인</li>
      </ul>
    </nav>
    <router-view
      :user="user"
      @introState="introState"
      @introPlay="introPlay"
      @controlMusic="controlMusic"
      @skip="skip"
    />
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
      introState: false,
    };
  },
  methods: {
    skip() {
      const audioPlayer1 = document.querySelector('#audio-player1');
      audioPlayer1.pause();
      this.$router.push({ name: 'MainIsland' });
    },
    logout() {
      // :TODO 삭제요청
      this.loginState = false;
      this.$store.dispatch('LOGOUT');
      FireBase.auth()
        .signOut()
        .then(() => {
          this.user = null;
          if (this.$router.history.current.name != 'Login') {
            this.$router.push({ name: 'Login' });
          }
        });
    },
    goToMain() {
      let nav = document.getElementById('nav');
      nav.classList.remove('active');
      this.$router.push({ name: 'MainIsland' });
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
    controlMusic(playState) {
      const audioPlayer = document.querySelector('#audio-player');
      const audioContainer = document.querySelector('#music-container');
      if (playState != 'play') {
        audioContainer.classList.add('music-player--disabled');
        audioPlayer.pause();
      } else {
        audioPlayer.play();
        audioContainer.classList.remove('music-player--disabled');
      }
    },
    introPlay() {
      const audioPlayer1 = document.querySelector('#audio-player1');
      setTimeout(() => {
        audioPlayer1.play();
      }, 150);
      setTimeout(() => {
        audioPlayer1.pause();
      }, 5650);
    },
  },
  mounted() {
    init();
    const audioPlayer = document.querySelector('#audio-player');
    const audioPlayer1 = document.querySelector('#audio-player1');

    FireBase.auth().onAuthStateChanged(user => {
      if (user) {
        this.loginState = !this.loginState;
        this.user = user;
        if (this.$store.state.uid == '' || this.$store.state.uid == 'null') {
          this.$store.dispatch('saveuUserUid', { firebaseData: this.user });
        }
      }
    });
  },
  created() {
    // let token = this.$store.getters.getAuthToken;
    // if (token == '' || token == null) {
    //   this.$router.push({ name: 'Login' });
    // } else {
    //   this.loginState = true;
    // }
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

.music-player {
  width: 30px;
  height: 20px;
  margin-top: 1rem;
  /* padding: 1rem; */
  position: relative;
  opacity: 1;
  transition: opacity 200ms;
}

.music-player.music-player--disabled {
  opacity: 0.26;
}

.music-player__wrapper {
  position: fixed;
  left: 1rem;
  bottom: 1rem;
  z-index: 30;
}

.music-player__button {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: transparent;
  z-index: 1;
  width: 100%;
  border: 0;
  cursor: pointer;
}

.music-player__play {
  background: transparent;
  display: none;
}

.music-player--disabled .music-player__play {
  display: block;
}

.music-player--disabled .music-player__pause {
  display: none;
}

.music-player__bar {
  background: #fff;
  width: 5px;
  height: 60%;
  position: absolute;
  bottom: 0;
  animation-name: music-bar-anim;
  animation-iteration-count: infinite;
  pointer-events: none;
  border: 0.3px solid rgba(0, 0, 0, 0.8);
}

.music-player--disabled .music-player__bar {
  animation-play-state: paused;
}

.music-player__bar1 {
  animation-duration: 1.3s;
  left: 0;
}

.music-player__bar2 {
  animation-duration: 1.8s;
  left: 7px;
}

.music-player__bar3 {
  animation-duration: 2.2s;
  left: 14px;
}

.music-player__bar4 {
  animation-duration: 2s;
  left: 21px;
}

@keyframes music-bar-anim {
  0% {
    height: 15px;
  }
  50% {
    height: 30px;
  }
  100% {
    height: 8px;
  }
}

.sr-only {
  clip: rect(1px, 1px, 1px, 1px);
  height: 1px;
  overflow: hidden;
  position: absolute;
  width: 1px;
}

.logout {
  color: red;
}
</style>
