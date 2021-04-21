<template>
  <div class="room-wrapper">
    <div @click="exitRoom()">close</div>
    <audio src="chat_request.mp3" id="chatAudio"></audio>
    <div class="overlay" onclick="hideInvitePopup()"></div>
    <div class="invitePop">
      <input type="text" value="..." id="roomLink" readonly />
      <button onclick="copyToClipboard()">Copy</button>
    </div>
    <div class="main">
      <div class="main__left">
        <div class="main__videos">
          <div id="video-grid"></div>
        </div>
        <div class="main__controls">
          <div class="main__controls_block">
            <div class="main__controls_button" id="muteButton">
              <i class="fa fa-microphone"></i>
              <span>Mute</span>
            </div>
            <div class="main__controls_button" id="playPauseVideo">
              <i class="fas fa-video"></i>
              <span>Pause Video</span>
            </div>
          </div>

          <div class="main__controls_block">
            <div class="main__controls_button">
              <i class="fa fa-lock"></i>
              <span>Security</span>
            </div>
            <div class="main__controls_button">
              <i class="fa fa-users"></i>
              <span>Participants</span>
            </div>
            <div
              class="main__controls_button"
              id="chat__Btn"
              onclick="ShowChat(this)"
            >
              <i class="fa fa-comment"></i>
              <span>Chat</span>
            </div>
            <div class="main__controls_button" onclick="showInvitePopup()">
              <i class="fas fa-user-plus"></i>
              <span>Invite people</span>
            </div>
          </div>

          <div class="main__controls_block">
            <div class="main__controls_button leaveMeeting" id="leave-meeting">
              <i class="fa fa-times"></i>
              <span class="">Leave Meeting</span>
            </div>
          </div>
        </div>
      </div>
      <div class="main__right">
        <div class="main__header">
          <h6><span class="live"></span>Live Chat</h6>
        </div>
        <div class="main__chat__window" id="main__chat__window">
          <ul class="messages" id="all_messages"></ul>
        </div>
        <div class="main__message_container">
          <input
            type="text"
            id="chat_message"
            placeholder="Type message & press enter to send"
          />
          <button class="sendMsg" id="sendMsg">
            <i class="fas fa-paper-plane"></i>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { init } from "@/assets/js/script.js";
export default {
  name: "Room",
  data() {
    return {};
  },
  created() {
    console.log(this.$route.params.roomId);
  },
  mounted() {
    init();
  },
  methods: {
    exitRoom() {
      window.open("", "_self", "");
      window.close();
      return false;
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
html,
body {
  height: 100%;
  font-family: "Roboto", sans-serif;
}

.room-wrapper {
  width: 100vw;
  height: 100vh;
}
#video-grid {
  display: flex;
  justify-content: center;
  height: 100%;
  width: 100%;
  align-items: center;
  flex-wrap: wrap;
  overflow-y: auto;
}
video {
  display: block;
  flex: 1;
  object-fit: cover;
  border: 5px solid #000;
  max-width: 600px;
  max-height: 400px;
}
.main {
  height: 100%;
  display: flex;
}
.main__left {
  flex: 0.8;
  display: flex;
  flex-direction: column;
}
.main__right {
  flex: 0.2;
  display: flex;
  flex-direction: column;
  background-color: #242324;
  border-left: 1px solid #3d3d42;
}
.main__videos {
  flex-grow: 1;
  background-color: #000;
  display: flex;
  align-items: center;
  justify-content: center;
}
.main__controls {
  display: flex;
  background-color: #1c1e20;
  color: #d2d2d2;
  padding: 5px;
  justify-content: space-between;
}
.main__controls_block {
  display: flex;
}
.main__controls_button {
  display: flex;
  flex-direction: column;
  cursor: pointer;
  padding: 10px;
  justify-content: center;
  align-items: center;
  min-width: 80px;
  transition: all 0.3s ease-in-out;
  border-radius: 10px;
  margin: 5px;
}
.main__controls_button span {
  margin-top: 10px;
  display: block;
}
.main__controls_button:hover {
  background-color: #34383b;
}
.main__controls_button i {
  font-size: 25px;
}
.leaveMeeting {
  background-color: red;
  color: #fff;
}
.main__header {
  color: #f5f5f5;
  text-align: center;
  padding: 20px;
  border-bottom: 2px solid #3d3d42;
}
.main__chat__window {
  flex-grow: 1;
  overflow: auto;
  padding: 20px 20px 0 20px;
}
.main__message_container {
  padding: 22px 11px;
  display: flex;
}
.main__message_container input {
  flex-grow: 1;
  background-color: transparent;
  border: none;
  color: #f5f5f5;
  user-select: none;
  outline: none;
}

#all_messages li {
  color: #fff;
  list-style: none;
  border-bottom: 1px solid #3d3d42;
  padding: 10px 0;
}
.unmute {
  color: red;
}
</style>
