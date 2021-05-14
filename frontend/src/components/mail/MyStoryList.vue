<template>
  <ul class="section_body_story_list story_list">
    <li class="story_item" v-for="(item, index) in [1, 2, 3, 4, 5, 6, 7, 8, 9]" :key="index">
      <div class="story_header">
        <h1 class="story_title">원시 사연 제목 위치</h1>
      </div>
      <div class="story_body">
        <div class="received_reply">
          <div class="received_reply_num">새로운 답장 3 통</div>
          <div class="reply_users_accodian_open" @click="openUsers(index)">열기</div>
        </div>
        <ul class="reply_users" v-if="openUsersState == index">
          <li class="reply_user" v-for="(reply, index) in replyArr" :key="index">
            <div class="reply_user_header">
              <h1>익명의 토끼</h1>
              <div class="date">재답장 수신 날짜</div>
            </div>
            <p>익명의 토끼가 보낸 답장의 제목</p>
          </li>
        </ul>
      </div>
    </li>
  </ul>
</template>

<script>
export default {
  name: 'Mystroylist',
  data() {
    return {
      replyArr: [1, 2, 3, 4, 5, 6, 7, 8, 9],
      openUsersState: -1,
    };
  },
  methods: {
    openUsers(index) {
      if (this.openUsersState == index) {
        this.openUsersState = -1;
      } else {
        this.openUsersState = index;
      }
    },
  },
};
</script>

<style scoped>
.section_body_story_list {
  width: 100%;
  height: 100%;
  padding-right: 0.5rem;
  list-style: none;
  overflow-x: hidden;
}

::-webkit-scrollbar {
  width: 7px;
  height: 4px;
}

::-webkit-scrollbar-thumb {
  background-color: #fff;
  border-radius: 6px;
}

.story_item {
  width: 100%;
  min-height: 10%;
  border-radius: 1rem;
  padding: 0.5rem 1rem;
  margin: 1rem 0;
  backdrop-filter: blur(15px);
  background: rgba(255, 255, 255, 0.2);
  box-shadow: 0 5px 1px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

.story_header {
  padding-top: 0.5rem;
  display: flex;
  width: 100%;
  height: 20%;

  /* height: 30%; */
  justify-content: space-between;
  /* margin: 0.3rem 0; */
  xfont-size: 1.1rem;
  font-weight: 600;
}
.story_title {
  pointer-events: none;
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.header_counsel {
  width: 25%;
  font-size: 0.7rem;
}
.header_counsel small {
  color: #333;
}

.story_body {
  width: 100%;
}
.received_reply {
  width: 100%;
  height: 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 1rem 0;
}
.received_reply_num {
  pointer-events: none;
}
.reply_users {
  width: 100%;
}
.reply_user {
  width: 100%;
  height: 4rem;
  border-radius: 0.3rem;
  padding: 0.5rem 0.3rem;
  margin: 0.5rem 0;
  color: white;
  border: none;
  cursor: pointer;
  background-color: #a3b1ec;
  transition: all 0.5s;
}
.reply_user:hover {
  background-color: #667eea;

  transform: perspective(300px) scale(1.01);
}
.reply_user > * {
  pointer-events: none;
}
.reply_user_header {
  display: flex;
  padding-bottom: 0.3rem;
  justify-content: space-between;
  align-items: center;
}
.reply_user_header h1 {
  pointer-events: none;
  font-weight: 600;
}

.reply_user p {
  pointer-events: none;

  padding: 0.3rem 0;
}
.reply_user_header .date {
  display: inline-block;
  margin-right: 0.3rem;
  font-size: 0.7rem;
  text-align: right;
}
.reply_users_accodian_open {
  cursor: pointer;
}
</style>
