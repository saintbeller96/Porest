<template>
  <div class="body">
    <div class="profile-area">
      <profile></profile>
    </div>
    <div class="bookmark-area">
      <bookmark></bookmark>
    </div>

    <div class="active-record-area">
      <active-record></active-record>
    </div>

    <!-- <temperature></temperature> -->
  </div>
</template>

<script>
// import Temperature from '@/components/profile/Temperature';
import Profile from '@/components/profile/Profile';
import Bookmark from '@/components/profile/Bookmark';
import ActiveRecord from '@/components/profile/ActiveRecord';
export default {
  components: {
    // Temperature,
    Profile,
    Bookmark,
    ActiveRecord,
  },
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
  transition: all 0.3s ease;
}
.body {
  height: 100vh;
  width: 100vw;
  display: grid;
  background-image: linear-gradient(135deg, #a8edea 10%, #fed6e3 100%);
  justify-content: center;
  /* 그리드 나누기 */
  grid-template-columns: repeat(7, 1fr);
  grid-template-rows: 1fr 1fr;
  box-sizing: border-box;
}

.profile-area {
  grid-column-start: 2;
  grid-column-end: 3;
  grid-row-start: 1;
  grid-row-end: span 2;
  margin: 4.1vh 1.4vw 0 0;
}

.bookmark-area {
  grid-column-start: 3;
  grid-column-end: 7;
  grid-row-start: 1;
  grid-row-end: 2;
  margin-top: 4.1vh;
}
.active-record-area {
  grid-column-start: 3;
  grid-column-end: 7;
  grid-row-start: 2;
  grid-row-end: 3;
}
</style>
