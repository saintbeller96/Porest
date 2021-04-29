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
};
</script>

<style scoped></style>
