<template>
  <div>
    mailbox page
    <div>
      편지 작성하기 페이지 바로가기
      <button @click="goToStoryLetterPage">편지 작성하기</button>
    </div>
    <br />
    <hr />
    <br />
    <div>
      랜덤 뽑기 바로가기
      <button @click="goToRandomMail">랜덤 뽑기 바로가기</button>
    </div>
    <br />
    <hr />
    <br />
    <div>
      받은 편지함 바로가기(답장하러가기)
      <button @click="goToMyReceivedMail">받은 편지함 바로가기</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToStoryLetterPage() {
      this.$router.push({ name: "WriteStory" });
    },
    goToRandomMail() {
      this.$router.push({ name: "RandomMail" });
    },
    goToMyReceivedMail() {
      this.$router.push({ name: "MyReceivedMail" });
    },
  },
};
</script>

<style scoped></style>
