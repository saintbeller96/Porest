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

  // 감정 기록
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
  getTargetDate(state, targetDate) {
    state.targetDate = targetDate;
  },
  getModalStatus(state, modalControl) {
    state.modalControl = modalControl;
  },
  getCalendarRefreshStatus(state, refreshCalendar) {
    state.refreshCalendar = refreshCalendar;
  },
  getThisMonth(state, thisMonth) {
    state.thisMonth = thisMonth;
  },
  getThisMonthEmoji(state, thisMonthWithEmoji) {
    state.thisMonthWithEmoji = thisMonthWithEmoji;
  },

  //Mail 관련
  setCounselId(state, counselId) {
    state.counselId = counselId;
  },
  setSelectedStory(state, selectedStory) {
    state.selectedStory = selectedStory;
  },
  setAllLetters(state, allLetters) {
    state.allLetters = allLetters;
  },

  // 프로필
  setModalProfile(state, modalProfileSetting) {
    state.modalProfileSetting = modalProfileSetting;
  },
  setProfileImgToShow(state, profileImgToShow) {
    state.profileImgToShow = profileImgToShow;
  },

  // 메인
  setLogoStatus(state, logoStatus) {
    state.logoStatus = logoStatus;
  },

  //snackbar
  setSnackbarStatus(state, snackbarStatus) {
    state.snackbarStatus = snackbarStatus;
  },
};
