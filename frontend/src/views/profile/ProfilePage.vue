<template>
  <div class="body">
    <span @click="goOneStepBack" class="oneStepBack">
      <i class="fas fa-arrow-left"></i>
    </span>
    <div class="profile-area">
      <profile></profile>
    </div>
    <div class="active-record-area">
      <active-record></active-record>
    </div>
    <profile-setting-modal
      v-if="$store.state.modalProfileSetting"
      class="modal"
    >
      <profile-setting></profile-setting>
    </profile-setting-modal>
  </div>
</template>

<script>
import Profile from '@/components/profile/Profile';
import ActiveRecord from '@/components/profile/ActiveRecord';
import ProfileSetting from '@/components/profile/ProfileSetting';
import ProfileSettingModal from '@/components/profile/modal/ProfileSettingModal';
export default {
  components: {
    Profile,
    ActiveRecord,
    ProfileSettingModal,
    ProfileSetting,
  },
  methods: {
    goOneStepBack() {
      history.go(-1);
    },
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

.body {
  height: 100vh;
  width: 100vw;
  display: flex;
  justify-content: center;
  overflow: hidden;
  background-image: url('../../assets/image/sky.jpg');
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}

.profile-area {
  margin-top: 10vh;
  width: 17%;
  height: 40%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);

  border-radius: 25px;
  margin-right: 1.5vw;
}

.active-record-area {
  margin-top: 10vh;
  width: 50%;
  height: 80%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);

  border-radius: 25px;
}

.modal {
  z-index: 2;
}

.oneStepBack {
  position: absolute;
  top: 1rem;
  left: 1rem;
  font-size: 1.3vw;
  color: #fff;
  cursor: pointer;
}
</style>
