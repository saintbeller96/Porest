<template>
  <div class="vr__wrapper">
    <div class="before">
      <i class="fas fa-arrow-left" @click="moveToBack"></i>
    </div>
    <section class="video__main__Wrapper">
      <iframe
        class="healing__VR"
        src="https://www.youtube.com/embed/6cVeAcvJMso"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
        allowfullscreen
      ></iframe>
    </section>
    <section class="video__list__Wrapper">
      <div class="video__list">
        <div
          class="video__item"
          v-for="(item, index) in videoList"
          :key="index"
          :data-value="index"
          @click="showVideo(index)"
        >
          <div class="content__wrapper">
            <div class="title">
              {{ videoListTitle[index] }}
            </div>
            <div class="content">
              {{ videoListContent[index] }}
            </div>
            <div class="footer">
              {{
                index != 5
                  ? 'Copyright 2021. PIXMEDIA inc. all rights reserved.'
                  : 'Copyright 2021. 힐링한스푼 inc. all rights reserved.'
              }}
            </div>
          </div>
          <iframe
            class="vr__thumbnail"
            :src="videoList[index]"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'VrRoomPage',
  data() {
    return {
      videoList: [
        'https://www.youtube.com/embed/6cVeAcvJMso',
        'https://www.youtube.com/embed/YAKaiyqET1E',
        'https://www.youtube.com/embed/j7hq9y8n-4Y',
        'https://www.youtube.com/embed/prHVYrHUg7w',
        'https://www.youtube.com/embed/BzWRuF4u7d8',
        'https://www.youtube.com/embed/LZlclmsAUNU',
      ],
      videoListTitle: [
        "아름다운 수중세계 360도 힐링VR 8K']",
        '힐링영상_북유럽감성, 인제 자작나무숲',
        '감성 가을 힐링 VR',
        'VR 최면 심리치료에 사용된 힐링, 명상, 휴식 콘텐츠',
        '제주 휴일로 카페의 늦은 오후 VR 타임랩스',
        '푸른 바다에서 물고기를 만나 보세요 ',
      ],
      videoListContent: [
        '복잡하고 지친 일상에서 벗어나 스스로에 집중하며,잠시 쉬어 보는 건 어떨까요.\
        강원도 인제 원대리 설경 속 도도하고 깨끗한 자태의 자작나무.\
        360도 VR동영상으로 힐링의 시간을 갖어보시기 바랍니다.',
        "깊고 푸른 아름다운 수중세계를 아무 생각\
        없이 바라보는 '물멍'의 시간을 갖어보는 것은 어떨까요... 자연, 특히\
        물을 바라보며 찾는 힐링의 시간이 되시길 바랍니다.",
        '노랗게 물든 은행나무의 가을 정취를 만끽하기 좋은 계절입니다.\
        픽스미디어는 아름다운 늦가을 하늘과 울긋불긋 물든 가을의 정취를 느끼며 음악과 함께  편안한 마음으로 힐링할 수 있는 360도 Relaxation VR영상을 준비했습니다.  \
        짧기만 한 가을,  VR영상으로 잠시 힐링해 보세요! ',
        '최근 스트레스를 풀 수 있는 음악, 영상, 소리 등을 찾아 힐링하고 마음을 치료하고자 하는 분들이 많습니다.  특히 최근 전세계적으로 VR기술을 의학적 치료 목적으로 활용, 높은 효과를 보고 있다고 합니다.  몰입감과 현장감 있는 VR 콘텐츠로 심리적 안정과 힐링을 느껴보시죠...',
        '겨울 바다를 마주하고 있는 조용한 휴일로 카페에서 잠시 힐링해 보시기 바랍니다.',
        '팔라완에서 가장 아름다운 바다를 자랑하는 혼다베이의 섬들을 방카배를 이용하여 아름다운 비치에서 해수욕, 맑은 바다에서의 스노쿨링을 하며 형형색색의 열대어와 아름다운 바다를 몸으로 느껴보실 수 있어요. 사람의 손길이 닿지 않는 섬에서 즐기는 낭만적인 시간은 잊지못할 추억이 되는 곳입니다. 그럼 스노쿨링으로 바다속 세계를 VR로 체험해보세요',
      ],
      bgArray: [
        ['#0272a4', '#f6a564'],
        ['#b6bfc8', '#36595b'],
        ['#e58e82', '#6f569f'],
        ['#ffecd2', '#fcb69f'],
        ['#ff9a9e', '#fecfef'],
        ['#4facfe', '#66a6ff'],
        ['#e0c3fc', '#8ec5fc'],
      ],
    };
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  methods: {
    moveToBack() {
      this.$router.go(-1);
    },
    showVideo(index) {
      const frame = document.querySelector('.healing__VR');
      const mainWrapper = document.querySelector('.vr__wrapper');
      mainWrapper.style.background =
        'linear-gradient(120deg,' +
        this.bgArray[index][0] +
        ', ' +
        this.bgArray[index][1] +
        ')';
      frame.src = this.videoList[index];
    },
  },
};
</script>

<style scoped src="@/assets/css/joy/VRRoom.css"></style>
