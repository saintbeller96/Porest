<template>
  <div class="received_mail_main_wrapper">
    <!-- <Star class="star"></Star> -->
    <div class="received_mail_inner_wrapper">
      <section class="received_mail_inner_left">
        <div class="section_header">
          <div class="header_btn">위로 받기</div>
          <div class="header_btn">위로 보내기</div>
        </div>
      </section>
      받은편지함 페이지
      <div>
        답장 주고받기 바로가기
        <button @click="goToLetterReply">답장 주고받기 바로가기</button>
      </div>
    </div>
  </div>
</template>

<script>
import { getMyStories } from '@/api/stories';

import Star from '@/components/common/Star.vue';

export default {
  name: 'MyReceivedMailPage',
  data() {
    return {
      stories: null,
    };
  },
  components: {
    Star,
  },
  methods: {
    goToLetterReply() {
      this.$router.push({ name: 'LetterReply' });
    },
    async getMyStories() {
      this.stories = await getMyStories();
    },
  },
  mounted() {
    console.log(this.stories);
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
