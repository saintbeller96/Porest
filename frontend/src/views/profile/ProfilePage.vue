<template>
  <div>
    profile page
    <div class="body">
      <header>
        <profile></profile>
      </header>
      <article></article>
    </div>
    <!-- <temperature></temperature> -->
  </div>
</template>

<script>
// import Temperature from '@/components/profile/Temperature';
import Profile from '@/components/profile/Profile';
export default {
  components: {
    // Temperature,
    Profile,
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
  width: 100%;
  display: flex;
  background-image: linear-gradient(135deg, #a8edea 10%, #fed6e3 100%);
  /* background-image: linear-gradient( 135deg, #ff9a9e  10%, #F6416C 100%); */
}
::selection {
  color: #f2f2f2;
  background: #f86d8d;
}
.body::before,
.body::after {
  content: '';
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
}

header {
  height: 85vh;
  width: 30%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  z-index: 12;
  border-radius: 25px;
  margin: auto;
  position: relative;
}
article {
  height: 85vh;
  width: 60%;
  background: rgba(255, 255, 255, 0.1);
  box-shadow: 0 20px 50px rgba(0, 0, 0, 0.15);
  border-top: 1px solid rgba(255, 255, 255, 0.5);
  border-left: 1px solid rgba(255, 255, 255, 0.5);
  backdrop-filter: blur(5px);
  z-index: 12;
  border-radius: 25px;
  margin: auto;
  position: relative;
}
</style>
