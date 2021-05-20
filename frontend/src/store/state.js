import {
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserUidFromCookie,
  getUserEmailFromCookie,
  getUserNameFromCookie,
  getUserImgFromCookie,
  getUserTemperatureFromCookie,
} from "@/utils/cookies";

export default {
  id: getUserIdFromCookie() || "",
  uid: getUserUidFromCookie() || "",
  email: getUserEmailFromCookie() || "",
  nickname: getUserNameFromCookie() || "",
  token: getAuthFromCookie() ? `${getAuthFromCookie()}` : "",
  profileImg: getUserImgFromCookie() || "",
  temperature: getUserTemperatureFromCookie() || "",

  // 감정 기록
  thisMonthFeelings: [],
  targetDateId: 0,
  targetDateDetail: "",
  stickerindex: 0,
  selectedSticker: "",
  emotionIndex: 0,
  diaryModalStatus: "",
  targetDate: [], // 캘린더에서 선택한 날짜
  modalControl: false,
  refreshCalendar: false,
  thisMonth: [],
  thisMonthWithEmoji: [],

  //MyreceivedMail에서 사용
  //Mail관련
  counselId: null,
  selectedStory: null,
  allLetters: null,

  // profile
  modalProfileSetting: false,
  profileImgToShow: 0,

  // main
  logoStatus: true,

  //snackbar
  snackbarStatus: false,
};
