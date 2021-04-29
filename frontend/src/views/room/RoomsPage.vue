<template>
  <div>
    <form>
      <label for="roomNmae">RoomName</label>
      <input
        type="text"
        class="form-control"
        name="roomName"
        placeholder="Room name"
        aria-describedby="buttonAdd"
        v-model="roomName"
        ref="roomName"
      />
      <button type="submit" class="btn btn-sm btn-info" id="buttonAdd" @click.prevent="addRoom">
        +
      </button>
    </form>
    <div v-for="(room, index) in rooms" :key="index">
      <div @click="moveToCheckIn(room.id)">{{ room.name }}</div>
      <span @click="deleteRoom(room.id)">Delete</span>
    </div>
  </div>
</template>

<script>
import db from '@/db.js';
import FireBase from 'firebase/app';
import 'firebase/auth';
export default {
  name: 'RoomsPage',
  data() {
    return {
      roomName: null,
      uid: this.$store.state.uid,
      rooms: [],
    };
  },
  props: ['user'],
  mounted() {
    console.log(this.rooms);
    if (this.rooms.length == 0) {
      console.log('시작한다');
      const dbRef = db.collection('users');
      dbRef.get().then(querySnapshot => {
        querySnapshot.forEach(doc => {
          dbRef
            .doc(doc.id)
            .collection('rooms')
            .onSnapshot(snapShot => {
              console.log('read', this.rooms);
              snapShot.forEach(ele => {
                this.rooms.push({
                  id: ele.id,
                  hostID: doc.id,
                  name: ele.data().name,
                });
              });
              console.log(this.rooms);
            });
        });
      });
    }
  },
  methods: {
    addRoom() {
      console.log(this.user.nickName);
      const docRef = db.collection('users').doc(this.user.uid);

      docRef.set({ name: this.user.uid });

      docRef.collection('rooms').add({
        name: this.roomName,
        createdAt: FireBase.firestore.FieldValue.serverTimestamp(),
      });
    },
    deleteRoom(roomId) {
      db.collection('users')
        .doc(this.user.uid)
        .collection('rooms')
        .doc(roomId)
        .delete();
    },
    moveToCheckIn(roomId) {
      this.$router.push(`/checkin/${this.uid}/${roomId}`);
    },
  },
};
</script>
