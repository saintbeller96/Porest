<template>
  <div class="received-mail-main-wrapper">
      받은편지함 페이지
       <div>
      답장 주고받기 바로가기
      <button @click="goToLetterReply">답장 주고받기 바로가기</button>
    </div>
  </div>
</template>

<script>
export default {
  methods:{
    goToLetterReply() {
      this.$router.push({ name: 'LetterReply'});
    },
  },

}
</script>

<style scoped src='@/assets/css/mail/MyReceivedMailPage.css'>

</style>