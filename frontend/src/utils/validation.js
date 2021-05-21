function validateEmail(email) {
  const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(String(email).toLowerCase());
}
function validatePwd(pwd) {
  // const re = /^[A-Za-z0-9+]{8,20}$/;
  //공백을 뺀 나머지 문자가 8~20자 사이
  const re = /^[\S+]{8,20}$/;
  return re.test(pwd);
}
export { validateEmail, validatePwd };
