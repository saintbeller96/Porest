<template>
  <div class="mailbox-wrapper">
   
    <!-- <button @click="goToLetterDetail">편지 디테일 이동</button> -->
    
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

<style scoped>


</style>
