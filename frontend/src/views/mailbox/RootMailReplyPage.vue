<template>
  <div class="root-mail-reply-wrapper">
    <div class="envelope new">
      <div class="front">
        <div class="stamp"></div>
        <div class="mailme mail_reply_title">
          <p v-text="$store.state.selectedStory.detail.title"></p>
        </div>
      </div>

      <div class="back">
        <div class="letter">
          <div class="root-mail">
            <p v-text="$store.state.selectedStory.detail.content"></p>

            <div class="btnReply">답장하기</div>
          </div>
        </div>

        <div class="flap left-flap"></div>
        <div class="flap right-flap"></div>
        <div class="flap bottom-flap"></div>
        <div class="flap top-flap"></div>
      </div>
    </div>

    <div class="envelope open reply">
      <div class="front">
        <div class="stamp"></div>
        <div class="mailme">
          <p class="p_title">당신의 소중한 답장</p>
          <p class="p_subtitle">porest가 전해드립니다.</p>
        </div>
      </div>

      <div></div>

      <div class="back">
        <div class="letter">
          <div class="root-mail-reply">
            <form class="mailform">
              <div>
                <label for="reply_title">답장 제목</label>
                <input type="text" name="reply_title" size="40" placeholder="답장의 제목을 적어주세요." v-model="letter.body.title" />
              </div>
              <div>
                <label for="reply_content">답장 내용</label>
                <textarea
                  name="reply_content"
                  cols="40"
                  rows="5"
                  placeholder="답장의 내용을 적어주세요. (여러분의 말 한마디가 소중합니다.)"
                  v-model="letter.body.content"
                ></textarea>
              </div>
              <div>
                <input class="sendBtns" type="submit" value="보내기" @click="reply()" />
              </div>
            </form>
          </div>
        </div>

        <div class="flap left-flap"></div>
        <div class="flap right-flap"></div>
        <div class="flap bottom-flap"></div>
        <div class="flap top-flap"></div>
      </div>
    </div>
  </div>
</template>

<script>
import { init } from "@/assets/js/mail/RootMailReplyPage.js";
import { selectStory } from "@/api/stories";
import { writeLetter } from "@/api/letters";
export default {
  name: "RootMailReply",
  data() {
    return {
      story: {
        counselId: 0,
        //TODO : 데이터 구조 변경 될 수 있음 확인 꼭하기
        detail: {
          detail: {
            content: "",
            createAt: "",
            title: "",
          },
          letterId: 0,
        },
      },
      letter: {
        ids: {
          counselId: null,
          letterId: null,
        },
        body: {
          content: "",
          createAt: "",
          title: "",
        },
      },
    };
  },
  methods: {
    async getStory(storyId) {
      this.story = await selectStory(storyId);
    },
    async reply() {
      await this.getStory(this.$store.state.selectedStory.storyId);
      this.letter.ids.counselId = this.story.counselId;
      this.letter.ids.letterId = this.story.detail.letterId;
      await writeLetter(this.letter);
      //여기서 페이지 이동코드 넣어주세요~!
      this.$router.push({name :'Mailbox' });
    },
  },
  mounted() {
    init();
  },
};
</script>

<style scoped src="@/assets/css/mail/RootMailReply.css"></style>
