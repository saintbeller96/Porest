<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link to="/">메인페이지</router-link> | <router-link to="/login">로그인</router-link> | -->
      <!-- <router-link to="/signup">회원가입</router-link> | <router-link to="/auth">디자인 적용</router-link> | -->

      <div class="logout" @click="logout">로그 아웃</div>
    </div>
    <router-view :user="user" />
  </div>
</template>

<script>
import db from '@/db.js';
import FireBase from 'firebase/app';
import 'firebase/auth';

export default {
  name: 'App',
  data() {
    return {
      user: null,
      rooms: [],
    };
  },
  methods: {
    logout() {
      // :TODO 삭제요청
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
  },
  mounted() {
    FireBase.auth().onAuthStateChanged(user => {
      if (user) {
        console.log('user login request');
        this.user = user;
        if (this.$store.state.uid == '' || this.$store.state.uid == 'null') {
          this.$store.dispatch('saveuUserUid', { firebaseData: this.user });
        }
      }
    });
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
@font-face {   /*사랑해아들체*/
  font-family: 'Love_son';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_07@1.0/Love_son.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {    /*외할머니 글씨체*/
  font-family: 'Grandma_wring';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Grandma_wring.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {  /*어비 마이센체*/
  font-family: 'UhBeemysen';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_five@.2.0/UhBeemysen.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {  /*중학생체*/
  font-family: 'Middleschool_student';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_08@1.0/Middleschool_student.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {   /*느릿느릿체*/
  font-family: 'SlowSlow';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_10@1.0/SlowSlow.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}

@font-face {  /*손편지체*/
    font-family: 'Handletter';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_05@1.0/Handletter.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {  /*다시시작해체*/
    font-family: 'Restart';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_09@1.0/Restart.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
@font-face {   /*성실체*/
    font-family: 'Hardworking';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/naverfont_06@1.0/Hardworking.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


/*--------- 폰트(명언용)----------- */
@font-face {   /*카페24고운밤*/
    font-family: 'Cafe24Oneprettynight';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Oneprettynight.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {   /*마포꽃섬*/
    font-family: 'MapoFlowerIsland';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoFlowerIslandA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {   /*마포금빛나루*/
    font-family: 'MapoGoldenPier';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/MapoGoldenPierA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {  /*경기청년바탕*/
    font-family: 'GyeonggiBatang';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiBatang.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {    /*리디바탕*/
    font-family: 'RIDIBatang';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.0/RIDIBatang.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


@font-face {  /*미생체*/
    font-family: 'SDMiSaeng';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/SDMiSaeng.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {  /*빨간우체통*/
    font-family: '777Redpostbox';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_nine_@1.1/777Redpostbox.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}



/*------------ 폰트(굵은글씨용) -----------*/

@font-face { /*서평원꺾깎체*/
    font-family: 'SLEIGothicTTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SLEIGothicTTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {  /*카페24 단정해*/
    font-family: 'Cafe24Danjunghae';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Danjunghae.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {  /*에스코어드림*/
     font-family: 'S-CoreDream-8Heavy';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-8Heavy.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}

@font-face { /*인피니티산스*/
    font-family: 'InfinitySans-BoldA1';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/InfinitySans-BoldA1.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
</style>
