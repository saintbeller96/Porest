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
  top: 1rem;
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

/*--------- 폰트(명언용)----------- */
@font-face {  /*경기청년바탕*/
    font-family: 'GyeonggiBatang';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_one@1.0/GyeonggiBatang.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

/*------------ 폰트(굵은글씨용) -----------*/

@font-face { /*인피니티산스 ------> 메인 */
    font-family: 'InfinitySans-BoldA1';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/InfinitySans-BoldA1.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face { /*서평원꺾깎체------>서브메인 */
    font-family: 'SLEIGothicTTF';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2104@1.0/SLEIGothicTTF.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}


</style>
