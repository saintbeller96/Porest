import { loginUser } from "@/api/auth";
import jwt_decode from "jwt-decode";
import {
  saveAuthToCookie,
  saveUserIdToCookie,
  saveUserNameToCookie,
  saveUserEmailToCookie,
  saveUserImgFromCookie,
  saveUserTemperatureFromCookie,
  saveUserUidToCookie,
} from "@/utils/cookies";

export default {
  async LOGIN({ commit }, userData) {
    const res = await loginUser(userData);
    let decoded = jwt_decode(res.data.token);
    commit("setUserId", decoded.id);
    commit("setUsername", decoded.nickname);
    commit("setUserEmail", decoded.email);
    commit("setToken", "Bearer " + res.data.token);
    commit("setImg", decoded.profile_img_number);
    commit("setTemperature", decoded.temperature);

    // 쿠키에 저장
    saveUserIdToCookie(decoded.id);
    saveUserNameToCookie(decoded.nickname);
    saveUserEmailToCookie(decoded.email);
    saveAuthToCookie("Bearer " + res.data.token);
    saveUserImgFromCookie(decoded.profile_img_number);
    saveUserTemperatureFromCookie(decoded.temperature);
    return res.data;

    // firebase
  },

  async LOGOUT({ commit }) {
    commit("setUserId", "");
    commit("setUsername", "");
    commit("setUserEmail", "");
    commit("setToken", "");
    commit("setImg", "");
    commit("setTemperature", "");
    commit("setUserUid", "");
    saveUserIdToCookie("");
    saveUserNameToCookie("");
    saveUserEmailToCookie("");
    saveAuthToCookie("");
    saveUserImgFromCookie("");
    saveUserTemperatureFromCookie("");
    saveUserUidToCookie("null");
  },

  saveuUserUid({ commit }, payload) {
    commit("setUserUid", payload.firebaseData.uid);
    saveUserUidToCookie(payload.firebaseData.uid);
  },

  //mail관련
  saveSelectedCounselId({ commit }, counselId) {
    commit("setCounselId", counselId);
  },

  saveSelectedStory({ commit }, selectedStory) {
    commit("setSelectedStory", selectedStory);
  },
  saveAllLetters({ commit }, allLetters) {
    commit("setAllLetters", allLetters);
  },

  saveSnackbarStatus({ commit }, snackbarStatus) {
    commit("setSnackbarStatus", snackbarStatus);
  },
};
