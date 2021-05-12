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
  stickerDrawer: false,
};
