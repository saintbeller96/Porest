<template>
  <div>
    <div class="action">
      <span
        class="profile"
        @mouseenter="showImages"
        @mouseleave="closeImages"
        @click="goToProfile"
      >
        <img
          :src="
            $store.getters.getUpdateProfileImgFinal != 0
              ? images[$store.getters.getUpdateProfileImgFinal - 1]
              : require('../../assets/image/profile.png')
          "
          :class="{ basicImg: $store.getters.getUpdateProfileImgFinal == 0 }"
        />
      </span>
      <div class="details" @click="goToProfile">
        <span class="nickname">{{ $store.state.nickname }}</span>
        <span class="temperature"
          ><span class="percent-count text" id="percentCount"></span></span
        ><span class="measure">°C</span>
      </div>
      <!-- hover시 보여줄 내용 -->
      <div v-if="$store.getters.getUpdateProfileImgFinal != 0">
        <div class="menu" @mouseenter="showImages" @mouseleave="closeImages">
          <div class="images">
            <img
              src="../../assets/image/feeling/5.png"
              @click="getFeeling(5)"
              class="img5"
            />
            <img
              src="../../assets/image/feeling/4.png"
              @click="getFeeling(4)"
              class="img4"
            />
            <img
              src="../../assets/image/feeling/3.png"
              @click="getFeeling(3)"
              class="img3"
            />
            <img
              src="../../assets/image/feeling/2.png"
              @click="getFeeling(2)"
              class="img2"
            />
            <img
              src="../../assets/image/feeling/1.png"
              @click="getFeeling(1)"
              class="img1"
            />
          </div>
        </div>
      </div>
      <div v-else>
        <div class="menu2" @mouseenter="showImages" @mouseleave="closeImages">
          <div class="description">
            <p>{{ $store.state.nickname }}님! 오늘 기분은 어떠신가요? :)</p>
          </div>
          <div class="images">
            <img
              src="../../assets/image/feeling/5.png"
              @click="getFeeling(5)"
              class="img5"
            />
            <img
              src="../../assets/image/feeling/4.png"
              @click="getFeeling(4)"
              class="img4"
            />
            <img
              src="../../assets/image/feeling/3.png"
              @click="getFeeling(3)"
              class="img3"
            />
            <img
              src="../../assets/image/feeling/2.png"
              @click="getFeeling(2)"
              class="img2"
            />
            <img
              src="../../assets/image/feeling/1.png"
              @click="getFeeling(1)"
              class="img1"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { updateProfileImg } from '@/api/profile';
import { saveUserImgFromCookie } from '@/utils/cookies';
export default {
  data() {
    return {
      profileImg: 0,
      check: [],
      images: [
        require('../../assets/image/feeling/1.png'), // 0
        require('../../assets/image/feeling/2.png'), // 1
        require('../../assets/image/feeling/3.png'), // 2
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
    };
  },
  methods: {
    goToProfile() {
      this.$router.push('/profile');
    },
    showImages() {
      if (this.$store.state.profileImg != 0) {
        const toggleMenu = document.querySelector('.menu');
        toggleMenu.classList.add('active');

        let n = this.$store.state.profileImgToShow;
        this.check.push(n);
        const selected = document.querySelector(`.img${n}`);
        selected.classList.add('selected');
      } else {
        const toggleMenu2 = document.querySelector('.menu2');
        toggleMenu2.classList.add('active2');
      }
    },
    closeImages() {
      if (this.$store.state.profileImg != 0) {
        const toggleMenu = document.querySelector('.menu');
        toggleMenu.classList.remove('active');
      } else {
        const toggleMenu2 = document.querySelector('.menu2');
        toggleMenu2.classList.remove('active2');
      }
    },
    getFeeling(n) {
      try {
        if (this.check.length === 0) {
          this.check.push(n);
          const selected = document.querySelector(`.img${n}`);
          selected.classList.toggle('selected');
          this.$store.commit('setImg', n);
        } else {
          let a = this.check.pop();
          const selected1 = document.querySelector(`.img${a}`);
          const selected2 = document.querySelector(`.img${n}`);
          if (a == n) {
            selected1.classList.toggle('selected');
            this.$store.commit('setImg', 0);
          } else if (a != n) {
            this.check.push(n);
            selected1.classList.toggle('selected');
            selected2.classList.toggle('selected');
            this.$store.commit('setImg', n);
          }
        }
        const id = this.$store.state.profileImg;
        updateProfileImg(id);
        saveUserImgFromCookie(id);
        this.$store.commit('setProfileImgToShow', id);
      } catch (error) {
        console.log(error);
      }
    },
    progress() {
      let percent = document.getElementById('percentCount');
      let counter = 1;
      let id = setInterval(frame, 40);
      let temperature = this.$store.state.temperature;

      function frame() {
        if (counter == temperature) {
          clearInterval(id);
        } else {
          counter += 1;
          percent.innerHTML = counter;
        }
      }
    },
  },
  mounted() {
    if (this.$store.state.profileImg != 0) {
      let n = this.$store.state.profileImg;
      this.check.push(n);
      const selected = document.querySelector(`.img${n}`);
      selected.classList.toggle('selected');
    }
    this.progress();
    if (this.$store.getters.getUpdateProfileImgFinal == 0) {
      // this.showImages();
      setTimeout(() => {
        this.showImages(), 5000;
      });
      // this.closeImages();
    }
  },
  created() {
    if (this.$store.state.profileImg == 'null') {
      this.$store.commit('setProfileImgToShow', 0);
    } else {
      this.$store.commit('setProfileImgToShow', this.$store.state.profileImg);
    }
  },
};
</script>

<style scoped>
@font-face {
  font-family: 'MaplestoryOTFBold';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/MaplestoryOTFBold.woff')
    format('woff');
  font-weight: normal;
  font-style: normal;
}
.action {
  width: 100%;
}

.details {
  margin-left: 3.5vw;
  padding-top: 1vh;
  cursor: pointer;
}

.nickname {
  font-size: 1.3vw;
  color: #fff;
  font-family: 'InfinitySans-BoldA1';
}

/* 온도 */
.temperature {
  font-size: 1.3vw;
  font-family: 'InfinitySans-BoldA1';
  min-width: 3vw;
  display: inline-block;
  text-align: end;
}

.text {
  text-transform: uppercase;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  font-size: 1.5vw;
  background-image: linear-gradient(to top, #fddb92 0%, #d1fdff 100%);
  font-family: 'MaplestoryOTFBold';
}

.measure {
  font-size: 1.2vw;
  font-family: 'MaplestoryOTFBold';
  color: #fff;
  margin-left: 0.15vw;
}

.images {
  display: flex;
  justify-content: center;
}

.images img {
  width: 2vw;
  margin: 0 0.3vw 0 0.3vw;
  cursor: pointer;
  transition: 0.1s ease;
  z-index: 1000;
  filter: opacity(0.7) drop-shadow(0 0 0 white);
}

/* 마우스 hover시 메뉴 열기 */
.profile {
  position: relative;
  width: 4vw;
  height: 6vh;
  overflow: hidden;
  cursor: pointer;
}

.basicImg {
  border-radius: 50%;
  background: #fff;
}

.action .profile img {
  width: 2.3vw;
  cursor: pointer;
  transition: 0.1s ease;
  position: absolute;
  object-fit: cover;
}

.menu {
  position: absolute;
  top: 12vh;
  padding: 2vh 2vw 2vh 2vw;
  background: #fff;
  width: 15vw;
  height: 9vh;
  box-sizing: 0 5px 25px rgba(0, 0, 0, 0.1);
  border-radius: 15px;
  transition: 0.5s;
  display: flex;
  align-items: center;
  justify-content: center;

  /* 닫기 */
  visibility: hidden;
  opacity: 0;
}

.menu.active {
  visibility: visible;
  opacity: 1;
  top: 7vh;
}

/* 말풍선 뾰족이 */
.menu::before {
  content: '';
  position: absolute;
  top: -0.5vh;
  left: 1vw;
  width: 1.3vw;
  height: 2.8vh;
  background: #fff;
  transform: rotate(45deg);
}

/* 메뉴 2 */
.description {
  width: 100%;
  margin-bottom: 1.7vh;
  margin-top: 0.7vh;
  display: flex;
  justify-content: center;
  font-family: 'GyeonggiBatang';
  font-weight: bold;
}

.description p {
  font-size: 0.8vw;
  z-index: 100;
}

.menu2 {
  position: absolute;
  top: 12vh;
  padding: 2vh 2vw 2vh 2vw;
  background: #fff;
  width: 18.5vw;
  box-sizing: 0 5px 25px rgba(0, 0, 0, 0.1);
  border-radius: 15px;
  transition: 0.5s;
  /* display: flex; */
  align-items: center;
  justify-content: center;

  /* 닫기 */
  visibility: hidden;
  opacity: 0;
}

.menu2::before {
  content: '';
  position: absolute;
  top: -0.5vh;
  left: 1vw;
  width: 1.3vw;
  height: 2.8vh;
  background: #fff;
  transform: rotate(45deg);
}

.menu2.active2 {
  visibility: visible;
  opacity: 1;
  top: 7vh;
}

/* 이미지 선택 */
.images img:hover {
  transform: scale(1.2);
  filter: none;
}

.img1.selected {
  transform: scale(1.2);
  filter: none;
}
.img2.selected {
  transform: scale(1.2);
  filter: none;
}
.img3.selected {
  transform: scale(1.2);
  filter: none;
}
.img4.selected {
  transform: scale(1.2);
  filter: none;
}
.img5.selected {
  transform: scale(1.2);
  filter: none;
}
</style>
