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
  // 스티커 번호
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

  // --- //
  getTargetDate(state, targetDate) {
    state.targetDate = targetDate;
  },
  getModalStatus(state, modalControl) {
    state.modalControl = modalControl;
  },
  getCalendarRefreshStatus(state, refreshCalendar) {
    state.refreshCalendar = refreshCalendar;
  },
};
