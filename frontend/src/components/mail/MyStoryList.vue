<template>
  <!-- my stories -->
  <ul class="section_body_story_list story_list">
    <li class="story_item" v-for="(story, index) in stories" :key="index">
      <div class="story_header">
        <h1 class="story_title" v-text="story.title"></h1>
      </div>
      <div class="story_body">
        <div class="received_reply">
          <div class="received_reply_num" v-text="'새로운 답장 ' + story.numOfNewReply + '통'"></div>
          <div class="reply_users_accodian_open" @click="openUsers(index, story.storyId)">열기</div>
        </div>

        <!-- reply -->
        <ul class="reply_users" v-if="openUsersState == index">
          <li
            class="reply_user"
            v-for="(reply, index) in replies"
            :key="index"
            @click="openStory(story.storyId, reply.counselId, reply.numOfReplies)"
          >
            <div class="reply_user_header">
              <h1 v-text="reply.writerNickname"></h1>
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
import { getMyStories, getStoryOfAllLetters } from "@/api/stories";
import { getCounsel } from "@/api/counsels";
export default {
  name: "Mystroylist",
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
        return "방금 전";
      } else if ((elapsed = elapsed / 60) < 60) {
        return Math.floor(elapsed) + "분 전";
      } else if ((elapsed = elapsed / 60) < 24) {
        return Math.floor(elapsed) + "시간 전";
      } else if ((elapsed /= 24) < 31) {
        return Math.floor(elapsed) + "일 전";
      } else if ((elapsed /= 30) < 12) {
        return Math.floor(elapsed) + "달 전";
      } else {
        return Math.floor(elapsed / 12) + "년 전";
      }
    },

    //스토리 열기를 누르고 목록 중 하나를 클릭하면 오른쪽에 띄우자
    openStory(storyId, counselId, numOfNewReply) {
      getCounsel(counselId);
    },
  },
  mounted() {
    this.getMyStories();
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
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: #fff;
  border-radius: 6px;
}

.story_item {
  width: 100%;
  min-height: 10%;
  border-radius: 1rem;
  padding: 0.5rem 0.3rem;
  margin: 1rem 0;
  backdrop-filter: blur(15px);
  background: rgba(255, 255, 255, 0.2);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

.story_header {
  display: flex;
  width: 100%;
  height: 20%;
  /* height: 30%; */
  justify-content: space-between;
  /* margin: 0.3rem 0; */
  border: 1px solid;
  font-size: 1.1rem;
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
  border: 1px solid;
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
  border: 1px solid;
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
