<template>
  <section>
    <header>
      Login page
    </header>
    <!-- <form @submit.prevent="login"> -->
    <article>
      <div>
        <p>email</p>
        <input type="email" v-model="email" placeholder="이메일 주소를 입력해주세요." autocomplete="on" />
        <p v-if="!isValidEmail" class="error_message">
          잘못된 이메일 양식입니다.
        </p>
      </div>
      <div>
        <p>비밀번호</p>
        <input type="password" v-model="password" placeholder="8~20자의 영문, 숫자 입력" autocomplete="off" />
        <p v-if="!isValidPwd && password.length < 8" class="error_message">8자 이상의 비밀번호를 입력해주세요.</p>
        <p v-else-if="!isValidPwd && password.length > 20" class="error_message">
          20자 이하의 비밀번호를 입력해주세요.
        </p>
      </div>
    </article>
    <br />
    <button :disabled="!checkForm" @click="submitForm">로그인 하기</button>
    <!-- </form> -->
    <br />
    <p @click="goToSignup">회원가입 페이지 이동</p>
  </section>
</template>

<script>
import { validateEmail, validatePwd } from '@/utils/validation';
// import FireBase from 'firebase/app';
// import 'firebase/auth';
export default {
  data() {
    return {
      email: '',
      password: '',
      token_payload: '', // 디코딩 결과
      id: '',
      token:
        'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJwcm9maWxlX2ltZyI6bnVsbCwibmlja25hbWUiOiJiIiwidGVtcGVyYXR1cmUiOm51bGwsImlkIjo5LCJleHAiOjE2MjAyNTkyMDAsImVtYWlsIjoiYkBiLmNvbSJ9.pD28NE-IsvhOACF9EF-SdeDCrbo8ggYm-_uCm_RqCEUklYs8emF3p4YY79rPHrVHfaPu2zKutK5p_RGsaEQiGg',
    };
  },
  computed: {
    isValidEmail() {
      return this.email === '' || validateEmail(this.email);
    },
    isValidPwd() {
      return this.password === '' || validatePwd(this.password);
    },
    checkForm() {
      return validateEmail(this.email) && validatePwd(this.password);
    },
  },
  methods: {
    goToSignup() {
      this.$router.push({ name: 'Signup' });
    },
    async submitForm() {
      try {
        await this.$store.dispatch('LOGIN', {
          email: this.email,
          password: this.password,
        });
        this.$router.push('/main');
      } catch (error) {
        alert('이메일이나 비밀번호를 다시 확인해주세요.');
      }
    },
    // login() {
    //   console.log('login');
    //   FireBase.auth()
    //     .signInWithEmailAndPassword(this.email, this.password)
    //     .then(
    //       () => {
    //         console.log('move to home');
    //         this.$router.push('/main');
    //       },
    //       error => (this.error = error.message),
    //     );
    // },
  },
};
</script>

<style scoped>
section {
  padding: 30px;
}
</style>
