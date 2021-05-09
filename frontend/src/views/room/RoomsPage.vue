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
              <button type="submit" class="btn btn-sm btn-info" id="buttonAdd" @click.prevent="checkRoomName">
                +
              </button>
            </form>
          </div>
          <div class="rooms-section-left-content"></div>
        </div>
        <div class="rooms-section-right">
          <div v-for="(room, index) in rooms" :key="index">
            <div @click="moveToCheckIn(room.id)">{{ room }} 방</div>
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
      displays: [],
      addState: false,
      roomNameCheck: false,
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
    moveToCheckIn(roomId) {
      this.$router.push(`/checkin/${this.uid}/${roomId}`);
    },
    async loadData() {
      const dbRef = db.collection('users');
      await dbRef.get().then(async querySnapshot => {
        console.log('1정보를 모조리 가지고 올거야');
        await querySnapshot.forEach(async doc => {
          console.log('2정보를 모조리 가지고 올거야');
          await dbRef
            .doc(doc.id)
            .collection('rooms')
            .onSnapshot(async snapShot => {
              console.log('3정보를 모조리 가지고 올거야', this.rooms);
              await snapShot.forEach(ele => {
                console.log('4정보를 모조리 가지고 올거야');
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
                    console.log('없었으니까 추가할게');
                    this.rooms.unshift(dataForm);
                  } else if (!state && !this.addState) {
                    this.rooms.push(dataForm);
                  }
                } else {
                  this.rooms.push(dataForm);
                }
              });
              console.log(this.rooms);
              this.displays = [...this.rooms];
            });
        });
      });
    },
  },
};
</script>
<style scoped src="@/assets/css/rooms.css"></style>
