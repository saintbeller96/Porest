import {
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserEmailFromCookie,
  getUserNameFromCookie,
  getUserImgFromCookie,
} from '@/utils/cookies';

export default {
  id: getUserIdFromCookie() || '',
  email: getUserEmailFromCookie() || '',
  username: getUserNameFromCookie() || '',
  token: getAuthFromCookie() ? `Token ${getAuthFromCookie()}` : '',
  profileImg: getUserImgFromCookie() || '',
};
