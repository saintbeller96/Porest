<template>
  <div>
    내 우체통 페이지
    <p>편지 리스트 보여지는 곳</p>
    <div>
      <button @click="goToLetterDetail">편지 디테일 이동</button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToLetterDetail() {
      this.$router.push({ name: 'LetterDetail' });
    },
  },
};
</script>

<style scoped></style>
