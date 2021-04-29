<template>
  <div class="home-wrapper">
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>
    <div class="paper-plane">
      <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 95.04 61.39">
        <g id="레이어_2" data-name="레이어 2">
          <g id="Capa_1" data-name="Capa 1">
            <g>
              <polygon class="cls-1" points="0 0 95.04 23.47 59.64 37.59 0 0" />
              <polygon class="cls-2" points="59.64 37.59 57.04 56.59 0 0 59.64 37.59" />
              <polygon class="cls-3" points="51 41.92 57.04 56.59 0 0 51 41.92" />
              <polygon class="cls-1" points="0 0 51 41.92 17.36 61.39 0 0" />
            </g>
          </g>
        </g>
      </svg>
    </div>

    <section>
      <div class="color"></div>
      <div class="color"></div>
      <div class="color"></div>
      <div class="box">
        <div class="square" style="--i:0;"></div>
        <div class="square" style="--i:1;"></div>
        <div class="square" style="--i:2;"></div>
        <div class="square" style="--i:3;"></div>
        <div class="square" style="--i:4;"></div>
        <div class="container">
          <div class="form">
            <h1>login form</h1>
            <form>
              <div class="inputBox">
                <input type="text" placeholder="User Name" />
              </div>
              <div class="inputBox">
                <input type="password" placeholder="User Password" />
              </div>
              <div class="inputBox">
                <input type="submit" value="Login" />
              </div>
              <p class="forget">Forget password?<a href="#">Click here</a></p>
              <p class="forget">Don't you have a account?<a href="#">Sign up</a></p>
            </form>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data() {
    return {
      user: null,
    };
  },
  mounted() {},
  methods: {},
};
</script>

<style scoped>
.home-wrapper {
  position: relative;
  overflow: hidden;
  box-sizing: border-box;
  background-image: url('../../assets/image/sky3.png');
  background-position: 50% 50%;
  background-repeat: no-repeat;
  background-size: cover;
}

.paper-plane {
  position: absolute;

  width: 50px;
  height: 50px;
  animation: paper1 8s ease-in-out infinite;
}

.paper-plane:nth-child(1) {
  top: 60%;
  right: 3%;
}

@keyframes paper1 {
  100% {
    transform: translate(-1000px, -1000px);
  }
}
.paper-plane:nth-child(2) {
  top: 40%;
  right: -13%;
}
.paper-plane:nth-child(3) {
  top: 100%;
  right: 50%;
}
.paper-plane:nth-child(4) {
  top: 80%;
  right: 30%;
}
.cls-1 {
  fill: rgba(255, 255, 255, 0.98);
}

.cls-1,
.cls-2,
.cls-3 {
  fill-rule: evenodd;
}

.cls-2 {
  fill: rgba(255, 255, 255, 0.3);
}

.cls-3 {
  fill: rgba(255, 255, 255, 0.2);
}

section {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  /* background: linear-gradient(to bottom, #f1f4f9, #dff1ff); */
}

/* section .color {
  position: absolute;
  filter: blur(150px);
}
section .color:nth-child(1) {
  top: -350px;
  width: 600px;
  height: 600px;
  background: #ff359b;
}
section .color:nth-child(2) {
  bottom: -150px;
  left: 100px;
  width: 500px;
  height: 500px;
  background: #fffd87;
}
section .color:nth-child(3) {
  bottom: 50px;
  right: 100px;
  width: 300px;
  height: 300px;
  background: #00d2ff;
} */

.box {
  position: relative;
}

.box .square {
  position: absolute;
  backdrop-filter: blur(5px);
  background: rgba(255, 255, 255, 0.1);

  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  border-radius: 100%;
  animation: move 10s linear infinite;
  animation-delay: calc(-1s * var(--i));
}

@keyframes move {
  0%,
  100% {
    transform: translateY(-40px);
  }
  50% {
    transform: translateY(40px);
  }
}

.box .square:nth-child(1) {
  top: -50px;
  right: -60px;
  width: 100px;
  height: 100px;
}
.box .square:nth-child(2) {
  top: 150px;
  left: -100px;
  width: 120px;
  height: 120px;
  z-index: 2;
}
.box .square:nth-child(3) {
  bottom: 50px;
  right: -60px;
  width: 80px;
  height: 80px;
  z-index: 2;
}
.box .square:nth-child(4) {
  bottom: -80px;
  left: 100px;
  width: 50px;
  height: 50px;
}
.box .square:nth-child(5) {
  top: -80px;
  left: 140px;
  width: 60px;
  height: 60px;
}
.container {
  position: relative;
  width: 400px;
  min-height: 400px;
  background: rgba(255, 255, 255, 0.1);
  border-radius: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  backdrop-filter: blur(5px);
  box-shadow: 0 25px 45px rgba(0, 0, 0, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.5);

  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

.form {
  position: relative;
  width: 100%;
  height: 100%;
  padding: 40px;
}

.form h1 {
  position: relative;
  color: #fff;
  font-size: 24px;
  font-weight: 600;
  letter-spacing: 1px;
  margin-bottom: 40px;
}

.form h1::before {
  content: '';
  position: absolute;
  left: 0;
  bottom: -10px;
  width: 80px;
  height: 4px;
  background: #fff;
}

.form .inputBox {
  width: 100%;
  margin-top: 20px;
}

.form .inputBox input {
  width: 100%;
  background: rgba(255, 255, 255, 0.2);
  border: none;
  outline: none;
  padding: 10px;
  border-radius: 35px;
  border: 1px solid rgba(255, 255, 255, 0.5);
  border-right: 1px solid rgba(255, 255, 255, 0.2);
  border-bottom: 1px solid rgba(255, 255, 255, 0.2);
  font-size: 16px;
  letter-spacing: 1px;
  color: #fff;
  box-shadow: 0 15px 15px rgba(0, 0, 0, 0.05);
}

.form .inputBox input::placeholder {
  color: #fff;
}

.form .inputBox input[type='submit'] {
  background: #fff;
  color: #666;
  max-width: 100px;
  cursor: pointer;
  margin-bottom: 20px;
  font-weight: 600;
}

.forget {
  margin-top: 2px;
  color: #fff;
}

.forget a {
  color: #fff;
  font-weight: 600;
}
</style>
