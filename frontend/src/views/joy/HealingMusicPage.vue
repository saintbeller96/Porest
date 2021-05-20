<template>
  <div class="healing__music__wrapper">
     <div class="before">
      <i class="fas fa-arrow-left" @click="moveToBack"></i>
    </div>
    <article class="contentWrap">
      <section class="album active">
        <div class="disk">
          <div class="disk_inner"></div>
        </div>
        <div target="blank" class="coverImg">
          <img class="thumbnail" src="../../assets/music/rain.jpg" alt="" />
          <audio id="audio" controls="controls">
            <source id="audioSource" src=""></source>
            Your browser does not support the audio format.
          </audio>
        </div>
      </section>
    </article>
    <section class="music__list__main__wrapper">
      <div class="music__list__wrapper">
        <div class="music__list">
          <div class="music__item" >
            <img src="../../assets/music/rain.jpg" alt="" />
            <div class="title">Rain</div>
            <div v-if="!playAudio" data-value="0" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" >
            <img src="../../assets/music/newYork.jpg" alt="" />
            <div class="title">In Albany NewYork</div>
            <div v-if="!playAudio" data-value="1" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="2">
            <img src="../../assets/music/nidraintSky.jpg" alt="" />
            <div class="title">Nidra in the Sky with Ayler</div>
            <div v-if="!playAudio" data-value="2" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="3">
            <img src="../../assets/music/quiteNight.jpg" alt="" />
            <div class="title">Quiet Nights</div>
            <div v-if="!playAudio" data-value="3" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="4">
            <img src="../../assets/music/seaSpace.jpg" alt="" />
            <div class="title">Sea Space</div>
            <div v-if="!playAudio" data-value="4" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="5">
            <img src="../../assets/music/serenity.jpg" alt="" />
            <div class="title">Serenity</div>
            <div v-if="!playAudio" data-value="5" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="6">
            <img src="../../assets/music/dreamingBlue.jpg" alt="" />
            <div class="title">Dreaming Blue</div>
            <div v-if="!playAudio" data-value="6" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="7">
            <img src="../../assets/music/harp.jpg" alt="" />
            <div class="title">Wistful Harp</div>
            <div v-if="!playAudio" data-value="7" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="8">
            <img src="../../assets/music/summer.jpg" alt="" />
            <div class="title">The Closing Of Summer</div>
            <div v-if="!playAudio" data-value="8" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="9">
            <img src="../../assets/music/noel.jpg" alt="" />
            <div class="title">The First Noel</div>
            <div v-if="!playAudio" data-value="9" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="10">
            <img src="../../assets/music/sonata.jpg" alt="" />
            <div class="title">Simple Sonata</div>
            <div v-if="!playAudio" data-value="10" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
          <div class="music__item" data-value="11">
            <img src="../../assets/music/river.jpg" alt="" />
            <div class="title">White River</div>
            <div v-if="!playAudio" data-value="11" @click="startAudio" class="audio__state__false">재생</div>
            <div v-else class="audio__state__true" @click="pauseAudio">정지</div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'Healingmusicpage',
  data() {
    return {
      thumbnails: [
        'rain',
        'newYork',
        'nidraintSky',
        'quiteNight',
        'seaSpace',
        'serenity',
        'dreamingBlue',
        'harp',
        'summer',
        'noel',
        'sonata',
        'river',
      ],
      activeAudio: '',
      playAudio: false,
      bgArray:[['#fa709a', '#fee140'],['#b6bfc8', '#36595b'],['#e58e82', '#6f569f'],['#ffecd2','#fcb69f'],['#ff9a9e','#fecfef'],['#d4fc79','#96e6a1'],['#e0c3fc','#8ec5fc']],
    };
  },
  mounted() {
  },
    created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  methods: {
    moveToBack(){
      this.$router.go(-1);
    },
    pauseAudio(){

      let audio = document.querySelector('#audio');
      audio.pause();
      this.playAudio = false;
    },
    startAudio(e){
      let mainWrapper = document.querySelector('.healing__music__wrapper');
      let audio = document.querySelector('#audio');
      let source = document.querySelector('#audioSource');
      let album = document.querySelector('.album');
      let disk_inner = document.querySelector('.disk_inner');

      if(source.src != ''){
        audio.pause();
      }
      if (this.activeAudio != '' && e.target == this.activeAudio) {
        this.activeAudio.classList.remove('active');
        audio.play();
        this.playAudio = true;
      }else{
        this.playAudio = true;
        e.target.classList.add('active');
        this.activeAudio = e.target;
        album.classList.remove('change');
        let thumbnail = document.querySelector('.thumbnail');
        let id = e.target.dataset.value;
        let bgindex = id;
        if (bgindex >= 7) {
          bgindex %= 7;
        }
        mainWrapper.style.background =
        'linear-gradient(120deg,' + this.bgArray[bgindex][0] + ', ' +  this.bgArray[bgindex][1] + ')';
        disk_inner.style.background = this.bgArray[bgindex][0]
        setTimeout(() => {
          let audioSource = this.getAudioUrl(this.thumbnails[id]);
          source.src = audioSource;
          audio.loop = false; // 반복재생하지 않음
          audio.volume = 0.3; // 음량 설정
          audio.load();
          audio.play(); // sound1.mp3 재생
          album.classList.add('change');
          let url = this.getImgUrl(this.thumbnails[id]);
          thumbnail.setAttribute('src', url);
        }, 100);
      }
    },
    getAudioUrl(id) {
      let audio = require.context('../../assets/music', false, /\.mp3$/);
      return audio('./' + id + '.mp3');
    },
    getImgUrl(index) {
      // vue 에서 이미지 루트 수정하는 방법
      let images = require.context('../../assets/music/', false, /\.jpg$/);
      return images('./' + index + '.jpg');
    },
    stopAudio() {},
  },
};
</script>

<style scoped src="@/assets/css/joy/HealingMusicPage.css"></style>
