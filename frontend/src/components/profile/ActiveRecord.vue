<template>
  <div class="active-record-container">
    <div class="container">
      <div class="tab-container">
        <span
          v-for="(tab, index) in tabs"
          :key="index"
          class="tab-style"
          :class="{ active: currentTab === index }"
          @click="currentTab = index"
        >
          {{ tab }}
        </span>
      </div>
      <div class="line"></div>
      <div class="tab-content">
        <div v-show="currentTab == 0">
          <div v-if="myStories.length > 0">
            <div v-for="(story, idx) in myStories" :key="idx">
              <div class="card" @click="goToMyReceivedMail">
                <div class="wrapper">
                  <div class="box">
                    <div class="box-container">
                      <p>{{ story['title'] }}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div v-else class="notice">
            <p>아직 작성한 사연이 없습니다.</p>
          </div>
        </div>
        <div v-show="currentTab == 1">
          <div v-if="myAnswers.length > 0">
            <div v-for="(story, idx) in myAnswers" :key="idx">
              <div class="card" @click="goToMyReceivedMail">
                <div class="wrapper">
                  <div class="box">
                    <div class="box-container">
                      <p>{{ story['title'] }}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div v-else class="notice2">
            <p>아직 작성한 답변이 없습니다.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getMyStories } from '@/api/stories';
import { getMyCounsels } from '@/api/counsels';
export default {
  data() {
    return {
      currentTab: 0,
      tabs: ['내 사연', '답변한 사연'],
      myStories: [],
      myAnswers: [],
    };
  },
  methods: {
    async loadMyStories() {
      try {
        let data = await getMyStories();
        this.myStories = data;
      } catch (error) {
        console.log(error);
      }
    },
    async loadMyCounsels() {
      try {
        let data = await getMyCounsels();
        this.myAnswers = data;
      } catch (error) {
        console.log(error);
      }
    },
    goToMyReceivedMail() {
      this.$router.push({ name: 'MyReceivedMail' });
    },
  },
  created() {
    this.loadMyStories();
    this.loadMyCounsels();
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Brush+Script&display=swap');
.active-record-container {
  width: 100%;
  height: 100%;
  padding: 7vh;
}

.container {
  width: 100%;
  height: 100%;
  overflow: hidden;
  overflow-y: scroll;
}

::-webkit-scrollbar {
  width: 0.3vw;
}
::-webkit-scrollbar-corner {
}
::-webkit-scrollbar-thumb {
  background-color: #e2deff;
  border-radius: 6px;
  opacity: 0.1;
}

.tab-container {
  color: #e1e0e0;
  margin-bottom: 2vh;
}

.tab-style {
  cursor: pointer;
  margin-right: 0.5vw;
  font-size: 1vw;
  font-family: 'InfinitySans-BoldA1';
}

.active {
  color: #fff;
  font-weight: bold;
  font-size: 1.2vw;
}

.line {
  height: 0.1vh;
  width: 95%;
  background: #fff;
  margin-bottom: 3vh;
}

.wrapper {
  float: left;
}

.wrapper .box {
  width: 12vw;
  height: 23vh;
  border-radius: 15px;
  transition: transform 500ms ease-out;
  overflow: hidden;
  background: rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(30px);
  border: 2px solid rgba(255, 255, 255, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
  margin-right: 0.5vw;
  margin-left: 0.9vw;
  margin-bottom: 2.5vh;
  padding: 0.8vw;
  cursor: pointer;
}

.box p {
  line-height: 1.9;
  color: #fff;
  font-family: 'Love_son';
  font-size: 20px;
}

.wrapper .box:before {
  width: 60%;
  height: 100%;
  top: 0%;
  left: -125%e;
  transform: skew(45deg);
  position: absolute;
  animation-direction: left;
  transition-duration: 500ms;
}

.wrapper .box:hover {
  transform: translateY(-5%);
}

.notice {
  display: flex;
  justify-content: center;
  margin-top: 30%;
  font-size: 1.3vw;
  color: #fff;
  font-weight: bold;
  font-family: 'InfinitySans-BoldA1';
}

.notice2 {
  display: flex;
  justify-content: center;
  margin-top: 30%;
  font-size: 1.3vw;
  color: #fff;
  font-weight: bold;
  font-family: 'InfinitySans-BoldA1';
}
</style>
