<template>
  <section>
    <header>
      signup page
    </header>
    <!-- <form @submit.prevent="register"> -->
    <article>
      <div>
        <p>email</p>
        <input type="email" v-model="email" placeholder="이메일 주소를 입력해주세요." autocomplete="on" />
        <span v-if="!emailRedundancy" class="before_redundancy_check" @click="checkEmail">중복확인</span>
        <span v-else class="after_redundancy_check" @click="checkEmail">중복확인 완료</span>
        <p v-if="!isValidEmail" class="error_message">
          잘못된 이메일 양식입니다.
        </p>
      </div>
      <div>
        <p>닉네임</p>
        <input type="text" v-model="nickname" placeholder="닉네임을 입력해주세요." autocomplete="off" />
        <span v-if="!nicknameRedundancy" class="before_redundancy_check" @click="checkNickname">중복확인</span>
        <span v-else class="after_redundancy_check" @click="checkNickname">중복확인 완료</span>
      </div>
      <div>
        <p>비밀번호</p>
        <input type="password" v-model="password1" placeholder="8~20자의 영문, 숫자 입력" autocomplete="off" />
        <p v-if="!isValidPwd && password1.length < 8" class="error_message">8자 이상의 비밀번호를 입력해주세요.</p>
        <p v-else-if="!isValidPwd && password1.length > 20" class="error_message">
          20자 이하의 비밀번호를 입력해주세요.
        </p>
      </div>
      <div>
        <p>비밀번호 확인</p>
        <input type="password" v-model="password2" placeholder="비밀번호를 다시 입력해주세요." autocomplete="off" />
        <p v-if="!isValidPwdConfirm" class="error_message">
          다시 비밀번호를 확인해주세요.
        </p>
      </div>
      <div>
        <input type="checkbox" name="terms" value="true" v-model="terms" /> 약관 확인
        <p v-if="!isTermsChecked" class="error_message">
          이용 약관을 확인해주세요
        </p>
      </div>
    </article>
    <br />
    <button :disabled="!checkForm" @click="submitForm">회원가입하기</button>
    <!-- </form> -->
    <br />
    <p @click="goToLogin">로그인 페이지 이동</p>
  </section>
</template>

<script>
import { signupUser, nicknameCheck, emailCheck } from '@/api/auth';
// import FireBase from 'firebase/app';
// import 'firebase/auth';
import { validateEmail, validatePwd } from '@/utils/validation';
export default {
  data() {
    return {
      email: '',
      nickname: '',
      password1: '',
      password2: '',
      terms: false,
      nicknameRedundancy: false,
      emailRedundancy: false,
    };
  },
  computed: {
    isValidEmail() {
      return this.email === '' || validateEmail(this.email);
    },
    isValidPwd() {
      return this.password1 === '' || validatePwd(this.password1);
    },
    isValidPwdConfirm() {
      return this.password2 === '' || this.password1 === this.password2;
    },
    isTermsChecked() {
      return this.terms === true;
    },
    checkForm() {
      return (
        validateEmail(this.email) &&
        validatePwd(this.password1) &&
        this.password1 === this.password2 &&
        this.username !== '' &&
        this.terms === true &&
        this.nicknameRedundancy &&
        this.emailRedundancy
      );
    },
  },
  methods: {
    goToLogin() {
      this.$router.push({ name: 'Login' });
    },
    // register() {
    //   if (!this.error) {
    //     FireBase.auth()
    //       .createUserWithEmailAndPassword(this.email, this.password1)
    //       .then(
    //         userCred => {
    //           return userCred.user
    //             .updateProfile({
    //               nickname: this.nickname,
    //             })
    //             .then(() => {
    //               this.$router.push('/home');
    //             });
    //         },
    //         error => (this.error = error.message),
    //       );
    //   }
    // },
    async submitForm() {
      if (this.checkForm) {
        try {
          await signupUser({
            email: this.email,
            nickname: this.nickname,
            password: this.password1,
          });
        } catch (error) {
          alert(error);
        }
      }
    },
    async checkEmail() {
      try {
        let { data } = await emailCheck({
          email: this.email,
        });
        this.emailRedundancy = data.redundancy;
        if (!this.emailRedundancy) {
          alert('이미 존재하는 이메일 주소입니다.');
        }
      } catch (error) {
        alert(error);
      }
    },
    async checkNickname() {
      try {
        let { data } = await nicknameCheck({
          nickname: this.nickname,
        });
        this.nicknameRedundancy = data.redundancy;
        console.log(this.nicknameRedundancy);
        if (!this.nicknameRedundancy) {
          alert('이미 존재하는 닉네임입니다.');
        }
      } catch (error) {
        alert(error);
      }
    },
  },
};
</script>

<style scoped>
section {
  padding: 30px;
}

.before_redundancy_check {
  color: red;
  font-size: 10px;
  margin-left: 10px;
}
.after_redundancy_check {
  color: blue;
  font-size: 10px;
  margin-left: 10px;
}
</style>
