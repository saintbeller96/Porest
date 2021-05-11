<template>
  <div>
    <button>랜덤 돌리기</button>
    <section>
      <!-- <img src="@/assets/image/407.jpg" alt="" /> -->
      <div class="card">
        <div class="wrapper">
          <div class="box" v-for="(story, index) in stories" :key="index">
            <div class="box-container">
              <h2>{{ story.detail.title }}</h2>
              <p>{{ story.detail.content }}</p>
              <div @click="goToRootMailReply(story.storyId)">읽으러 가기</div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import { getCandidatesOfStories } from "@/api/stories";
export default {
  name: "RandomMail",
  data() {
    return {
      randomMails: [1, 2, 3, 4, 5, 6],
      stories: [],
    };
  },
  methods: {
    async getRandomStories() {
      this.stories = await getCandidatesOfStories();
    },
    goToRootMailReply(id) {
      this.$router.push({ name: "RootMailReply", params: { storyId: id } });
    },
  },
  mounted() {
    this.getRandomStories();
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Brush+Script&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-image: url("../../assets/image/407.jpg");
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
  padding: 50px;
}

.card {
  display: -webkit-flex;
  display: -moz-flex;
  display: -ms-flex;
  display: -o-flex;
  /* min-height: 100vh; */
}

.wrapper {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 30px;
}

.wrapper .box {
  width: 250px;
  height: 250px;
  border-radius: 15px;
  transition: transform 500ms ease-out;
  overflow: hidden;
  color: #fff;
  padding: 5%;
  text-align: center;
  background: rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(30px);
  border: 2px solid rgba(255, 255, 255, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
}

.box h2 {
  font-size: 17px;
  margin-bottom: 30px;
  color: rgba(255, 255, 255, 0.7);
  font-family: "Black Han Sans", sans-serif;
}
.box p {
  line-height: 1.9;
  color: rgba(255, 255, 255, 0.7);
  font-family: "Nanum Brush Script", cursive;
  font-size: 20px;
}

.box a {
  border: none;
  background: #fff;
  padding: 10px 30px;
  display: inline-block;
  margin-top: 20px;
  text-decoration: none;
  font-size: 16px;
  border-radius: 50px;
  font-family: "Black Han Sans", sans-serif;
}

/* .wrapper .box:before {
  content: '';
  background: rgba(255, 255, 255, 0.3);
  width: 60%;
  height: 100%;
  top: 0%;
  left: -125%e;
  transform: skew(45deg);
  position: absolute;
  animation-direction: left;
  transition-duration: 500ms;
} */

.wrapper .box:hover {
  transform: translateY(-5%);
}

/* .wrapper .box:hover:before {
  left: 150%;
} */

/* .container {
  position: relative;
  width: calc(100% - 100px);
  min-height: calc(100vh - 280px);
  min-height: 500px;
  background: rgba(255, 255, 255, 0.5);
  box-shadow: 0 15px 35px rgba(255, 255, 255, 0.05);
  border-radius: 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 50px;
} */
</style>
