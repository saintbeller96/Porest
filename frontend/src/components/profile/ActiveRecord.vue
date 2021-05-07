<template>
  <div class="active-record-container">
    <button
      v-for="(tab, index) in tabs"
      :key="index"
      :class="{ active: currentTab === index }"
      @click="currentTab = index"
    >
      {{ tab }}
    </button>
    <div class="tab-content">
      <div v-show="currentTab == 0">
        11
        <div class="card">
          <div class="wrapper">
            <div class="box">
              <div class="box-container">
                <h2>letter 1</h2>
                <p>안녕하세요 내용입니다</p>
                <a href="#">읽으러 가기</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div v-show="currentTab == 1">
        22
        <div class="card">
          <div class="wrapper">
            <div class="box">
              <div class="box-container">
                <h2>letter 22</h2>
                <p>안녕하세요 내용입니다</p>
                <a href="#">읽으러 가기</a>
              </div>
            </div>
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
      currentTab: 0,
      tabs: ['내 사연', '답변한 사연'],
    };
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Nanum+Brush+Script&display=swap');
.active-record-container {
  height: 42vh;
  width: 100%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  z-index: 12;
  border-radius: 25px;
  margin: auto;
  position: relative;
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
  font-family: 'Black Han Sans', sans-serif;
}
.box p {
  line-height: 1.9;
  color: rgba(255, 255, 255, 0.7);
  font-family: 'Nanum Brush Script', cursive;
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
  font-family: 'Black Han Sans', sans-serif;
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
</style>
