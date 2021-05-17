<template>
  <div class="profile-container">
    <nav class="menu">
      <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" />
      <label class="menu-open-button" for="menu-open">
        <img src="@/assets/image/profile.png" alt="" />
      </label>
      <div class="menu-item"><img src="../../assets/image/feeling/5.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/4.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/3.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/2.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/1.png" /></div>
      <div class="menu-item"><img src="../../assets/image/feeling/5.png" /></div>
    </nav>
    <!-- <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
      <defs>
        <filter id="shadowed-goo">
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feGaussianBlur in="goo" stdDeviation="3" result="shadow" />
          <feColorMatrix
            in="shadow"
            mode="matrix"
            values="0 0 0 0 0  0 0 0 0 0  0 0 0 0 0  0 0 0 1 -0.2"
            result="shadow"
          />
          <feOffset in="shadow" dx="1" dy="1" result="shadow" />
          <feComposite in2="shadow" in="goo" result="goo" />
          <feComposite in2="goo" in="SourceGraphic" result="mix" />
        </filter>
        <filter id="goo">
          <feGaussianBlur in="SourceGraphic" result="blur" stdDeviation="10" />
          <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 18 -7" result="goo" />
          <feComposite in2="goo" in="SourceGraphic" result="mix" />
        </filter>
      </defs>
    </svg> -->
  </div>
</template>

<script>
export default {};
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

/* .menu {
  -webkit-filter: url('#goo');
} */

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
