<template>
  <div class="write-letter-wrapper">
    <span @click="moveToBack" class="back">
      <i class="fas fa-arrow-left"></i>
    </span>
    <div class="envelope open">
      <div class="front">
        <div class="stamp"></div>
        <div class="mailme">
          <p>당신의 고민을 담은 편지</p>
          <p>porest가 전해드립니다</p>
        </div>
      </div>

      <div class="back">
        <div class="letter">
          <form class="mailform">
            <div>
              <label for="title">제목</label>
              <input
                class="titleinput"
                type="text"
                name="title"
                size="40"
                v-model="story.title"
                placeholder="고민의 제목을 적어주세요"
              />
            </div>
            <div>
              <label for="content">내용</label>
              <textarea
                name="content"
                cols="40"
                rows="5"
                v-model="story.content"
                placeholder="고민을 남겨주세요"
              ></textarea>
            </div>
            <div>
              <input
                class="sendBtn"
                type="submit"
                value="보내기"
                @click="storyForm"
              />
            </div>
          </form>
        </div>
        <div class="flap left-flap"></div>
        <div class="flap right-flap"></div>
        <div class="flap bottom-flap"></div>
        <div class="flap top-flap"></div>
      </div>
    </div>

    <div class="notification">
      <div class="noti_title">당신의 고민이 전송되었습니다.</div>
    </div>
  </div>
</template>

<script>
import { writeStory } from '@/api/stories';
import { init } from '@/assets/js/mail/WriteLetterPage.js';
export default {
  name: 'WriteLetterPage',
  data() {
    return {
      story: {
        title: '',
        content: '',
        createAt: '',
      },
    };
  },
  methods: {
    async storyForm() {
      this.conversion();
      await writeStory(this.story);
      setTimeout(() => {
        this.$router.push({ name: 'Mailbox' });
      }, 3500);
    },
    moveToBack() {
      this.$router.go(-1);
    },
    conversion() {
      let str = this.story['content'];
      str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
      this.story['content'] = str;
    },
  },
  mounted() {
    init();
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
};
</script>

<style scoped src="@/assets/css/mail/WriteLetterPage.css"></style>
