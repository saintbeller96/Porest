<template>
  <ul class="section_body_story_list send_list">
    <li class="story_item" v-for="(counsel, index) in counselList" :key="index">
      <div class="story_header">
        <h1 class="story_title" v-text="counsel.title"></h1>
        <div class="header_counsel" v-text="counsel.writerNickname"><small>작성자</small></div>
      </div>
      <!-- <div class="story_body">
        <p>
          내가 보낸 답장에 대한 재답장 제목 위치
        </p>
      </div> -->
      <p class="date" v-text="setDate(counsel.updatedAt)"></p>
    </li>
  </ul>
</template>

<script>
import { getMyCounsels } from "@/api/counsels";
export default {
  name: "Mycounsellist",
  data() {
    return {
      counselList: {},
    };
  },
  methods: {
    async getMyCounsels() {
      this.counselList = await getMyCounsels();
      console.log(this.counselList);
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
  },
  mounted() {
    this.getMyCounsels();
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
  height: 18%;
  border-radius: 1rem;
  padding: 1rem 0.5rem;
  margin: 1rem 0;
  color: #444;
  backdrop-filter: blur(15px);
  /* box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1); */
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(166, 201, 247, 0.2);
  border-bottom: 1px solid rgba(107, 153, 240, 0.2);
  background-color: #a3b2ec85;
  transition: all 0.5s;
  cursor: pointer;
}
.story_item:hover {
  border: none;
  background-color: #667eea;
  transform: perspective(300px) scale(1.01);
}

.story_header {
  display: flex;
  width: 100%;
  height: 30%;
  /* height: 30%; */
  justify-content: space-between;
  /* margin: 0.3rem 0; */
  font-size: 1.1rem;
  font-weight: 600;
  pointer-events: none;
}
.story_title {
  width: 70%;
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
  height: 50%;
  padding: 0.5rem 0;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 3; /* 라인수 */
  -webkit-box-orient: vertical;
  word-wrap: break-word;
  /* line-height: 1.2em; */
  pointer-events: none;
}

.date {
  height: 10%;
  padding: 0.7rem;
  font-size: 0.7rem;
  text-align: right;
  pointer-events: none;
}
</style>
