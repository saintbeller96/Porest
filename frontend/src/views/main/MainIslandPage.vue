<template>
  <div class="mainisland">
    <div class="short-profile">
      <profile-for-main></profile-for-main>
    </div>
    <!-- <div class="white-background"></div> -->
    <Star class="star"></Star>
    <div class="main_wrapper">
      <div class="post_ground_wrapper">
        <div class="post_ground_container" @click="goToMailbox">
          <div class="paper-plane">
            <img src="@/assets/image/plane2.svg" alt="" />
          </div>
          <!-- <div class="paper-plane-2"><img src="@/assets/image/plane2.svg" alt="" /></div> -->
          <div class="post_island">
            <object :data="post_island" type="image/svg+xml"></object>
          </div>
        </div>
        <object class="postbox" :data="postbox" type="image/svg+xml"></object>
      </div>

      <div class="game_ground_wrapper">
        <div class="game_ground_container" @click="goToJoy">
          <div class="pointer-game"></div>
          <div class="game_island">
            <object :data="game_island" type="image/svg+xml"></object>
          </div>
          <object class="healing" :data="healing" type="image/svg+xml"></object>
        </div>
      </div>

      <div class="chat_ground_wrapper">
        <div class="chat_ground_container" @click="goToGurumi">
          <form class="gurumi" @submit.prevent></form>
          <div class="pointer-chat"></div>
          <div class="chat_island">
            <object :data="chat_island" type="image/svg+xml"></object>
          </div>
          <object class="gurumi" :data="gurumi" type="image/svg+xml"></object>
        </div>
      </div>

      <div class="video_ground_wrapper">
        <div class="video_ground_container" @click="goToAllRooms">
          <div class="pointer-video"></div>

          <div class="video_island">
            <object :data="video_island" type="image/svg+xml"></object>
          </div>
          <object
            class="chatroom"
            :data="chatroom"
            type="image/svg+xml"
          ></object>
        </div>
      </div>

      <div class="calender_ground_wrapper">
        <div class="calender_ground_container" @click="goToFeelingRecord">
          <div class="pointer-calender"></div>
          <div class="calender_island">
            <object :data="calender_island" type="image/svg+xml"></object>
          </div>
          <object
            class="calenderflag"
            :data="calenderflag"
            type="image/svg+xml"
          ></object>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';
import ProfileForMain from '@/components/main/ProfileForMain.vue';
export default {
  data() {
    return {
      post_island: require('../../assets/svg/post_final.svg'),
      game_island: require('../../assets/svg/game_final.svg'),
      chat_island: require('../../assets/svg/chat_final.svg'),
      video_island: require('../../assets/svg/video_final.svg'),
      calender_island: require('../../assets/svg/calender_final.svg'),
      postbox: require('../../assets/svg/postbox.svg'),
      calenderflag: require('../../assets/svg/calenderflag.svg'),
      gurumi: require('../../assets/svg/Gurumi.svg'),
      healing: require('../../assets/svg/healing.svg'),
      chatroom: require('../../assets/svg/chatRoom.svg'),
    };
  },
  components: {
    Star,
    ProfileForMain,
  },
  methods: {
    goToJoy() {
      this.$router.push({ name: 'JoyMainPage' });
    },
    goToGurumi() {
      const form = document.querySelector('.gurumi');
      form.action = 'https://live.porest.kr/secret';
      form.method = 'POST';
      form.target = 'pop';
      window.open('', 'pop');
      form.submit();
    },
    goToMailbox() {
      this.$router.push({ name: 'MailBoxIntro' });
    },
    goToFeelingRecord() {
      this.$router.push({ name: 'FeelingRecord' });
    },
    goToAllRooms() {
      this.$router.push({ name: 'AllRoom' });
    },
  },
  mounted() {
    const mainislandWrapper = document.querySelector('.main_wrapper');
    const mainisland = document.querySelector('.mainisland');
    // const whiteBg = document.querySelector('.white-background');
    mainisland.classList.add('show');
    mainislandWrapper.classList.add('show');
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

<style scoped src="@/assets/css/main/MainIslandPage.css"></style>
