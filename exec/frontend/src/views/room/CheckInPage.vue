<template>
  <div class="checkin-wrapper">
    <div class="checkin-inner-wrapper">
      <h1 class="room-name">{{ roomName }}</h1>
      <div class="for-user" v-if="user">
        <p class="checkin-warning">잠깐!</p>
        <p class="checkin-warning">
          화상채팅은 웹캠을 이용한 서비스로 개인적인 공간의 노출이 발생할 수
          있습니다. 비디오를 시작하기 전 주변에 개인적인 정보를 노출할 수 있는
          위험 요소를 다시 한번 확인해 주시기 바랍니다. 또한, 개인적인 정보를
          요구하는 등의 행위는 불법임으로 즉각 신고 조치를 취해주십시오. 신고된
          사용자는 저희 POREST가 법적 조취를 취할 것입니다. 개인적인 부주의로
          인한 개인정보 노출에 대해서는 POREST가 책임지지 않습니다.
        </p>
        <div class="warning-checkbox">
          <p>위의 내용을 확인했습니다.</p>
          <input
            type="checkbox"
            v-model="checkState"
            class="checkbox"
            name=""
            id=""
          />
        </div>
        <span class="warning-checkbox-nonactive"
          >확인 여부를 체크해주세요.</span
        >
      </div>
      <form @submit.prevent="handleCheckIn">
        <div class="card-body" v-if="user">
          <div class="">
            <button class="checkin-btn" type="submit">입장하기</button>
          </div>
        </div>
        <div class="non-user" v-else>
          <h1 class="">죄송합니다.</h1>
          <p class="">
            로그인한 유저만 입장이 가능합니다. <br />
            <router-link to="/login">로그인</router-link> 혹은
            <router-link to="/register">회원가입</router-link>을 진행 후 이용해
            주세요. <br />
            감사합니다.
          </p>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import Firebase from 'firebase/app';
import '@firebase/auth';
import db from '@/db.js';
export default {
  name: 'Checkinpage',
  data() {
    return {
      nickName: null,
      // roomName: null,
      checkState: false,
    };
  },
  props: ['user', 'roomId', 'roomName', 'hostId'],
  methods: {
    handleCheckIn() {
      const warning = document.querySelector('.warning-checkbox-nonactive');
      if (!this.checkState) {
        warning.classList.add('warning-show');
        return;
      }
      warning.classList.remove('warning-show');

      const roomRef = db
        .collection('users')
        .doc(this.hostId)
        .collection('rooms')
        .doc(this.roomId);
      roomRef.get().then(doc => {
        if (doc.exists) {
          roomRef
            .collection('attendees')
            .doc(this.user.uid)
            .set({
              createdAt: Firebase.firestore.FieldValue.serverTimestamp(),
            })
            .then(() => {
              this.$emit('showApprove');
              // this.$router.push(`/chat/${this.hostId}/${this.roomId}`)
            });
        }
      });
    },
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
  mounted() {
    //Getting User
    Firebase.auth().onAuthStateChanged(user => {
      if (user) {
        this.nickName = user.nickName;
      }
    });

  },
};
</script>

<style scoped src="@/assets/css/CheckIn.css"></style>
