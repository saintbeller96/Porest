<template>
  <div>
    <nav class="menu">
      <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" />
      <label class="menu-open-button" for="menu-open">
        <img
          :src="$store.state.profileImg === 0 ? $store.state.profileImg : require('@/assets/image/profile.png')"
          class="basic-img"
        />
        <!-- <img src="@/assets/image/profile.png" alt="" class="basic-img" /> -->
      </label>
      <div class="menu-item"><img src="../../assets/image/feeling/5.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/4.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/3.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/2.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/1.png" /></div>
      <div class="menu-item"><img src="../../assets/image/profile.png" /></div>
    </nav>
  </div>
</template>

<script>
export default {
  data() {
    return {
      profileImg: [
        require('../../assets/image/feeling/1.png'),
        require('../../assets/image/feeling/2.png'),
        require('../../assets/image/feeling/3.png'),
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
    };
  },
};
</script>

<style scoped>
.menu-item img {
  /* width: 3.3vw; */
  width: 50px;
  height: 50px;
  /* height: 7vh; */
}

.menu-open-button img {
  /* width: 3.3vw;
  height: 7vh; */
  width: 50px;
  height: 50px;
  background: #fff;
  border-radius: 50%;
}

.menu-item,
.menu-open-button {
  border-radius: 100%;
  position: absolute;
  text-align: center;
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: -webkit-transform ease-out 200ms;
  margin-top: 200px;
}
.menu-open {
  display: none;
}
.menu {
  position: absolute;
  left: 45%;
  top: -23%;
  box-sizing: border-box;
  font-size: 20px;
  /* text-align: left; */
  margin-left: -190px;
  /* padding-top: 20px; */
  padding-left: 190px;
  /* width: 380px;
  height: 250px; */
}
.menu-item:hover {
  background: white;
  color: #e91e63;
}
.menu-item:nth-child(3) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(4) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(5) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(6) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(7) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(8) {
  -webkit-transition-duration: 180ms;
}
.menu-item:nth-child(9) {
  -webkit-transition-duration: 180ms;
}
.menu-open-button {
  z-index: 2;
  -webkit-transition-timing-function: cubic-bezier(0.1, 0.8, 0.3, 1.2);
  -webkit-transition-duration: 400ms;
  -webkit-transform: scale(1.1, 1.1) translate3d(0, 0, 0);
  cursor: pointer;
}
.menu-open-button:hover {
  -webkit-transform: scale(1.2, 1.2) translate3d(0, 0, 0);
}
.menu-open:checked + .menu-open-button {
  -webkit-transition-timing-function: linear;
  -webkit-transition-duration: 200ms;
  -webkit-transform: scale(0.8, 0.8) translate3d(0, 0, 0);
}
.menu-open:checked ~ .menu-item {
  -webkit-transition-timing-function: cubic-bezier(0.9, 0, 0.3, 1.3);
}
.menu-open:checked ~ .menu-item:nth-child(3) {
  -webkit-transition-duration: 380ms;
  -webkit-transform: translate3d(0.08%, -104.9%, 0);
  /* -webkit-transform: translate3d(0.08px, -104.9px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(4) {
  -webkit-transition-duration: 480ms;
  -webkit-transform: translate3d(90.9%, -52.6%, 0);
  /* -webkit-transform: translate3d(90.9px, -52.6px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(5) {
  -webkit-transition-duration: 580ms;
  -webkit-transform: translate3d(90.9%, 52.6%, 0);
  /* -webkit-transform: translate3d(90.9px, 52.6px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(6) {
  -webkit-transition-duration: 680ms;
  -webkit-transform: translate3d(0.08%, 104.9%, 0);
  /* -webkit-transform: translate3d(0.08px, 104.9px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(7) {
  -webkit-transition-duration: 780ms;
  -webkit-transform: translate3d(-90.8%, 52.6%, 0);
  /* -webkit-transform: translate3d(-90.8px, 52.6px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(8) {
  -webkit-transition-duration: 880ms;
  -webkit-transform: translate3d(-91.03%, -52.3%, 0);
  /* -webkit-transform: translate3d(-91.03px, -52.3px, 0); */
}
.menu-open:checked ~ .menu-item:nth-child(9) {
  -webkit-transition-duration: 980ms;
  -webkit-transform: translate3d(-0.25%, -104.9%, 0);
  /* -webkit-transform: translate3d(-0.25px, -104.9px, 0); */
}
</style>
