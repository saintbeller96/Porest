<template>
  <div>
    <img src="@/assets/image/flower.jpg" class="background" />
    <div class="mailbox-container">
      <img src="@/assets/image/mailbox.png" class="mailbox" />
    </div>
    <p>내 우체통 페이지</p>
    <p>편지 리스트 보여지는 곳</p>
    <button @click="goToLetterDetail">편지 디테일 이동</button>
    <div>
      <img src="@/assets/image/envelope.png" class="envelope" />
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    goToLetterDetail() {
      this.$router.push({ name: 'LetterDetail' });
    },
  },
};
</script>

<style scoped>
.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.mailbox-container {
  display: flex;
  justify-content: center;
}

.mailbox {
  position: absolute;
  width: 25vw;
  pointer-events: none;
  margin-top: 35vh;
}

p {
  position: relative;
  font-size: 1.5em;
  color: white;
}

button {
  position: relative;
}

.envelope {
  position: absolute;
  width: 10vw;
}
</style>
