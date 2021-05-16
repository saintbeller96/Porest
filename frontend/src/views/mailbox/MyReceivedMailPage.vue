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
        <div class="root_mail_header"></div>
        <div class="write_reply">
          <div class="letter_paper">
            <div class="letter_form_wrapper">
              <div class="paper">
                <div class="paper_header" v-text="selectedCounsel.detail[0].reply.title"></div>
                <div class="paper_content" v-text="selectedCounsel.detail[0].reply.content"></div>
                <div class="paper_footer">
                  <div class="ban_btn">신고</div>
                </div>
              </div>
            </div>
            <div class="letter_form_wrapper">
              <div class="paper">
                <div class="paper_header">제목 작성하기 <input type="text" v-model="reply.content" /></div>
                <div class="paper_content">
                  내용 작성하기
                  <textarea name="" id=""></textarea>
                </div>
                <div class="paper_footer">
                  <!-- 벤 버튼인데 답장 보내기..라고 써있어요ㅠㅠ! -->
                  <div class="ban_btn" @click="ReplyForm">답장 보내기</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <div class="box-wrapper">
        <div class="box" @click="openAll">
          <div class="side-1">
            <div class="side inner-side flap-1"></div>
            <div class="side inner-side flap-2"></div>
          </div>
          <div class="side side-2">모든 편지보기</div>
          <div class="side side-3"></div>
          <div class="side side-4"></div>
          <div class="side side-5"></div>
          <div class="side side-6"></div>
          <span class="box_papers"></span>
          <span class="box_papers"></span>
          <span class="box_papers"></span>
          <span class="box_papers"></span>
          <span class="box_papers"></span>
          <span class="box_papers"></span>
        </div>
      </div>
    </div>
    <all-letters v-if="openAllLetters" @exitAll="exitAll" class="all_letters"></all-letters>
  </div>
</template>

<script>
import { writeStory } from "@/api/stories";
import { getCounsel } from "@/api/counsels";
import MyCounselList from "@/components/mail/MyCounselList.vue";
import MyStoryList from "@/components/mail/MyStoryList.vue";
import AllLetters from "@/components/mail/AllLetters.vue";
import Star from "@/components/common/Star.vue";

export default {
  name: "MyReceivedMailPage",
  data() {
    return {
      stories: null,
      viewStoryState: true,
      openAllLetters: false,
      reply: {
        title: "",
        content: "",
      },

      selectedCounsel: {
        detail: [
          {
            letter: {
              title: "",
              content: "",
              createAt: "",
            },
            reply: {
              title: "",
              content: "",
              createAt: "",
            },
          },
        ],
      },
    };
  },
  components: {
    Star,
    MyCounselList,
    MyStoryList,
    AllLetters,
  },
  methods: {
    goToLetterReply() {
      this.$router.push({ name: "LetterReply" });
    },
    openUserBoard(value) {
      this.viewStoryState = value;
    },
    openAll() {
      this.openAllLetters = true;
    },
    exitAll() {
      this.openAllLetters = false;
    },
    async ReplyForm() {
      //리플라이 null 예외처리 해야함
      //여기에 들어가야 하는 것은 답장(letter)인데 api 수정 부탁해야함
    },
  },
  mounted() {
    console.log(this.stories);
  },
  watch: {
    "$store.state.counselId": async function() {
      this.selectedCounsel = await getCounsel(this.$store.state.counselId);
    },
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
