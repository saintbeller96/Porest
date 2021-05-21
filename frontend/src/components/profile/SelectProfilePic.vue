<template>
  <div>
    <div class="profile-pic">
      <div class="menu-item">
        <img
          :src="
            $store.getters.getUpdateProfileImg != 0
              ? images[$store.getters.getUpdateProfileImg - 1]
              : require('../../assets/image/profile.png')
          "
        />
      </div>
    </div>
    <div class="images">
      <img
        src="../../assets/image/profile.png"
        @click="getFeeling(0)"
        class="img0 basic"
      />
      <img
        src="../../assets/image/feeling/5.png"
        @click="getFeeling(5)"
        class="img5"
      />
      <img
        src="../../assets/image/feeling/4.png"
        @click="getFeeling(4)"
        class="img4"
      />
      <img
        src="../../assets/image/feeling/3.png"
        @click="getFeeling(3)"
        class="img3"
      />
      <img
        src="../../assets/image/feeling/2.png"
        @click="getFeeling(2)"
        class="img2"
      />
      <img
        src="../../assets/image/feeling/1.png"
        @click="getFeeling(1)"
        class="img1"
      />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      profileImg: 0,
      check: [],
      images: [
        require('../../assets/image/feeling/1.png'), // 0
        require('../../assets/image/feeling/2.png'), // 1
        require('../../assets/image/feeling/3.png'), // 2
        require('../../assets/image/feeling/4.png'),
        require('../../assets/image/feeling/5.png'),
      ],
    };
  },
  methods: {
    getFeeling(n) {
      if (this.check.length === 0) {
        this.check.push(n);
        const selected = document.querySelector(`.img${n}`);
        selected.classList.toggle('selected');
        this.$store.commit('setImg', n);
      } else {
        let a = this.check.pop();
        const selected1 = document.querySelector(`.img${a}`);
        const selected2 = document.querySelector(`.img${n}`);
        if (a == n) {
          selected1.classList.toggle('selected');
          this.$store.commit('setImg', 0);
        } else if (a != n) {
          this.check.push(n);
          selected1.classList.toggle('selected');
          selected2.classList.toggle('selected');
          this.$store.commit('setImg', n);
        }
      }
    },
  },
  created() {
    if (this.$store.state.profileImg === 'null') {
      this.$store.commit('setImg', 0);
    }
  },
  mounted() {
    let n = this.$store.state.profileImg;
    this.check.push(n);
    const selected = document.querySelector(`.img${n}`);
    selected.classList.toggle('selected');
  },
};
</script>

<style scoped>
.profile-pic {
  margin-bottom: 3vh;
  display: flex;
  justify-content: center;
  margin-top: 2vh;
}

.menu-item img {
  height: 10vh;
  background-color: #fff;
  border-radius: 50%;
  object-fit: cover;
}

.images {
  display: flex;
  justify-content: center;
  margin-bottom: 6vh;
}

.images img {
  width: 2.3vw;
  margin: 0 0.45vw 0 0.45vw;
  cursor: pointer;
  transition: 0.1s ease;
  filter: opacity(0.7) drop-shadow(0 0 0 white);
}

.basic {
  background: #fff;
  border-radius: 50%;
}

.images img:hover {
  transform: scale(1.3);
  filter: none;
}

.img1.selected {
  transform: scale(1.3);
  filter: none;
}
.img2.selected {
  transform: scale(1.3);
  filter: none;
}
.img3.selected {
  transform: scale(1.3);
  filter: none;
}
.img4.selected {
  transform: scale(1.3);
  filter: none;
}
.img5.selected {
  transform: scale(1.3);
  filter: none;
}
.img0.selected {
  transform: scale(1.3);
  filter: none;
}
</style>
