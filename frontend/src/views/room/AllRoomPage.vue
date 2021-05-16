<template>
  <div class="rooms-wrapepr">
    <div class="background-image"></div>
    <Star></Star>
    <div class="list-pop-up">
      <div class="list-pop-up-inner-wrapper">
        <div class="room-card">
          <div class="room-card-front">
            front
            <div class="category-name"></div>
            <div class="create-chat-room">상담소 열기</div>
          </div>
          <div class="room-card-back">
            <h1>상담소 열기</h1>
            <form @submit.prevent>
              <input type="text" placeholder="상담소 이름을 적어주세요" v-model="roomName" />
              <div class="capacity-wrapper">
                <h2>참가 허용 인원</h2>
                <div class="capacity-count">
                  <div class="count-btn count-plus">더하기</div>
                  <div class="count-num">1</div>
                  <div class="count-btn count-minus">빼기</div>
                </div>
                <p class="capacity-warning-over">최대 인원은 4명 이하 입니다.</p>
                <p class="capacity-warning-less">최초 인원은 1명 이상 입니다.</p>
              </div>
              <h2>얼굴 공개 여부</h2>
              <div class="public-wrapper">
                <div class="public public-btn" @click="publicState == true">공개</div>
                <div class="non-public public-btn public-active" @click="publicState == false">비공개</div>
              </div>
              <h2>상담 분야 소개</h2>
              <div class="room-category-select">
                <div class="room-category" data-value="1">학교 생활</div>
                <div class="room-category" data-value="2">직장 생활</div>
                <div class="room-category" data-value="4">자녀 양육</div>
                <div class="room-category" data-value="5">대인 관계</div>
                <div class="room-category" data-value="7">연애</div>
                <div class="room-category" data-value="8">취업</div>
                <div class="room-category" data-value="3">학업 및 진로</div>
                <div class="room-category" data-value="6">심리 및 정서</div>
              </div>
              <div class="room-create-btn">
                <div class="create-room-btn public-btn" @click.prevent="checkRoomName">개설하기</div>
                <div class="exit-room-create public-btn">취소</div>
              </div>
            </form>
          </div>
        </div>
        <div class="room-list">
          <div class="room-list-wrapper">
            <div class="room-item" v-for="(room, index) in rooms" :key="index">
              <div class="room-item-left">
                <h1 class="room-name">{{ room.name }}</h1>
                <p>얼굴 공개 여부 : {{ room.publicState }}</p>
                <p>참가자 허용 인원 : {{ room.capacity }} 명</p>
                <div class="room-category-flag-wrapper">
                  <span class="room-category-flag" v-for="(tag, index) in room.category" :key="index">{{
                    categories[tag]
                  }}</span>
                </div>
                <div class="room-btn">
                  <span v-if="uid === room.hostID" @click="deleteRoom(room.id, index)">삭제하기</span>
                </div>
              </div>
              <div class="room-item-right">
                <div class="enter-room-btn" @click="moveToCheckIn(room.hostID, room.id, room.name)">
                  <span>입장</span><span>하기</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="room-list-eixt-btn">떠나기</div>
      </div>
    </div>
    <div class="card-main-wrapper">
      <div class="card-main-board"></div>
      <div class="card-inner-wrapper">
        <div class="card">
          <div class="card-flip">
            <div class="card-inner">
              <h2>학교 생활</h2>
            </div>
            <div class="card-outer" data-value="1">
              <span class="symbol-1"></span>
              <h2>학교 생활</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="2">
              <span class="symbol-1"></span>
              <h2>직장생활</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="3">
              <span class="symbol-1"></span>
              <h2>학업 및 진로</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="4">
              <span class="symbol-1"></span>
              <h2>자녀양육</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="5">
              <span class="symbol-1"></span>
              <h2>대인관계</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="6">
              <span class="symbol-1"></span>
              <h2>심리 및 정서</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="7">
              <span class="symbol-1"></span>
              <h2>연애</h2>
            </div>
          </div>
        </div>
        <div class="card">
          <div class="card-flip">
            <div class="card-inner"></div>
            <div class="card-outer" data-value="8">
              <span class="symbol-1"></span>
              <h2>취업</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="prev-button button">prev</div>
    <div class="next-button button">next</div>
    <approve
      class="aprrove-pop-up"
      v-if="approveState"
      @exitRoom="exitCheckin"
      :user="user"
      :roomId="roomId"
      :hostId="hostId"
      :roomName="roomName"
    ></approve>
    <check-in-page
      v-if="checkinState"
      class="check-in-pop-up"
      :user="user"
      :roomId="roomId"
      :hostId="hostId"
      :roomName="roomName"
      @showApprove="showApprove"
    ></check-in-page>
    <div class="checkin-exit" @click="exitCheckin">떠나기</div>
  </div>
</template>

<script>
import Star from '@/components/common/Star.vue';
import CheckInPage from '@/views/room/CheckInPage.vue';
import Approve from '@/views/room/Approve.vue';
import { init } from '@/assets/js/AllRoomPage.js';
import db from '@/db.js';
import FireBase from 'firebase/app';
import 'firebase/auth';

export default {
  name: 'Allroompage',
  data() {
    return {
      roomName: null,
      uid: this.$store.state.uid,
      rooms: [],
      addState: false,
      roomNameCheck: false,
      capacity: null,
      publicState: false,
      roomDesc: null,
      selectedCategory: [],
      roomId: null,
      hostId: null,
      checkinState: false,
      approveState: false,
      categories: ['학교 생활', '직장 생활', '학업 및 진로', '자녀 양육', '대인 관계', '심리 및 정서', '연애', '기타'],
    };
  },
  components: {
    CheckInPage,
    Approve,
    Star,
  },
  props: ['user'],
  async mounted() {
    init();
    if (this.rooms.length == 0) {
      console.log('시작한다');
      await this.loadData();
    }
  },
  methods: {
    showApprove() {
      console.log('approve');
      this.approveState = true;
    },
    exitCheckin() {
      this.checkinState = false;
      this.approveState = false;
      const checkinExit = document.querySelector('.checkin-exit');
      checkinExit.classList.remove('checkin-exit-show');
      console.log(this.checkinState);
    },
    async checkRoomName() {
      if (this.roomName == null || this.roomName == '') {
        alert('방 이름은 필수 입력 사항입니다.');
        return;
      }
      await this.rooms.forEach(ele => {
        if (ele.name == this.roomName) {
          this.roomNameCheck = true;
        }
      });
      if (!this.roomNameCheck) {
        this.getCategory();
        // this.addRoom();
      } else {
        this.roomName = '';
      }
    },
    async getCategory() {
      const roomCategory = document.querySelectorAll('.room-category');
      await roomCategory.forEach(ele => {
        if (ele.classList.contains('room-category-selected')) {
          this.selectedCategory.push(ele.dataset.value - 1);
          console.log('돈다');
        }
      });
      this.addRoom();
    },
    addRoom() {
      const now = new Date();
      const year = now.getFullYear();
      const month = now.getMonth() + 1;
      const day = now.getDate();
      const hour = now.getHours();
      const minute = now.getMinutes();
      const seconds = now.getSeconds();
      const num = document.querySelector('.count-num');
      console.log(num.innerText);
      this.addState = true;
      console.log('추가할거야', this.roomName, this.rooms);
      const docRef = db.collection('users').doc(this.user.uid);

      docRef.set({ name: this.user.uid });

      docRef
        .collection('rooms')
        .add({
          name: this.roomName,
          hostId: this.user.uid,
          capacity: num.innerText,
          publicState: this.publicState,
          category: this.selectedCategory,
          createdDate: `${year}-${month}-${day}, ${hour}:${minute}:${seconds}`,
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
    moveToCheckIn(hostId, roomId, roomName) {
      this.checkinState = true;
      console.log('move to check in page', roomId);
      console.log('this room name');
      if (!this.uid) {
        this.uid = 'none';
      }
      this.hostId = hostId;
      this.roomId = roomId;
      this.roomName = roomName;
      const checkinExit = document.querySelector('.checkin-exit');
      checkinExit.classList.add('checkin-exit-show');
      // console.log(checkinPopUp);
      // checkinPopUp.classList.add('check-in-pop-up-show');
      // this.$router.push({
      //   path: `/checkin/${this.uid}/${roomId}`,
      //   params: { roomId: roomId, roomNameParams: roomNameParams },
      // });
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
                  createdAt: ele.data().createdDate,
                  publicState: ele.data().publicState,
                  category: ele.data().category,
                  capacity: ele.data().capacity,
                };
                if (this.rooms.length != 0) {
                  let state = false;
                  for (let i = 0; i < this.rooms.length; i++) {
                    if (this.rooms[i]['id'] === ele.id) {
                      state = true;
                    }
                  }
                  if (!state) {
                    console.log('더할거에요');
                    this.rooms.unshift(dataForm);
                  }
                } else {
                  this.rooms.push(dataForm);
                }
                console.log('for');
              });
              this.rooms.sort((a, b) => {
                a.createdAt > b.createdAt;
              });
              // this.rooms.re();
              // this.rooms.sort()

              console.log(this.rooms, 'sorting');
            });
        });
      });
    },
  },
};
</script>

<style scoped src="@/assets/css/AllRoomPage.css"></style>
