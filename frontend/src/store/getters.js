export default {
  getFeeling(state) {
    return Number(state.targetDateDetail['feeling']) - 1;
  },
  getStickerIndex(state) {
    let a = state.targetDateDetail['imageUrl'];
    return Number(a.split('.')[0]) - 1;
  },
};
