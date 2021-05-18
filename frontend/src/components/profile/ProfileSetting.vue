<template>
  <div class="profile-container">
    <select-profile-pic></select-profile-pic>
  </div>
</template>

<script>
import SelectProfilePic from '@/components/profile/SelectProfilePic';
export default {
  components: {
    SelectProfilePic,
  },
};
</script>

<style scoped>
.profile-container {
  /* position: relative; */
  display: flex;
  justify-content: center;
  /* align-items: center; */
  width: 100%;
  height: 100%;
}

.profile-container img {
  height: 30px;
  width: 30px;
  background-color: #fff;
  border-radius: 50%;
  object-fit: cover;
  /* border: 3px solid; */
}
</style>
