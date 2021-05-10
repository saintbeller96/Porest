<template>
  <div class="rooms-wrapper">
    <div class="rooms-section-wrapper">
      <div class="rooms-section-inner-wrapper">
        <div class="rooms-section-left">
          <div class="rooms-section-left-header"></div>
          <div class="rooms-section-left-content">
            <h1>화상상담방 개설하기</h1>
            <form>
              <label for="roomNmae">상담방 이름</label>
              <input
                type="text"
                class="form-control"
                name="roomName"
                placeholder="Room name"
                aria-describedby="buttonAdd"
                v-model="roomName"
                ref="roomName"
              />
              <label for="roomCapacity">상담방 허용인원</label>
              <input type="number" min="1" max="2" :value="capacity" />명
              <label for="roomPublic">상담방 얼굴 공개 여부</label>
              <div class="roomPublic-wrapper">
                <div class="face-show">공개</div>
                <div class="face-noshow">비공개</div>
              </div>
              <button type="submit" class="btn btn-sm btn-info" id="buttonAdd" @click.prevent="checkRoomName">
                개설하기
              </button>
            </form>
          </div>
        </div>
        <div class="rooms-section-right">
          <div v-for="(room, index) in rooms" :key="index">
            <div class="room-card-wrapper">
              <div @click="moveToCheckIn(room.id, room.name)">{{ room }} 방</div>
              <span v-if="uid === room.hostID" @click="deleteRoom(room.id, index)">Delete</span>
            </div>
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
      addState: false,
      roomNameCheck: false,
      capacity: 1,
    };
  },
  props: ['user'],
  mounted() {
    if (this.rooms.length == 0) {
      console.log('시작한다');
      this.loadData();
    }
  },
  methods: {
    async checkRoomName() {
      await this.rooms.forEach(ele => {
        if (ele.name == this.roomName) {
          this.roomNameCheck = true;
        }
      });
      if (!this.roomNameCheck) {
        this.addRoom();
      } else {
        this.roomName = '';
      }
    },
    addRoom() {
      this.addState = true;
      console.log('추가할거야', this.roomName, this.rooms);
      const docRef = db.collection('users').doc(this.user.uid);

      docRef.set({ name: this.user.uid });

      docRef
        .collection('rooms')
        .add({
          name: this.roomName,
          createdAt: FireBase.firestore.FieldValue.serverTimestamp(),
        })
        .then(() => {
          this.roomName = '';
        });
    },
    deleteRoom(roomId, index) {
      console.log('지운다잉', this.rooms);
      db.collection('users')
        .doc(this.user.uid)
        .collection('rooms')
        .doc(roomId)
        .delete();
      this.rooms.splice(index, 1);
    },
    moveToCheckIn(roomId, roomNameParams) {
      console.log('move to check in page', roomId);
      console.log('this room name');
      if (!this.uid) {
        this.uid = 'none';
      }
      this.$router.push({
        path: `/checkin/${this.uid}/${roomId}`,
        params: { roomId: roomId, roomNameParams: roomNameParams },
      });
    },
    async loadData() {
      const dbRef = db.collection('users');
      await dbRef.get().then(async querySnapshot => {
        await querySnapshot.forEach(async doc => {
          await dbRef
            .doc(doc.id)
            .collection('rooms')
            .onSnapshot(async snapShot => {
              await snapShot.forEach(ele => {
                let dataForm = {
                  id: ele.id,
                  hostID: doc.id,
                  name: ele.data().name,
                };
                if (this.rooms.length != 0) {
                  let state = false;
                  for (let i = 0; i < this.rooms.length; i++) {
                    if (this.rooms[i]['id'] === ele.id) {
                      state = true;
                    }
                  }
                  if (!state && this.addState) {
                    this.rooms.unshift(dataForm);
                  } else if (!state && !this.addState) {
                    this.rooms.push(dataForm);
                  }
                } else {
                  this.rooms.push(dataForm);
                }
              });
            });
        });
      });
    },
  },
};
</script>
<style scoped src="@/assets/css/rooms.css"></style>
