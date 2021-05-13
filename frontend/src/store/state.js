import {
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserUidFromCookie,
  getUserEmailFromCookie,
  getUserNameFromCookie,
  getUserImgFromCookie,
  getUserTemperatureFromCookie,
} from '@/utils/cookies';

export default {
  id: getUserIdFromCookie() || '',
  uid: getUserUidFromCookie() || '',
  email: getUserEmailFromCookie() || '',
  nickname: getUserNameFromCookie() || '',
  token: getAuthFromCookie() ? `${getAuthFromCookie()}` : '',
  profileImg: getUserImgFromCookie() || '',
  temperature: getUserTemperatureFromCookie() || '',
  thisMonthFeelings: [],
  targetDateId: 0,
  targetDateDetail: '',
  stickerindex: 0,
  selectedSticker: '',
  emotionIndex: 0,
};
