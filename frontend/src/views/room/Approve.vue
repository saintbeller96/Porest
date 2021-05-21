<template>
  <div class="approve-wrapper">
    <div class="approve-inner-wrapper">
      <div class="room-name-header">
        <div class="room_name">{{ roomName }}</div>
        <div class="buttons">
          <form class="approve-form" @submit.prevent>
            <input type="hidden" name="roomId" value="something" />
            <input type="hidden" name="userId" value="something" />
            <input type="hidden" name="roomName" value="something" />
            <button
              v-if="!attendeeJoined && attendeeApproved"
              class="join-btn"
              @click="doJoin"
            >
              입장하기
            </button>
            <button
              v-if="!attendeeJoined && attendeeApproved"
              class="leave-btn"
              @click="doLeave(user.uid)"
            >
              나가기
            </button>
          </form>
        </div>
      </div>
      <div
        class="attendee-list-wrapper"
        v-if="(user && user.uid == hostId) || attendeeApproved"
      >
        <div class="attendee-attend">
          <h4 class="">* 참가자</h4>
          <ul class="">
            <li
              v-for="(attendee, index) in attendeesApprovedArr"
              :key="attendee.id"
            >
              <div class="attendee-nickname" v-if="attendee.id != hostId">
                익명이{{ index + 1 }}
              </div>
              <div class="attendee-nickname" v-else>담이</div>
              <a
                type="button"
                class="approve-btn-attend"
                title="Approve attendee"
                @click="toggleApproval(attendee.id)"
                v-if="user && user.uid == hostId"
              >
                내보내기
              </a>
            </li>
          </ul>
        </div>
        <div v-if="user && user.uid == hostId" class="attendee-wait">
          <h4 class="">* 참가 대기자</h4>
          <ul class="">
            <li
              class=""
              v-for="(attendee, index) in attendeesPendingArr"
              :key="attendee.id"
            >
              <div class="attendee-nickname" v-if="attendee.id != hostId">
                익명이{{ index + 1 }}
              </div>
              <div class="attendee-nickname" v-else>담이</div>
              <span>
                <a
                  type="button"
                  class="approve-btn-attend"
                  title="Approve attendee"
                  @click="toggleApproval(attendee.id)"
                  >참가승인
                </a>
                <a
                  type="button"
                  class="approve-btn-delete"
                  title="Delete Attendee"
                  @click="deleteAttendee(attendee.id)"
                  >참가거절</a
                >
              </span>
            </li>
          </ul>
        </div>
      </div>
      <div v-else>
        <p class="lead">
          안녕하세요! 현재 참가 요청에 대한 방장의 승인이 진행 중에 있습니다.
          잠시만 기다려주세요!
        </p>
        <div class="leave_approve" @click="doLeave(user.uid)">
          나가기
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
// import Firebase from 'firebase';
import db from '@/db';
export default {
  data: function() {
    return {
      hostNickName: null,
      attendeesPendingArr: [],
      attendeesApprovedArr: [],
      attendeeApproved: false,
      attendeeJoined: false,
      roomPublic: false,
    };
  },
  components: {},
  methods: {
    toggleApproval: function(attendeeID) {
      // host인 경우만 승인이 가능하다.
      if (this.user && this.user.uid == this.hostId) {
        const ref = db
          .collection('users')
          .doc(this.user.uid)
          .collection('rooms')
          .doc(this.roomId)
          .collection('attendees')
          .doc(attendeeID);

        ref.get().then(attendeeDoc => {
          const approved = attendeeDoc.data().approved;
          if (approved) {
            ref.update({
              approved: !approved,
            });
          } else {
            ref.update({
              approved: true,
            });
          }
        });
      }
    },
    deleteAttendee: function(attendeeID) {
      // host인 경우만 삭제가 가능하다
      if (
        (this.user && this.user.uid == this.hostId) ||
        (this.user && this.user.uid == attendeeID)
      ) {
        db.collection('users')
          .doc(this.hostId)
          .collection('rooms')
          .doc(this.roomId)
          .collection('attendees')
          .doc(attendeeID)
          .delete();
      }
    },
    doJoin() {
      const form = document.querySelector('.approve-form');
      if (this.roomPublic) {
        form.action = 'https://live.porest.kr/';
      } else {
        form.action = 'https://live.porest.kr/ar';
        // form.action = 'http://localhost:3000/ar';
      }
      form.method = 'POST';
      form.target = 'pop';
      form.roomId.value = this.roomId;
      form.userId.value = this.user.uid;
      form.roomName.value = this.roomName;
      window.open('', 'pop');
      form.submit();
    },
    doLeave(uid) {
      this.deleteAttendee(uid);
      this.attendeeJoined = false;
      this.$emit('exitRoom');
    },
  },
  props: ['user', 'roomId', 'roomName', 'hostId'],

  mounted() {
    const roomRef = db
      .collection('users')
      .doc(this.hostId)
      .collection('rooms')
      .doc(this.roomId);
    //Get Room Name
    roomRef.get().then(roomDoc => {
      if (!roomDoc.exists) {
        alert('존재하지 않는 상담방입니다.');
        this.$router.push('/all/rooms');
      }
    });
    roomRef.onSnapshot(snapShot => {
      this.roomPublic = snapShot.data().publicState;
    });
    //Get Host Name
    roomRef.collection('attendees').onSnapshot(snapShot => {
      let userCheckedIn = false;
      let tempPendeing = [];
      let tempApproved = [];
      snapShot.forEach(attendeeDoc => {
        //Host Display Name
        if (this.hostId === attendeeDoc.id) {
          this.hostNickName = '담이';
        }
        //Cheking If User Checked In
        if (this.user && this.user.uid == attendeeDoc.id) {
          userCheckedIn = true;
        }
        //Push all users that are approved to the approved arr.
        if (attendeeDoc.data().approved) {
          if (this.user.uid == attendeeDoc.id) {
            this.attendeeApproved = true;
          }
          tempApproved.push({
            id: attendeeDoc.id,
            approved: attendeeDoc.data().approved,
          });
        } else {
          //Push all users that are NOT approved to the pending arr.
          if (this.user.uid == attendeeDoc.id) {
            this.attendeeApproved = false;
          }
          tempPendeing.push({
            id: attendeeDoc.id,
            approved: attendeeDoc.data().approved,
          });
        }
      });
      // if (!userCheckedIn) {
      //   alert('체크인 하지 않은 유저는 입장하실 수 없습니다.');
      //   this.$router.push(`/all/rooms`);
      // }
      this.attendeesPendingArr = tempPendeing;
      this.attendeesApprovedArr = tempApproved;
    });
  },
  created() {
    let token = this.$store.getters.getAuthToken;
    if (token == '' || token == null) {
      alert('로그인이 필요합니다.');
      this.$router.push({ name: 'Login' });
    }
  },
};
</script>

<style scoped src="@/assets/css/Approve.css"></style>
