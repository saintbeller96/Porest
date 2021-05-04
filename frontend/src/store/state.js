import {
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserUidFromCookie,
  getUserEmailFromCookie,
  getUserNameFromCookie,
  getUserImgFromCookie,
} from '@/utils/cookies';

export default {
  id: getUserIdFromCookie() || '',
  uid: getUserUidFromCookie() || '',
  email: getUserEmailFromCookie() || '',
  username: getUserNameFromCookie() || '',
  token: getAuthFromCookie() ? `Token ${getAuthFromCookie()}` : '',
  profileImg: getUserImgFromCookie() || '',
};
