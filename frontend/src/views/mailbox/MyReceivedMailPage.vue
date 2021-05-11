<template>
  <div class="received-mail-main-wrapper">
    <!-- <Star></Star> -->
    <div class="received-mail-inner-wrapper">
      받은편지함 페이지
      <div>
        답장 주고받기 바로가기
        <button @click="goToLetterReply">답장 주고받기 바로가기</button>
      </div>
    </div>
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';

export default {
  name: 'MyReceivedMailPage',
  components: {
    Star,
  },
  methods: {
    goToLetterReply() {
      this.$router.push({ name: 'LetterReply' });
    },
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
