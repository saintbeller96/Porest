<template>
  <section>
    <header>
      Login page
    </header>
    <article>
      <div>
        <p>email</p>
        <input type="email" v-model="email" placeholder="이메일 주소를 입력해주세요." />
        <p v-if="!isValidEmail" class="error_message">
          잘못된 이메일 양식입니다.
        </p>
      </div>
      <div>
        <p>비밀번호</p>
        <input type="password" v-model="password" placeholder="6~12자의 영문, 숫자 입력" />
        <p v-if="!isValidPwd && password.length < 6" class="error_message">6자 이상의 비밀번호를 입력해주세요.</p>
        <p v-else-if="!isValidPwd && password.length > 12" class="error_message">
          12자 이하의 비밀번호를 입력해주세요.
        </p>
      </div>
    </article>
    <br />
    <button :disabled="!checkForm">로그인 하기</button>
    <br />
    <p @click="goToSignup">회원가입 페이지 이동</p>
  </section>
</template>

<script>
import { validateEmail, validatePwd } from '@/utils/validation';
export default {
  data() {
    return {
      email: '',
      nickname: '',
      password: '',
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
  },
};
</script>

<style scoped>
section {
  padding: 30px;
}
</style>
