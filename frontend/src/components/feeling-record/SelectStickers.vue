<template>
  <div class="sticker-box">
    <swiper class="swiper" :options="swiperOption">
      <swiper-slide><img src="../../assets/image/sticker/1.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/2.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/3.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/4.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/5.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/6.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/7.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/8.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/9.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/10.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/11.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/12.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/13.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/14.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/15.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/16.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/17.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/18.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/19.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/20.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/21.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/22.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/23.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/24.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/25.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/26.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/27.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/28.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/29.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/30.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/31.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/32.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/33.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/34.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/35.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/36.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/37.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/38.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/39.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/40.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/41.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/42.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/43.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/44.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/45.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/46.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/47.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/48.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/49.png" class="img"/></swiper-slide>
      <swiper-slide><img src="../../assets/image/sticker/50.png" class="img"/></swiper-slide>
      <div class="swiper-pagination" slot="pagination"></div>
    </swiper>
  </div>
</template>

<script>
import Vue from 'vue';
import { Swiper, SwiperSlide } from 'vue-awesome-swiper';
import 'swiper/swiper-bundle.css';

export default Vue.extend({
  components: {
    Swiper,
    SwiperSlide,
  },
  data() {
    return {
      swiperOption: {
        slidesPerView: 5,
        spaceBetween: 10,
        pagination: {
          el: '.swiper-pagination',
          clickable: true,
        },
        // breakpoints: {
        //   1024: {
        //     slidesPerView: 4,
        //     spaceBetween: 40,
        //   },
        //   768: {
        //     slidesPerView: 3,
        //     spaceBetween: 30,
        //   },
        //   640: {
        //     slidesPerView: 2,
        //     spaceBetween: 20,
        //   },
        //   320: {
        //     slidesPerView: 1,
        //     spaceBetween: 10,
        //   },
        // },
      },
    };
  },
  created() {},
  methods: {},
  computed: {},
});
</script>

<style scoped>
.swiper {
  height: 8vh;
  display: flex;
  text-align: center;
}

.img {
  width: 3.2vw;
  cursor: pointer;
  margin-top: 0.58vh;
}

.img:hover {
  transform: scale(1.2);
}
</style>
