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
      console.log(this.$router.history.current.name);
      this.$store.dispatch('LOGOUT');
      FireBase.auth()
        .signOut()
        .then(() => {
          console.log('logout');
          this.user = null;
          if (this.$router.history.current.name != 'Login') {
            this.$router.push('/login');
          }
        });
    },
  },
  mounted() {
    FireBase.auth().onAuthStateChanged(user => {
      if (user) {
        console.log('user login request');
        this.user = user;
        if (this.$store.state.uid == '') {
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
</style>
