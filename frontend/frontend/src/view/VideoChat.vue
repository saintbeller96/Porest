<template>
  <div class="video-chat-wrapper">
    <h1>Video Chat</h1>
    <div @click="createRoom">Create room</div>
    <div class="roomId">
      <p>{{ roomId }}</p>
      <router-link :to="`/room/${roomId}`" target="_blank"
        >방에 입장하기</router-link
      >
    </div>
  </div>
</template>

<script>
import { uuid } from "vue-uuid";
export default {
  name: "VideoChat",
  data() {
    return {
      roomId: null,
    };
  },
  methods: {
    createRoom() {
      this.roomId = this.$uuid.v4();
    },
  },
};
</script>

<style  scoped>
#video-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, 300px);
  grid-auto-rows: 300px;
}

video {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
