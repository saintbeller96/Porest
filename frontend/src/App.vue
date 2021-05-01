<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">메인페이지</router-link> | <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link> | <router-link to="/auth">디자인 적용</router-link> |

      <div to="#" @click="logout">로그 아웃</div>
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
      FireBase.auth()
        .signOut()
        .then(() => {
          console.log('logout');
          this.user = null;
          this.$router.push('/login');
        });
    },
  },
  mounted() {
    console.log('process', process.env.VUE_APP_FIREBASE_API_KEY);
    FireBase.auth().onAuthStateChanged(user => {
      if (user) {
        this.user = user;
        this.$store.dispatch('LOGIN', { userData: {}, firebaseData: this.user });
      }
    });
  },
};
</script>

<style src="@/assets/css/common/reset.css"></style>
