<template>
  <div class="received_mail_main_wrapper">
    <!-- <Star class="star"></Star> -->
    <div class="received_mail_inner_wrapper">
      <section class="received_mail_inner_left">
        <div class="section_header">
          <div class="header_btn" @click="openUserBoard(true)">위로 받기</div>
          <div class="header_btn" @click="openUserBoard(false)">위로 보내기</div>
        </div>
        <div class="section_body">
          <my-story-list v-if="viewStoryState"></my-story-list>
          <my-counsel-list v-else></my-counsel-list>
        </div>
      </section>

      <section class="received_mail_inner_right">
        <div class="write_reply"></div>
      </section>
    </div>
  </div>
</template>

<script>
import { getMyStories } from '@/api/stories';
import MyCounselList from '@/components/mail/MyCounselList.vue';
import MyStoryList from '@/components/mail/MyStoryList.vue';
import Star from '@/components/common/Star.vue';

export default {
  name: 'MyReceivedMailPage',
  data() {
    return {
      stories: null,
      viewStoryState: true,
    };
  },
  components: {
    Star,
    MyCounselList,
    MyStoryList,
  },
  methods: {
    goToLetterReply() {
      this.$router.push({ name: 'LetterReply' });
    },
    async getMyStories() {
      this.stories = await getMyStories();
    },
    openUserBoard(value) {
      this.viewStoryState = value;
    },
  },
  mounted() {
    console.log(this.stories);
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
