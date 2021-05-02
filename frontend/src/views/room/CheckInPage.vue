<template>
  <div>
    <h1>CheckIn</h1>
    <form @submit.prevent="handleCheckIn">
      <div class="card-body" v-if="user">
        <h1 class="font-weight-light mb-0">Check in</h1>
        <p class="font-weight-bold" v-if="roomName">
          To: <span class="text-primary">{{ roomName }}</span>
        </p>
        <section class="form-group">
          <label class="form-control-label sr-only" for="displayName">Name</label>
          <input required class="form-control" type="text" v-model="nickName" />
        </section>
        <div class="form-group text-right mb-0">
          <button class="btn btn-primary" type="submit">Check in</button>
        </div>
      </div>
      <div class="card-body card-outline-danger text-center" v-else>
        <h1 class="text-danger card-title">Sorry</h1>
        <p class="card-text lead">
          Sorry, access to rooms is only available to registered users. Please
          <router-link to="/login">login</router-link> or <router-link to="/register">register</router-link> and try
          again.
        </p>
      </div>
    </form>
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
      roomName: null,
    };
  },
  props: ['user'],
  methods: {
    handleCheckIn() {
      const roomRef = db
        .collection('users')
        .doc(this.$route.params.hostID)
        .collection('rooms')
        .doc(this.$route.params.roomID);
      roomRef.get().then(doc => {
        if (doc.exists) {
          roomRef
            .collection('attendees')
            .doc(this.user.uid)
            .set({
              nickName: this.nickName,
              createdAt: Firebase.firestore.FieldValue.serverTimestamp(),
            })
            .then(() => this.$router.push(`/chat/${this.$route.params.hostID}/${this.$route.params.roomID}`));
        }
      });
    },
  },
  mounted() {
    //Getting User
    Firebase.auth().onAuthStateChanged(user => {
      if (user) {
        this.nickName = user.nickName;
      }
    });

    //Getting Room name
    db.collection('users')
      .doc(this.$route.params.hostID)
      .collection('rooms')
      .doc(this.$route.params.roomID)
      .get()
      .then(doc => {
        if (doc.exists) {
          this.roomName = doc.data().name;
        } else {
          this.$router.push('/');
        }
      });
  },
};
</script>

<style lang="scss" scoped></style>
