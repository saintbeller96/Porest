<template>
  <div class="profile-container">
    <div class="title">
      <p>프로필 수정</p>
    </div>
    <div class="title2">
      <p>프로필 사진 변경</p>
    </div>
    <select-profile-pic></select-profile-pic>
    <div class="title2">
      <p>닉네임 변경</p>
    </div>
    <div class="inputBox">
      <input type="text" class="input" v-model="nickname" />
    </div>
    <div class="title2">
      <p>비밀번호 변경</p>
      현재 비밀번호
      <div class="inputBox">
        <input type="password" class="input" v-model="password1" />
      </div>

      새로운 비밀번호
      <div class="inputBox">
        <input type="password" class="input" v-model="password2" />
      </div>
      <p v-if="isPasswordNotSame" class="error_message">
        이전 비밀번호와 다른 비밀번호로 입력해주세요.
      </p>
      <p v-else-if="!isValidPwd && password2.length < 8" class="error_message">
        8자 이상의 비밀번호를 입력해주세요.
      </p>
      <p v-else-if="!isValidPwd && password2.length > 20" class="error_message">
        20자 이하의 비밀번호를 입력해주세요.
      </p>

      새 비밀번호 확인
      <div class="inputBox">
        <input type="password" class="input" v-model="password3" />
      </div>
      <p v-if="!isValidPwdConfirm" class="error_message">
        다시 비밀번호를 확인해주세요.
      </p>
    </div>
    <p class="save-btn">
      <span @click="updateProfile">변경하기</span>
    </p>
  </div>
</template>

<script>
import SelectProfilePic from '@/components/profile/SelectProfilePic';
import { updateProfileImg, updateNickname, updatePassword } from '@/api/profile';
import { saveUserImgFromCookie, saveUserNameToCookie } from '@/utils/cookies';
import { validatePwd } from '@/utils/validation';
export default {
  components: {
    SelectProfilePic,
  },
  data() {
    return {
      nickname: '',
      password1: '',
      password2: '',
      password3: '',
      profileImg: '',
    };
  },
  computed: {
    isValidPwd() {
      return this.password2 === '' || validatePwd(this.password2);
    },
    isValidPwdConfirm() {
      return this.password3 === '' || this.password2 === this.password3;
    },
    isPasswordNotSame() {
      return this.password2 !== '' && this.password1 === this.password2;
    },
  },
  methods: {
    saveImg() {
      this.$store.commit('setImg', '');
    },
    async updateProfile() {
      try {
        const id = this.$store.state.profileImg;
        await updateProfileImg(id);
        await updateNickname({
          nickname: this.nickname,
        });
        if (this.password1 && this.password2 && this.password3) {
          await updatePassword({
            newPassword: this.password2,
            oldPassword: this.password1,
          });
        }
        saveUserImgFromCookie(id);
        saveUserNameToCookie(this.nickname);
        this.$store.commit('setUsername', this.nickname);
        alert('수정이 완료되었습니다.');
        this.$store.commit('setModalProfile', false);
        this.$store.commit('setProfileImgToShow', id);
      } catch (error) {
        alert(error.response['data']['message']);
      }
    },
  },
  created() {
    try {
      this.nickname = this.$store.state.nickname;
    } catch (error) {
      console.log(error);
    }
  },
};
</script>

<style scoped>
.profile-container {
  /* align-items: center; */
  width: 100%;
  height: 100%;
  padding: 7vh;
}

.title {
  display: flex;
  justify-content: center;
  font-family: 'InfinitySans-BoldA1';
  font-size: 1.5vw;
  margin-bottom: 5vh;
}

.title2 {
  font-family: 'InfinitySans-BoldA1';
  font-size: 1vw;
  /* margin-left: 1.5vw; */
  margin-top: 5vh;
  margin-bottom: 2vh;
}

.save-btn {
  text-align: right;
}

.save-btn span {
  cursor: pointer;
  color: #525252;
  font-size: 1vw;
  font-weight: bold;
}

.save-btn span:hover {
  color: #35ae6d;
}
</style>
