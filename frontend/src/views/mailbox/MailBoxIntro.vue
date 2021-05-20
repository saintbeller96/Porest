<template>
  <div class="mail_box_intro_wrapper">
    <div class="bottom">
      <img src="../../assets/image/letters.png" alt="" />
    </div>
    <div class="post_plane_main">
      <div id="planesvg" class="planesvg">
        <img src="@/assets/image/plane2.svg" alt="" />
      </div>
    </div>
    <div class="post_main_wrapper">
      <div class="post_main post_main_container">
        <div class="post_main_wall post_wall_back"></div>
        <div class="post_main_wall post_wall_left"></div>
        <div class="post_main_wall post_wall_right"></div>
        <div class="post_main_wall post_wall_bottom"></div>
      </div>
      <div class="white_paper"></div>
      <div id="container-1">
        <svg
          version="1.1"
          width="20rem"
          height="20rem"
          xml:space="preserve"
          xmlns="http://www.w3.org/2000/svg"
          xmlns:xlink="http://www.w3.org/1999/xlink"
        >
          <g id="plane">
            <polygon
              id="top_left_wing"
              points="150,150, 150,0, 0,150"
              style="fill:#ffffff;"
            />
            <polygon
              id="top_right_wing"
              points="150,0 150,150 300,150"
              style="fill:#ffffff;"
            />
            <polygon
              id="left_wing"
              points="150,0 90,150 0,150"
              style="fill:#ffffff;"
            />
            <polygon
              id="right_wing"
              points="150,0 210,150 300,150"
              style="fill:#ffffff;"
            />
            <polygon
              id="left_bottom"
              points="0,150 150,150 150,190 90,150"
              style="fill:#ffffff;"
              stroke-width="0.5"
            />
            <polygon
              id="right_bottom"
              points="150,150 300,150 210,150 150,190"
              style="fill:#ffffff;"
              stroke-width="0.5"
            />

            <polygon
              id="left_inside_wing"
              points="150,0 210,150 150,190"
              fill="#eeeeee"
              stroke="#dddddd"
              stroke-width="1"
            />
            <polygon
              id="right_inside_wing"
              points="150,0 90,150 150,190"
              style="fill:#eeeeee;"
              stroke="#dddddd"
              stroke-width="1"
            />
          </g>
        </svg>
      </div>
    </div>
  </div>
</template>

<script>
import { rotate_and_fly } from '@/assets/js/mail/MailBoxIntro.js';
export default {
  name: 'Mailboxintro',
  data() {
    return {};
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  mounted() {
    setTimeout(() => {
      rotate_and_fly();
      const bottom = document.querySelector('.bottom');
      bottom.classList.add('hide');
      setTimeout(() => {
        this.$router.push({ name: 'Mailbox' });
      }, 2700);
    }, 1500);
  },
  methods: {},
};
</script>

<style scoped src="@/assets/css/mail/MailBoxIntro.css"></style>
