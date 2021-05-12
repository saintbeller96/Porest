<template>
  <div>
    <div class="images">
      <img src="../../assets/image/feeling/5.png" />
      <img src="../../assets/image/feeling/4.png" />
      <img src="../../assets/image/feeling/3.png" />
      <img src="../../assets/image/feeling/2.png" />
      <img src="../../assets/image/feeling/1.png" @click="getFeeling" />
    </div>
    <!-- <nav class="menu">
      <input type="checkbox" href="#" class="menu-open" name="menu-open" id="menu-open" />
      <label class="menu-open-button" for="menu-open">
        <i class="fa fa-bars"></i>
      </label>
      <img src="../../assets/image/feeling/5.png" class="menu-item" />
      <img src="../../assets/image/feeling/4.png" class="menu-item" />
      <img src="../../assets/image/feeling/3.png" class="menu-item" />
      <img src="../../assets/image/feeling/2.png" class="menu-item" />
      <img src="../../assets/image/feeling/1.png" class="menu-item" @click="getFeeling" />
    </nav> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      // key: value
    };
  },
  methods: {
    getFeeling() {
      console.log('!!');
    },
  },
};
</script>

<style scoped>
.images {
  display: flex;
  justify-content: center;
}

.images img {
  width: 2.8vw;
  margin: 0 0.5vw 0 0.5vw;
  cursor: pointer;
  transition: 0.2s ease;
}

.images img:hover {
  transform: scale(1.2);
}

.menu {
  /* -webkit-filter: url(#shadowed-goo); */
  /* top: 30%; */
  /* position: static; */
}

.menu-open-button {
  background: #ffd93b;
  border-radius: 100%;
  /* width: 45px; */
  width: 2.92vw;
  /* height: 45px; */
  height: 6.23vh;
  position: absolute;
  color: white;
  line-height: 80px;
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: -webkit-transform ease-out 200ms;
  display: flex;
  justify-content: center;
  align-items: center;
}

.menu-item {
  background: #ffd93b;
  border-radius: 100%;
  width: 2.92vw;
  position: absolute;
  color: white;
  line-height: 80px;
  -webkit-transform: translate3d(0, 0, 0);
  -webkit-transition: -webkit-transform ease-out 200ms;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: 1s;
  cursor: pointer;
}

.menu-open {
  display: none;
}
.menu {
  /* position: absolute; */
  width: 93%;
  /* width: 650px; */
  /* height: 150px; */
  height: 10%;
  box-sizing: border-box;
  font-size: 15px;
  text-align: left;
  /* margin-top: 3vh; */
}

.menu-item:hover {
  width: 50px;
  /* transform: scale(1.5); */
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
  -webkit-transition-timing-function: cubic-bezier(0.1, 0.8, 0.4, 1);
}

.menu-open:checked ~ .menu-item:nth-child(3) {
  -webkit-transition-duration: 200ms;
  -webkit-transform: translate3d(3.5vw, 0, 0);
}
.menu-open:checked ~ .menu-item:nth-child(4) {
  -webkit-transition-duration: 300ms;
  -webkit-transform: translate3d(7.3vw, 0, 0);
}
.menu-open:checked ~ .menu-item:nth-child(5) {
  -webkit-transition-duration: 400ms;
  -webkit-transform: translate3d(11.1vw, 0, 0);
}
.menu-open:checked ~ .menu-item:nth-child(6) {
  -webkit-transition-duration: 500ms;
  -webkit-transform: translate3d(14.9vw, 0, 0);
}
.menu-open:checked ~ .menu-item:nth-child(7) {
  -webkit-transition-duration: 500ms;
  -webkit-transform: translate3d(18.7vw, 0, 0);
}
</style>
