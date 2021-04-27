<template>
  <div>
    mailbox page
    <div>
      편지 작성하기 페이지 바로가기
      <button @click="goToWriteLetterPage">편지 작성하기</button>
    </div>
    <br />
    <hr />
    <br />
    <div>
      나의 우체통 페이지 바로가기
      <button @click="goToMyMailbox">우체통 바로가기</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToWriteLetterPage() {
      this.$router.push({ name: 'WriteLetter' });
    },
    goToMyMailbox() {
      this.$router.push({ name: 'MyMailbox' });
    },
  },
};
</script>

<style scoped></style>
