<template>
  <div>
    다이어리
    <p>{{ getTargetDate[1] }}월 {{ getTargetDate[2] }}일</p>
  </div>
</template>

<script>
export default {
  props: {
    getTargetDate: Array,
  },
};
</script>

<style scoped></style>
