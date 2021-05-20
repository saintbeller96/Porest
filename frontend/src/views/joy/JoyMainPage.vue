<template>
  <div class="join__main__wrapper">
    <span @click="moveToBack" class="back">
      <i class="fas fa-arrow-left"></i>
    </span>
    <div class="intro__header">
      지치고 힘든 이유는, 그 만큼 당신이 열정적이었기 때문이다.
    </div>
    <div class="joy__category__wrapper">
      <div class="joy__items" @click="moveToHealingVR">
        <div class="thumbnail">
          <img src="../../assets/image/vr.png" alt="" />
        </div>
        <div class="title">VR 힐링 영상</div>
        <div class="content">
          힘든 현실 속에서 잠시 고민은 접어두고 <br />
          나에게 집중하는 여행을 떠나보세요.
        </div>
      </div>
      <div class="joy__items" @click="moveToHealingMusic">
        <div class="thumbnail">
          <img src="../../assets/image/headphone2.png" alt="" />
        </div>
        <div class="title">힐링 음악</div>
        <div class="content">
          잠시나마 온전히 나를 위해서 잔잔한 <br />음악에 귀 기울여보세요.
        </div>
      </div>
      <div class="joy__items" @click="moveToHealingSketch">
        <div class="thumbnail">
          <img src="../../assets/image/ejel2.png" alt="" />
        </div>
        <div class="title">힐링 스케치북</div>
        <div class="content">
          복잡한 생각을 한편의 그림을 그리면서 <br />정리해보세요.
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Joymainpage',
  data() {
    return {};
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  mounted() {},
  methods: {
    moveToBack() {
      this.$router.go(-1);
    },
    moveToHealingMusic() {
      this.$router.push({ name: 'HealingMusic' });
    },
    moveToHealingSketch() {
      this.$router.push({ name: 'Drawing' });
    },
    moveToHealingVR() {
      this.$router.push({ name: 'VrRoom' });
    },
  },
};
</script>

<style scoped src="@/assets/css/joy/JoyMainPage.css"></style>
