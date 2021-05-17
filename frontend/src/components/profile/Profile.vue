<template>
  <div class="profile-container">
    <div class="setting-btn" @click="openModal"><i class="fas fa-cog"></i></div>
    <div class="profile-pic">
      <img src="@/assets/image/profile.png" alt="" />
    </div>
    <div class="personal-info">
      <p>{{ $store.state.nickname }}</p>
    </div>
    <div class="temperature">
      <temperature></temperature>
    </div>
  </div>
</template>

<script>
import Temperature from '@/components/profile/Temperature';
export default {
  components: {
    Temperature,
  },
  methods: {
    openModal() {
      this.$store.commit('setModalProfile', true);
    },
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
}

.setting-btn {
  color: #fff;
  float: right;
  font-size: 13px;
  opacity: 0.9;
  cursor: pointer;
  margin-top: -20px;
  margin-right: 20px;
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
  margin-bottom: 3vh;
}

.profile-pic img {
  width: 35%;
  height: 35%;
  object-fit: cover;
  border-radius: 50%;
  border: 2px solid #fff;
  box-shadow: 10px 10px 30px rgba(0, 0, 0, 0.4);
}

.personal-info {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 3vh;
  font-size: 1vw;
  font-family: 'MaplestoryOTFBold';
}

@keyframes animate {
  0%,
  100% {
    transform: translateY(3px);
  }
  50% {
    transform: translateY(-3px);
  }
}
</style>
