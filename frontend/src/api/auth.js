import { instance } from "@/api";

const signupUser = (userData) => instance.post("/signup", userData);
const loginUser = (userData) => instance.post("/login", userData);
const emailCheck = (userData) => instance.post("/email-check", userData);

const findPassword = (userData) =>
  instance
    .post("/find-password", userData)
    .then((res) => {
      alert("이메일을 확인해주세요.");
      this.$router.push({ name: "Login" });
    })
    .catch((error) => {
      alert(error.response.data.message);
    });

const emailVerify = (userData) =>
  instance
    .post("/email-verify", userData)
    .then((res) => {
      alert("이메일을 확인해 주세요");
    })
    .catch((err) => {
      alert(err.response.data.message);
    });
const verifyCheck = (userData) =>
  instance
    .post("/verify-check", userData)
    .then((res) => {
      return res.data.verify;
    })
    .catch((error) => {
      alert(error.response.data.message);
    });
export { signupUser, loginUser, emailCheck, findPassword, emailVerify, verifyCheck };
