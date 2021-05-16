<template>
  <div class="mail_box_main_wrapper">
    <div class="title">민지의 우체통</div>
    <div class="postmenu_wrapper">
      <div class="postmenu1" @click="goToStoryLetterPage">
        <div class="postmenu1_content">
          <h1 class="postmenu1_title">편지쓰기</h1>
          <h2 class="postmenu1_subtitle">당신의 고민은 무엇인가요?</h2>

          <div class="pen_wrapper">
            <img class="pen_img" src="@/assets/image/pen.png" alt="" />
          </div>
        </div>
      </div>

      <div class="postmenu2" @click="goToRandomMail">
        <div class="postmenu2_content">
          <h1 class="postmenu2_title">랜덤 우체통</h1>
          <h2 class="postmenu2_subtitle">당신의 경험을 공유해주세요.</h2>

          <div class="letter_wrapper">
            <img class="letter_img" src="@/assets/image/letter.png" alt="" />
          </div>
          <div class="letter_wrapper2">
            <img class="letter2_img" src="@/assets/image/letter.png" alt="" />
          </div>
        </div>
      </div>
      <div class="postmenu3" @click="goToMyReceivedMail">
        <div class="postmenu3_content">
          <h1 class="postmenu3_title">우편함</h1>
          <h2 class="postmenu3_subtitle">편지에 고민을 담아 주고받아요.</h2>

          <div class="post_wrapper">
            <img class="post_img" src="@/assets/image/postbox.png" alt="" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToStoryLetterPage(e) {
      console.log(e.target);
      e.target.classList.add('click1');
      setTimeout(() => {
        this.$router.push({ name: 'WriteLetter' });
      }, 100);
    },
    goToRandomMail(e) {
      e.target.classList.add('click2');
      setTimeout(() => {
        this.$router.push({ name: 'RandomMail' });
      }, 100);
    },
    goToMyReceivedMail(e) {
      e.target.classList.add('click3');
      setTimeout(() => {
        this.$router.push({ name: 'MyReceivedMail' });
      }, 100);
    },
  },
};
</script>

<style scoped src="@/assets/css/mail/MailBoxPage.css"></style>
