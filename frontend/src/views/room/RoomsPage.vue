<template>
  <div class="rooms-wrapper">
    <div class="rooms-section-wrapper">
      <div class="rooms-section-inner-wrapper">
        <div class="rooms-section-left">
          <div class="rooms-section-left-header">
            화상채팅방
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
          </div>
          <div class="rooms-section-left-content"></div>
        </div>
        <div class="rooms-section-right">
          <div v-for="(room, index) in rooms" :key="index">
            <div @click="moveToCheckIn(room.id)">{{ room.name }} 방</div>
            <span v-if="uid === room.hostID" @click="deleteRoom(room.id, index)">Delete</span>
          </div>
        </div>
      </div>
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
    deleteRoom(roomId, index) {
      db.collection('users')
        .doc(this.user.uid)
        .collection('rooms')
        .doc(roomId)
        .delete();
      this.rooms.splice(index, 1);
    },
    moveToCheckIn(roomId) {
      this.$router.push(`/checkin/${this.uid}/${roomId}`);
    },
  },
};
</script>
<style scoped src="@/assets/css/rooms.css"></style>
