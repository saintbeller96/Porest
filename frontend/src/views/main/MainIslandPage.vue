<template>
  <div class="mainisland">
    <div class="main_wrapper">
      <div class="post_ground_wrapper">
        <div class="post_ground_container" @click="goToMailbox">
          <div class="post_island">
            <object :data="post_island" type="image/svg+xml"></object>
          </div>
        </div>
      </div>

      <div class="game_ground_wrapper">
        <div class="game_ground_container">
          <div class="game_island">
            <object :data="game_island" type="image/svg+xml"></object>
          </div>
        </div>
      </div>

      <div class="chat_ground_wrapper">
        <div class="chat_ground_container">
          <div class="chat_island">
            <object :data="chat_island" type="image/svg+xml"></object>
          </div>
        </div>
      </div>

      <div class="video_ground_wrapper">
        <div class="video_ground_container">
          <div class="video_island">
            <object :data="video_island" type="image/svg+xml"></object>
          </div>
        </div>
      </div>

      <div class="calender_ground_wrapper">
        <div class="calender_ground_container" @click="goToFeelingRecord">
          <div class="calender_island">
            <object :data="calender_island" type="image/svg+xml"></object>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      post_island: require('../../assets/svg/post_final.svg'),
      game_island: require('../../assets/svg/game_final.svg'),
      chat_island: require('../../assets/svg/chat_final.svg'),
      video_island: require('../../assets/svg/video_final.svg'),
      calender_island: require('../../assets/svg/calender_final.svg'),
    };
  },
  methods: {
    goToMailbox() {
      this.$router.push({ name: 'Mailbox' });
    },
    goToFeelingRecord() {
      this.$router.push({ name: 'FeelingRecord' });
      // console.log('!!');
    },
  },
};
</script>

<style scoped src="@/assets/css/main/MainIslandPage.css"></style>
