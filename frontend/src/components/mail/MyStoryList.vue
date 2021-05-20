<template>
  <!-- my stories -->
  <ul class="section_body_story_list story_list">
    <li class="story_item" v-for="(story, index) in stories" :key="index">
      <div class="story_header">
        <h1 class="story_title" v-text="story.title"></h1>
      </div>
      <div class="story_body">
        <div class="received_reply">
          <div
            class="received_reply_num"
            v-text="
              story.numOfNewReply > 0
                ? '새로운 답장 ' + story.numOfNewReply + '통'
                : '새로운 답장이 없어요!'
            "
          ></div>
          <div
            class="reply_users_accodian_open"
            @click="openUsers(index, story.storyId)"
          >
            답장보기
          </div>
        </div>

        <!-- reply -->
        <ul class="reply_users" v-if="openUsersState == index">
          <li
            class="reply_user"
            v-for="(reply, index) in replies"
            :key="index"
            @click="openStory(reply)"
          >
            <div class="reply_user_header">
              <h1
                class="reply_nickname"
                v-text="reply.writerNickname + '님의 답장'"
              ></h1>
              <h1
                class="reply_new"
                v-text="reply.numOfReplies >= 1 ? 'NEW' : ''"
              ></h1>
              <div class="date" v-text="setDate(reply.updatedAt)"></div>
            </div>
            <p v-text="reply.title"></p>
          </li>
        </ul>
      </div>
    </li>
  </ul>
</template>

<script>
import { getMyStories, getStoryOfAllLetters } from '@/api/stories';
import { readLetter } from '@/api/letters';
export default {
  name: 'Mystroylist',
  data() {
    return {
      replies: {},
      stories: {},
      openUsersState: -1,
    };
  },
  methods: {
    openUsers(index, storyId) {
      if (this.openUsersState == index) {
        this.openUsersState = -1;
      } else {
        this.getReplies(storyId);
        this.openUsersState = index;
      }
    },
    //story 리스트를 가지고 온다.
    async getMyStories() {
      this.stories = await getMyStories();
    },
    async getReplies(storyId) {
      this.replies = await getStoryOfAllLetters(storyId);
    },
    setDate(date) {
      //date.substring(0, 4)   -> 년
      //date.substring(6, 7)   -> 월
      //date.substring(8, 10)  -> 일
      //date.substring(11, 13) -> 시
      //date.substring(14, 16) -> 분
      let writeTime = new Date(date);
      let elapsed = new Date() - writeTime;
      if ((elapsed = elapsed / 1000) < 60) {
        return '방금 전';
      } else if ((elapsed = elapsed / 60) < 60) {
        return Math.floor(elapsed) + '분 전';
      } else if ((elapsed = elapsed / 60) < 24) {
        return Math.floor(elapsed) + '시간 전';
      } else if ((elapsed /= 24) < 31) {
        return Math.floor(elapsed) + '일 전';
      } else if ((elapsed /= 30) < 12) {
        return Math.floor(elapsed) + '달 전';
      } else {
        return Math.floor(elapsed / 12) + '년 전';
      }
    },

    //답장을 해준 다른 사람과의 story를 클릭했을 때
    async openStory(reply) {
      // this.counselList = await getCounsel(counselId);
      await this.$store.dispatch('saveSelectedCounselId', reply.counselId);
    },
  },
  mounted() {
    this.getMyStories();
  },
};
</script>

<style scoped>
@import url(//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-kr.css);
/* <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSans-kr.css' rel='stylesheet' type='text/css'> */

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
  font-size: 24px;
  font-family: 'Love_son';
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
  margin: 0.5rem 0;
  /* font-family: 'GyeonggiBatang'; */
  font-family: 'Spoqa Han Sans';
  font-size: 15px;
}
.received_reply_num {
  pointer-events: none;
}
.reply_users {
  width: 100%;
}
.reply_user {
  width: 100%;
  height: 4.4rem;
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
  /* justify-content: space-between; */
  align-items: center;
}

.reply_new {
  color: red;
  font-family: 'Love_son';
  font-size: 20px;
  letter-spacing: 1px;
  font-weight: 600;
  pointer-events: none;
}
.reply_nickname {
  margin: 0 0.4rem 0 0.2rem;
  font-family: 'GyeonggiBatang';
  font-size: 1rem;
}

.date {
  margin-left: auto;
}

.reply_user p {
  pointer-events: none;
  font-family: 'Love_son';
  font-size: 1.5rem;
  padding: 0.2rem 0 0.3rem 0.5rem;
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

.reply_users_accodian_open:hover {
  font-weight: bold;
}
</style>
