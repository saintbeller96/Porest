function saveUserIdToCookie(value) {
  document.cookie = `login_id=${value}`;
}
function saveUserUidToCookie(value) {
  document.cookie = `login_uid=${value}`;
}
function saveUserNameToCookie(value) {
  document.cookie = `login_username=${value}`;
}
function saveUserEmailToCookie(value) {
  document.cookie = `login_email=${value}`;
}
function saveAuthToCookie(value) {
  document.cookie = `login_token=${value}`;
}
function saveUserImgFromCookie(value) {
  document.cookie = `login_img=${value}`;
}
function getUserIdFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/, '$1');
}
function getUserUidFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/, '$1');
}
function getUserNameFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_username\s*=\s*([^;]*).*$)|^.*$/, '$1');
}
function getUserEmailFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/, '$1');
}
function getUserImgFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/, '$1');
}

function getAuthFromCookie() {
  return document.cookie.replace(/(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/, '$1');
}
function deleteCookie(value) {
  document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}

export {
  saveAuthToCookie,
  saveUserIdToCookie,
  saveUserUidToCookie,
  saveUserNameToCookie,
  saveUserEmailToCookie,
  saveUserImgFromCookie,
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserUidFromCookie,
  getUserNameFromCookie,
  getUserEmailFromCookie,
  getUserImgFromCookie,
  deleteCookie,
};
