<template>
  <div class="sticker-box">
    <div class="stickers">
      <div v-for="(data, idx) in todaysSticker" :key="idx" class="container">
        <div class="img-container">
          <img :src="data" class="img" :class="`sticker${idx}`" @click="getStickerIndex(idx)" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      check: [],
      todaysSticker: [
        require('../../assets/image/sticker/1.png'),
        require('../../assets/image/sticker/2.png'),
        require('../../assets/image/sticker/3.png'),
        require('../../assets/image/sticker/4.png'),
        require('../../assets/image/sticker/5.png'),
        require('../../assets/image/sticker/6.png'),
        require('../../assets/image/sticker/7.png'),
        require('../../assets/image/sticker/8.png'),
        require('../../assets/image/sticker/9.png'),
        require('../../assets/image/sticker/10.png'),
        require('../../assets/image/sticker/11.png'),
        require('../../assets/image/sticker/12.png'),
        require('../../assets/image/sticker/13.png'),
        require('../../assets/image/sticker/14.png'),
        require('../../assets/image/sticker/15.png'),
        require('../../assets/image/sticker/16.png'),
        require('../../assets/image/sticker/17.png'),
        require('../../assets/image/sticker/18.png'),
        require('../../assets/image/sticker/19.png'),
        require('../../assets/image/sticker/20.png'),
        require('../../assets/image/sticker/21.png'),
        require('../../assets/image/sticker/22.png'),
        require('../../assets/image/sticker/23.png'),
        require('../../assets/image/sticker/24.png'),
        require('../../assets/image/sticker/25.png'),
        require('../../assets/image/sticker/26.png'),
        require('../../assets/image/sticker/27.png'),
        require('../../assets/image/sticker/28.png'),
        require('../../assets/image/sticker/29.png'),
        require('../../assets/image/sticker/30.png'),
        require('../../assets/image/sticker/31.png'),
        require('../../assets/image/sticker/32.png'),
        require('../../assets/image/sticker/33.png'),
        require('../../assets/image/sticker/34.png'),
        require('../../assets/image/sticker/35.png'),
        require('../../assets/image/sticker/36.png'),
        require('../../assets/image/sticker/37.png'),
        require('../../assets/image/sticker/38.png'),
        require('../../assets/image/sticker/39.png'),
        require('../../assets/image/sticker/40.png'),
        require('../../assets/image/sticker/41.png'),
        require('../../assets/image/sticker/42.png'),
        require('../../assets/image/sticker/43.png'),
        require('../../assets/image/sticker/44.png'),
        require('../../assets/image/sticker/45.png'),
        require('../../assets/image/sticker/46.png'),
        require('../../assets/image/sticker/47.png'),
        require('../../assets/image/sticker/48.png'),
        require('../../assets/image/sticker/49.png'),
        require('../../assets/image/sticker/50.png'),
      ],
    };
  },
  methods: {
    getStickerIndex(n) {
      let index = n + 1;
      if (this.check.length === 0) {
        this.check.push(n);
        const selected = document.querySelector(`.sticker${n}`);
        selected.classList.toggle('selected');
        this.$store.commit('getSelectedSticker', `${index}.png`);
      } else {
        let a = this.check.pop();
        const selected1 = document.querySelector(`.sticker${a}`);
        const selected2 = document.querySelector(`.sticker${n}`);
        if (a === n) {
          selected1.classList.toggle('selected');
          this.$store.commit('getSelectedSticker', '');
        } else if (a !== n) {
          this.check.push(n);
          selected1.classList.toggle('selected');
          selected2.classList.toggle('selected');
          this.$store.commit('getSelectedSticker', `${index}.png`);
        }
      }
    },
  },
  mounted() {
    if (this.$store.state.stickerindex !== 0) {
      let n = this.$store.state.stickerindex - 1;
      this.check.push(n);
      const selected = document.querySelector(`.sticker${n}`);
      selected.classList.toggle('selected');
    }
  },
};
</script>

<style scoped>
.sticker-box {
  height: 15vh;
  width: 100%;
  background: #fffcf5;
  overflow: hidden;
  overflow-y: scroll;
}

.stickers {
  margin-left: 1vw;
}

.swiper {
  height: 8vh;
  display: flex;
  text-align: center;
}

.img {
  width: 2.8vw;
  cursor: pointer;
  margin-top: 1vh;
  margin-right: 1.3vw;
  filter: opacity(0.5) drop-shadow(0 0 0 white);
  transition: 0.1s ease;
}

.img:hover {
  transform: scale(1.23);
  filter: none;
}

.img-container {
  float: left;
}

.selected {
  transform: scale(1.23);
  filter: none;
}
</style>
