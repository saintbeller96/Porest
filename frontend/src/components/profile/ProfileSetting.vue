<template>
  <div class="profile-container">
    <div class="title2">
      <p>프로필 사진 변경</p>
    </div>
    <select-profile-pic></select-profile-pic>
    <div class="title2">
      <p>
        닉네임 변경
        <span v-if="!nicknameLength" class="error_message">
          20자 이하로 입력해주세요.
        </span>
      </p>
    </div>
    <div class="inputBox">
      <input type="text" class="input" v-model="nickname" maxlength="20" />
    </div>
    <div>
      <p class="space"></p>
      <p class="title2">비밀번호 변경</p>
      <span class="title3">현재 비밀번호</span>
      <div class="inputBox">
        <input type="password" class="input" v-model="password1" />
      </div>

      <span class="title3">새로운 비밀번호</span>
      <span v-if="isPasswordNotSame" class="error_message">
        이전 비밀번호와 다른 비밀번호로 입력해주세요.
      </span>
      <span
        v-else-if="!isValidPwd && password2.length < 8"
        class="error_message"
      >
        8자 이상의 비밀번호를 입력해주세요.
      </span>
      <span
        v-else-if="!isValidPwd && password2.length > 20"
        class="error_message"
      >
        20자 이하의 비밀번호를 입력해주세요.
      </span>
      <div class="inputBox">
        <input type="password" class="input" v-model="password2" />
      </div>

      <span class="title3">새 비밀번호 확인</span>
      <span v-if="!isValidPwdConfirm" class="error_message">
        새 비밀번호와 동일하게 입력해주세요.
      </span>
      <div class="inputBox">
        <input type="password" class="input" v-model="password3" />
      </div>
    </div>
    <p class="save-btn">
      <span @click="updateProfile">변경하기</span>
    </p>
  </div>
</template>

<script>
import SelectProfilePic from '@/components/profile/SelectProfilePic';
import {
  updateProfileImg,
  updateNickname,
  updatePassword,
} from '@/api/profile';
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
    nicknameLength() {
      return this.nickname.length < 20;
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
  padding: 6vh;
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
  margin-bottom: 1vh;
}

.title3 {
  font-size: 0.8vw;
  font-family: 'InfinitySans-BoldA1';
}

.inputBox input {
  width: 95%;
  border-style: none;
  outline-style: none;
  height: 2.5vh;
  border-radius: 7px;
  margin-bottom: 1.5vh;
  margin-top: 1vh;
  padding: 1vh;
}

.error_message {
  font-size: 0.25vh;
  margin-left: 0.5vw;
  color: red;
}

.space {
  margin-top: 3vh;
}

.save-btn {
  text-align: right;
  margin-top: 2vh;
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
