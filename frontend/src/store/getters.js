export default {
  getFeeling(state) {
    return Number(state.targetDateDetail['feeling']) - 1;
  },
  getStickerIndex(state) {
    let a = state.targetDateDetail['imageUrl'];
    return Number(a.split('.')[0]) - 1;
  },
  getRefreshCalendar(state) {
    return state.refreshCalendar;
  },
  getUpdateFeeling(state) {
    return state.emotionIndex;
  },
  getUpdateEmotion(state) {
    return state.selectedSticker;
  },
  getAuthToken(state) {
    return state.token;
  },
  getUpdateProfileImg(state) {
    return state.profileImg;
  },
  getUpdateProfileImgFinal(state) {
    return state.profileImgToShow;
  },
};
