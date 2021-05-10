<template>
  <div>
    <div>chat room</div>
    <section>
      <div class="container-fluid mt-4">
        <div class="mb-3">
          <span class="mb-0 h2 text-primary">{{ roomName }}</span>
          <span class="ml-1" v-if="user && user.uid !== hostID">
            Hosted by: <strong class="text-danger">{{ hostNickName }}</strong>
          </span>
        </div>
        <div class="row" v-if="(user && user.uid == hostID) || attendeeApproved">
          <div class="col-md-8"></div>
          <div class="col-md-4">
            <form>
              <input type="hidden" name="roomId" value="something" />
              <input type="hidden" name="userId" value="something" />
              <input type="hidden" name="roomName" value="something" />
              <button v-if="!attendeeJoined && attendeeApproved" class="btn btn-primary mr-1" @click="doJoin">
                Join
              </button>
              <button v-if="attendeeJoined" type="button" class="btn btn-danger mr-1" @click="doLeave">
                Leave
              </button>
            </form>
            <h4 class="mt-2">Attendees</h4>
            <ul class="list-unstyled">
              <li v-for="attendee in attendeesApprovedArr" :key="attendee.id">
                <a
                  type="button"
                  class="mr-2"
                  title="Approve attendee"
                  @click="toggleApproval(attendee.id)"
                  v-if="user && user.uid == hostID"
                >
                  approve
                </a>
                <span class="mr-2" :class="[attendee.webRTCID ? 'text-success' : 'text-secondary']" title="On Air">
                </span>
                <span></span>
                <span class="pl-1" :class="[attendee.id == user.uid ? 'font-weight-bold text-danger' : '']">{{
                  attendee.nickName
                }}</span>
              </li>
            </ul>
            <div v-if="user && user.uid == hostID">
              <h5 class="mt-4">Pending</h5>
              <ul class="list-unstyled">
                <li class="mb-1" v-for="attendee in attendeesPendingArr" :key="attendee.id">
                  <span>
                    <a type="button" class="mr-2" title="Approve attendee" @click="toggleApproval(attendee.id)"
                      >approve
                    </a>
                    <a
                      type="button"
                      class="text-secondary pr-1"
                      title="Delete Attendee"
                      @click="deleteAttendee(attendee.id)"
                    >
                      delete
                    </a>
                  </span>
                  <span class="pl-1">{{ attendee.nickName }}</span>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div v-else>
          <p class="lead">
            Hi
            <strong class="text-primary font-weight-bold">{{ user.nickName }}</strong
            >, you're currently in the room waiting for the owner of the chat to add you to the meeting. Please wait.
          </p>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios';
// import Firebase from 'firebase';
import db from '@/db';
export default {
  data: function() {
    return {
      hostID: this.$route.params.hostID,
      roomID: this.$route.params.roomID,
      roomName: null,
      hostNickName: null,
      attendeesPendingArr: [],
      attendeesApprovedArr: [],
      attendeeApproved: false,
      attendeeJoined: false,
    };
  },
  components: {},
  methods: {
    toggleApproval: function(attendeeID) {
      if (this.user && this.user.uid == this.hostID) {
        const ref = db
          .collection('users')
          .doc(this.user.uid)
          .collection('rooms')
          .doc(this.roomID)
          .collection('attendees')
          .doc(attendeeID);

        ref.get().then(attendeeDoc => {
          const approved = attendeeDoc.data().approved;
          console.log('approved', approved);
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
      if (this.user && this.user.uid == this.hostID) {
        db.collection('users')
          .doc(this.user.uid)
          .collection('rooms')
          .doc(this.roomID)
          .collection('attendees')
          .doc(attendeeID)
          .delete();
      }
    },
    doJoin() {
      const form = document.querySelector('form');
      form.action = 'http://localhost:3000/ar';
      form.method = 'POST';
      form.target = 'pop';
      form.roomId.value = this.roomID;
      form.userId.value = this.user.uid;
      form.roomName.value = this.roomName;
      // this.$refs.webrtc.join();
      // this.attendeeJoined = true;
      // this.$router.push('http://localhost:3000/ar', { data: { Uid: this.user.uid, who: 'host' } });
      // window.location = 'http://localhost:3000/ar';
      window.open('', 'pop');
      form.submit();
      // this.$router.push({
      //   path: '/github',
      //   beforeEnter() {
      //     window.location.href = 'http://localhost:3000/ar';
      //   },
      // });
    },
    doLeave() {
      this.$refs.webrtc.leave();
      this.attendeeJoined = false;
    },
  },
  props: ['user'],
  mounted() {
    const roomRef = db
      .collection('users')
      .doc(this.$route.params.hostID)
      .collection('rooms')
      .doc(this.$route.params.roomID);
    //Get Room Name
    roomRef.get().then(roomDoc => {
      if (roomDoc.exists) this.roomName = roomDoc.data().name;
      else this.$router.push('/');
    });
    //Get Host Name
    roomRef.collection('attendees').onSnapshot(snapShot => {
      let userCheckedIn = false;
      let tempPendeing = [];
      let tempApproved = [];
      snapShot.forEach(attendeeDoc => {
        //Host Display Name
        if (this.hostID === attendeeDoc.id) {
          this.hostNickName = attendeeDoc.data().nickName;
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
            nickName: attendeeDoc.data().nickName,
            approved: attendeeDoc.data().approved,
            webRTCID: attendeeDoc.data().webRTCID,
          });
        } else {
          //Push all users that are NOT approved to the pending arr.
          if (this.user.uid == attendeeDoc.id) {
            this.attendeeApproved = false;
          }
          tempPendeing.push({
            id: attendeeDoc.id,
            nickName: attendeeDoc.data().nickName,
            approved: attendeeDoc.data().approved,
            webRTCID: attendeeDoc.data().webRTCID,
          });
        }
      });
      if (!userCheckedIn) {
        this.$router.push(`/checkin/${this.hostID}/${this.roomID}`);
      }
      this.attendeesPendingArr = tempPendeing;
      this.attendeesApprovedArr = tempApproved;
    });
  },
};
</script>
