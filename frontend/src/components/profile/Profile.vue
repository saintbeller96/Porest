<template>
  <div class="profile-container">
    <div class="setting-btn" @click="openModal"><i class="fas fa-cog"></i></div>
    <div class="profile-pic">
      <img
        :src="
          $store.getters.getUpdateProfileImgFinal != 0
            ? images[$store.getters.getUpdateProfileImgFinal - 1]
            : require('../../assets/image/profile.png')
        "
        :class="{ basicImg: $store.getters.getUpdateProfileImgFinal == 0 }"
      />
    </div>
    <div class="personal-info">
      <p>{{ $store.state.nickname }}님의 마음 온도는</p>
    </div>
    <div class="temperature">
      <temperature></temperature>
    </div>
  </div>
</template>

<script>
import Temperature from '@/components/profile/Temperature';
export default {
  data() {
    return {
      images: [
        require('../../assets/image/feeling/1.png'), // 0
        require('../../assets/image/feeling/2.png'), // 1
        require('../../assets/image/feeling/3.png'), // 2
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
    };
  },
  components: {
    Temperature,
  },
  methods: {
    openModal() {
      this.$store.commit('setModalProfile', true);
    },
  },
  created() {
    if (this.$store.state.profileImg === 'null') {
      this.$store.commit('setProfileImgToShow', 0);
    } else {
      this.$store.commit('setProfileImgToShow', this.$store.state.profileImg);
    }
  },
};
</script>

<style scoped>
.profile-container {
  position: relative;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  padding: 3vh;
}

.setting-btn {
  color: #fff;
  float: left;
  font-size: 1vw;
  cursor: pointer;
  margin-top: -1vh;
  /* margin-left: 1.2vw; */
}

.profile-pic {
  display: flex;
  justify-content: center;
  margin-top: 5vh;
  /* top: 50px; */
  /* position: relative; */

  /* animation */
  animation: animate 3s ease-in-out infinite;
  object-fit: cover;
  margin-bottom: 5vh;
}

.profile-pic img {
  height: 10vh;
  object-fit: cover;
  border-radius: 50%;
  box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.4);
}

.basicImg {
  border: 2px solid #fff;
}

.personal-info {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 1.5vh;
  font-size: 1vw;
  font-family: 'MaplestoryOTFBold';
  color: #fff;
  letter-spacing: 0.1vw;
}

@keyframes animate {
  0%,
  100% {
    transform: translateY(0.45vh);
  }
  50% {
    transform: translateY(-0.45vh);
  }
}
</style>
