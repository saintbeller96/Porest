<template>
  <div class="profile-container">
    <div class="profile_img">
      <img src="@/assets/image/profile.png" alt="" />
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.profile-container {
  /* height: 88vh;
  width: 100%; */
  /* background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px); */
  z-index: 12;
  border-radius: 25px;
  margin: auto;
  position: relative;
  display: flex;
  justify-content: center;
  /* align-items: center; */
}

/* .profile_img {
  margin: auto;
} */

img {
  height: 13vh;
  background-color: #fff;
  border-radius: 50%;
  /* border: 3px solid; */
  object-fit: cover;
  margin-top: 13vh;
}
</style>
