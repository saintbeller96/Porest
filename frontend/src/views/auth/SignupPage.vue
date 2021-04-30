<template>
  <section>
    <header>
      signup page
    </header>
    <form @submit.prevent="register">
      <article>
        <div>
          <p>email</p>
          <input type="email" v-model="email" placeholder="이메일 주소를 입력해주세요." autocomplete="on"/>
          <p v-if="!isValidEmail" class="error_message">
            잘못된 이메일 양식입니다.
          </p>
        </div>
        <div>
          <p>닉네임</p>
          <input type="text" v-model="nickname" placeholder="닉네임을 입력해주세요." autocomplete="off" />
        </div>
        <div>
          <p>비밀번호</p>
          <input type="password" v-model="password1" placeholder="6~12자의 영문, 숫자 입력" autocomplete="off"/>
          <p v-if="!isValidPwd && password1.length < 6" class="error_message">6자 이상의 비밀번호를 입력해주세요.</p>
          <p v-else-if="!isValidPwd && password1.length > 12" class="error_message">
            12자 이하의 비밀번호를 입력해주세요.
          </p>
        </div>
        <div>
          <p>비밀번호 확인</p>
          <input type="password" v-model="password2" placeholder="비밀번호를 다시 입력해주세요."autocomplete="off" />
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
      <button :disabled="!checkForm">회원가입하기</button>
    </form>
    <br />
    <p @click="goToLogin">로그인 페이지 이동</p>
  </section>
</template>

<script>
import FireBase from 'firebase/app';
import 'firebase/auth';
import { validateEmail, validatePwd } from '@/utils/validation';
export default {
  data() {
    return {
      email: '',
      nickname: '',
      password1: '',
      password2: '',
      terms: false,
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
        this.terms === true
      );
    },
  },
  methods: {
    goToLogin() {
      this.$router.push({ name: 'Login' });
    },
    register() {
      if (!this.error) {
        FireBase.auth()
          .createUserWithEmailAndPassword(this.email, this.password1)
          .then(
            userCred => {
              return userCred.user
                .updateProfile({
                  nickname: this.nickname,
                })
                .then(() => {
                  this.$router.push('/home');
                });
            },
            error => (this.error = error.message),
          );
      }
    },
  },
};
</script>

<style scoped>
section {
  padding: 30px;
}
</style>
