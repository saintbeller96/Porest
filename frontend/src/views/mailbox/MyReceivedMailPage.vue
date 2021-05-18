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
                <div class="paper_header" v-text="getTitle()"></div>
                <div class="paper_content" v-text="getContent()"></div>
                <div class="paper_footer">
                  <div class="ban_btn">신고</div>
                </div>
              </div>
            </div>
            <div class="letter_form_wrapper">
              <div class="paper">
                <div class="paper_header">제목 작성하기 <input type="text" v-model="letter.body.title" /></div>
                <div class="paper_content">
                  내용 작성하기
                  <textarea name="" id="" v-model="letter.body.content"></textarea>
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
import { writeLetter, readLetter } from "@/api/letters";
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
      //TODO : 구조가 변경될 수도 있습니다. 변경되면 확인!
      selectedCounsel: {
        counselId: null,
        counsellorNickname: "반가운 전나무",
        detail: [
          {
            letter: {
              detail: {
                title: "",
                content: "",
                createAt: "",
              },
              letterId: "",
            },
            reply: {
              detail: {
                title: "",
                content: "",
                createAt: "",
              },
              letterId: "",
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
    getTitle() {
      let letters = this.$store.state.allLetters;
      if (letters === null) return null;
      else return letters.detail[0].reply.detail.title;
    },
    getContent() {
      let letters = this.$store.state.allLetters;
      if (letters === null) return null;
      else return letters.detail[0].reply.detail.title;
    },
    async ReplyForm() {
      //리플라이 null 예외처리 해야함
      this.letter.ids.counselId = this.$store.state.allLetters.counselId;
      this.letter.ids.letterId = this.$store.state.allLetters.detail[0].reply.letterId;
      await writeLetter(this.letter);
      await readLetter(this.letter);
    },
  },
  watch: {
    "$store.state.counselId": async function() {
      if (this.$store.state.counselId !== null)
        await this.$store.dispatch("saveAllLetters", await getCounsel(this.$store.state.counselId));
    },
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
