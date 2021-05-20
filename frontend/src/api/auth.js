import { instance } from "@/api";

const signupUser = (userData) =>
  instance
    .post("/signup", userData)
    .then((res) => {
      return { status: true, message: "이메일을 확인해주세요" };
    })
    .catch((error) => {
      return { status: false, message: "다시 시도해 주세요" };
    });

const loginUser = (userData) =>
  instance
    .post("/login", userData)
    .then((res) => {
      return { status: true, message: "", data: res.data };
    })
    .catch((error) => {
      return { status: false, message: "다시 시도해 주세요" };
    });

//이메일 중복 체크
const emailCheck = (userData) =>
  instance
    .post("/email-check", userData)
    .then((res) => {
      return { status: true, message: "", data: res.data };
    })
    .catch((error) => {
      return { status: false, message: "다시 시도해 주세요" };
    });

const findPassword = (userData) =>
  instance
    .post("/find-password", userData)
    .then((res) => {
      return { status: true, message: "이메일을 확인해주세요" };
    })
    .catch((error) => {
      return { status: false, message: err.response.data.message };
    });

//인증 코드 이메일 전송
const emailVerify = (userData) =>
  instance
    .post("/email-verify", userData)
    .then((res) => {
      return { status: true, message: "이메일을 확인해 주세요" };
    })
    .catch((err) => {
      return { status: false, message: err.response.data.message };
    });

const verifyCheck = (userData) =>
  instance
    .post("/verify-check", userData)
    .then((res) => {
      return { status: true, message: "", data: res.data };
    })
    .catch((error) => {
      return { status: false, message: error.response.data.message };
    });
export { signupUser, loginUser, emailCheck, findPassword, emailVerify, verifyCheck };
