export default {
  setUserId(state, id) {
    state.id = id;
  },
  setUserUid(state, uid) {
    state.uid = uid;
  },
  setUsername(state, nickname) {
    state.nickname = nickname;
  },
  setUserEmail(state, email) {
    state.email = email;
  },
  setToken(state, token) {
    state.token = token;
  },
  setImg(state, img) {
    state.profileImg = img;
  },
  setTemperature(state, temperature) {
    state.temperature = temperature;
  },
  getThisMonthFeelings(state, thisMonthFeelings) {
    state.thisMonthFeelings = thisMonthFeelings;
  },
  getTargetDateId(state, targetDateId) {
    state.targetDateId = targetDateId;
  },
  getTargetDateDetail(state, targetDateDetail) {
    state.targetDateDetail = targetDateDetail;
  },
  getStickerIndex(state, stickerindex) {
    state.stickerindex = stickerindex;
  },
  getSelectedSticker(state, selectedSticker) {
    state.selectedSticker = selectedSticker;
  },
  getEmotionIndex(state, emotionIndex) {
    state.emotionIndex = emotionIndex;
  },
  getDiaryModalStatus(state, diaryModalStatus) {
    state.diaryModalStatus = diaryModalStatus;
  },
  // getTodaysDiaryId(state, todaysDiaryId) {
  //   state.todaysDiaryId = todaysDiaryId;
  // },
};
