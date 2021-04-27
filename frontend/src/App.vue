<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">메인페이지</router-link> | <router-link to="/login">로그인</router-link> |
      <router-link to="/signup">회원가입</router-link> |
      <router-link to="/auth">디자인 적용</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped></style>
