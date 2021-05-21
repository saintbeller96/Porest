<template>
  <div>
    main page
    <div>
      <button @click="goToMailbox">우체통 페이지 바로가기</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToMailbox() {
      this.$router.push({ name: 'Mailbox' });
    },
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
};
</script>

<style scoped></style>
