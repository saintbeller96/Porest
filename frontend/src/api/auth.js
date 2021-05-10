import { instance } from "@/api";

const signupUser = (userData) => instance.post("/signup", userData);
const loginUser = (userData) => instance.post("/login", userData);
const nicknameCheck = (userData) => instance.post("/nickname-check", userData);
const emailCheck = (userData) => instance.post("/email-check", userData);

export { signupUser, loginUser, nicknameCheck, emailCheck };
