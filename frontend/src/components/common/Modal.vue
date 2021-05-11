<template>
  <div class="modal">
    <div class="overlay" @click="$emit('close-modal')"></div>
    <div class="modal-card">
      <slot />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.modal,
.overlay {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
}
.overlay {
  opacity: 0.5;
  background-color: black;
  /* display: flex;
  justify-content: center;
  align-items: center; */
}
.modal-card {
  position: relative;
  max-width: 28%;
  margin: auto;
  margin-top: 15vh;
  min-height: 70%;
  z-index: 10;
  border-radius: 5%;
  /* background: rgba(255, 239, 245, 0.9); */
  background-image: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%);
  /* background-image: linear-gradient(to top, #ff9a9e 0%, #fecfef 99%, #fecfef 100%); */
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.3);
  border-top: 1.5px solid rgba(255, 255, 255, 0.8);
  border-left: 1.5px solid rgba(255, 255, 255, 0.8);
  opacity: 0.9;
}
</style>
