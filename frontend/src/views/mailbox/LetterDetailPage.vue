<template>
  <section>
    <header>
      레터 디테일 페이지
    </header>
    <article>
      <button @click="goToLetterReply">답장</button>
    </article>
  </section>
</template>

<script>
export default {
  methods: {
    goToLetterReply() {
      this.$router.push({ name: 'LetterReply' });
    },
  },
};
</script>

<style scoped></style>
