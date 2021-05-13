<template>
  <div class="random-mail">
    <!-- <section>
      <div class="card">
        <div class="wrapper">
          <div class="box" v-for="(story, index) in stories" :key="index">
            <div class="box-container">
              <h2>{{ story.detail.title }}</h2>
              <p>{{ story.detail.content }}</p>
              <div @click="goToRootMailReply(story.storyId)">읽으러 가기</div>
            </div>
          </div>
        </div>
      </div>
    </section> -->
  </div>
</template>

<script>
import { getCandidatesOfStories } from '@/api/stories';
export default {
  name: 'RandomMail',
  data() {
    return {
      randomMails: [1, 2, 3, 4, 5, 6],
      stories: [],
    };
  },
  methods: {
    async getRandomStories() {
      this.stories = await getCandidatesOfStories();
    },
    goToRootMailReply(id) {
      this.$router.push({ name: 'RootMailReply', params: { storyId: id } });
    },
  },
  mounted() {
    this.getRandomStories();
  },
};
</script>

<style scoped src="@/assets/css/mail/RandomMail.css"></style>
