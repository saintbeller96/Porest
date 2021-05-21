<template>
  <div class="received_mail_main_wrapper">
    <!-- <Star class="star"></Star> -->
    <span @click="moveToBack" class="back">
      <i class="fas fa-arrow-left"></i>
    </span>
    <!-- <div>
      <i class="backarrow fas fa-arrow-left" @click="moveToBack"></i>
    </div> -->
    <div class="received_mail_inner_wrapper">
      <section class="received_mail_inner_left">
        <div class="section_header">
          <div class="header_btn1" @click="openUserBoard(true)">내 사연</div>
          <div class="header_btn2" @click="openUserBoard(false)">
            내 답장
          </div>
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
            <div class="letter_form_wrapper1">
              <div class="paper">
                <div class="paper_header" v-text="getTitle()"></div>
                <div class="paper_content" v-html="getContent()"></div>
                <div class="paper_footer">
                  <div class="finish__mail" @click="finishLetter">
                    사연 끝내기
                  </div>
                  <div class="ban_btn" :data-value="getCounselId()" @click="ban">
                    신고
                  </div>
                </div>
              </div>
            </div>

            <div class="letter_form_wrapper2">
              <div class="paper">
                <div class="paper_header2">답장 제목<input type="text" v-model="letter.body.title" /></div>
                <div class="paper_content2">
                  답장 내용
                  <textarea name="" id="" v-model="letter.body.content"></textarea>
                </div>
                <div class="paper_footer">
                  <div class="reply_btn" @click="ReplyForm">보내기</div>
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
    <finish-modal v-if="finishState" :counselId="counselId" @exit="exit"></finish-modal>
    <ban-modal v-if="banState" :counselId="counselId" @exit="exit"></ban-modal>
  </div>
</template>

<script>
import { writeLetter, readLetter } from "@/api/letters";
import { getCounsel } from "@/api/counsels";
import MyCounselList from "@/components/mail/MyCounselList.vue";
import MyStoryList from "@/components/mail/MyStoryList.vue";
import AllLetters from "@/components/mail/AllLetters.vue";
import FinishModal from "@/components/mail/FinishModal.vue";
import BanModal from "@/components/mail/BanModal.vue";
import Star from "@/components/common/Star.vue";

export default {
  name: "MyReceivedMailPage",
  data() {
    return {
      banState: false,
      finishState: false,
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
      selectedCounsel: {
        counselId: null,
        counsellorNickname: "",
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
      counselId: null,
    };
  },
  components: {
    Star,
    MyCounselList,
    MyStoryList,
    AllLetters,
    FinishModal,
    BanModal,
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == "" || token == null) {
      alert("로그인이 필요합니다.");
      this.$router.push({ name: "Login" });
    }
  },
  methods: {
    exit() {
      this.finishState = false;
      this.banState = false;
    },
    ban() {
      this.banState = true;
    },
    finishLetter() {
      this.finishState = true;
    },
    goToLetterReply() {
      this.$router.push({ name: "LetterReply" });
    },
    openUserBoard(value) {
      this.viewStoryState = value;
      const headerBtn1 = document.querySelector(".header_btn1");
      const headerBtn2 = document.querySelector(".header_btn2");
      if (value === true) {
        headerBtn1.classList.add("click");
        headerBtn2.classList.remove("click");
      } else {
        headerBtn1.classList.remove("click");
        headerBtn2.classList.add("click");
      }
    },
    openAll() {
      this.openAllLetters = true;
    },
    exitAll() {
      this.openAllLetters = false;
    },
    moveToBack() {
      this.$router.go(-1);
    },
    getTitle() {
      let letters = this.$store.state.allLetters;
      if (letters == null || letters.detail[0].reply == null) return null;
      else return letters.detail[0].reply.detail.title;
    },
    getContent() {
      let letters = this.$store.state.allLetters;
      console.log(letters);
      if (letters === null || letters.detail[0].reply == null) return null;
      else return letters.detail[0].reply.detail.content;
    },
    getCounselId() {
      this.counselId = this.$store.state.allLetters;
      if (this.counselId == null) return null;
      else return this.counselId.counselId;
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
  mounted() {
    this.openUserBoard(true);
    const headerBtn1 = document.querySelector(".header_btn1");
    headerBtn1.classList.add("click");
  },
};
</script>

<style scoped src="@/assets/css/mail/MyReceivedMailPage.css"></style>
