import { loginUser } from '@/api/auth';
import jwt_decode from 'jwt-decode';
import {
  saveAuthToCookie,
  saveUserIdToCookie,
  saveUserNameToCookie,
  saveUserEmailToCookie,
  saveUserImgFromCookie,
  saveUserTemperatureFromCookie,
  saveUserUidToCookie,
} from '@/utils/cookies';

export default {
  async LOGIN({ commit }, userData) {
    const { data } = await loginUser(userData);
    let decoded = jwt_decode(data.token);
    commit('setUserId', decoded.id);
    commit('setUsername', decoded.nickname);
    commit('setUserEmail', decoded.email);
    commit('setToken', 'Bearer ' + data.token);
    commit('setImg', decoded.profile_img);
    commit('setTemperature', decoded.temperature);

    // 쿠키에 저장
    saveUserIdToCookie(decoded.id);
    saveUserNameToCookie(decoded.nickname);
    saveUserEmailToCookie(decoded.email);
    saveAuthToCookie('Bearer ' + data.token);
    saveUserImgFromCookie(decoded.profile_img);
    saveUserTemperatureFromCookie(decoded.temperature);
    return data;

    // firebase
  },

  async LOGOUT({ commit }) {
    commit('setUserId', '');
    commit('setUsername', '');
    commit('setUserEmail', '');
    commit('setToken', '');
    commit('setImg', '');
    commit('setTemperature', '');
    commit('setUserUid', '');
    saveUserIdToCookie('');
    saveUserNameToCookie('');
    saveUserEmailToCookie('');
    saveAuthToCookie('');
    saveUserImgFromCookie('');
    saveUserTemperatureFromCookie('');
    saveUserUidToCookie('');
  },

  saveuUserUid({ commit }, payload) {
    console.log('this is actions payload', payload.firebaseData.uid);
    commit('setUserUid', payload.firebaseData.uid);
    saveUserUidToCookie(payload.firebaseData.uid);
  },
};
