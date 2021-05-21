let date = new Date(Date.now() + 86400e3);
let Oneday = date.toUTCString();
let options = `;path=/;secure; expires=${Oneday}`;
function saveUserIdToCookie(value) {
  document.cookie = `login_id=${value}${options}`;
}
function saveUserUidToCookie(value) {
  document.cookie = `login_uid=${value}${options}`;
}
function saveUserNameToCookie(value) {
  document.cookie = `login_name=${value}${options}`;
}
function saveUserEmailToCookie(value) {
  document.cookie = `login_email=${value}${options}`;
}
function saveAuthToCookie(value) {
  document.cookie = `login_token=${value}${options}`;
}
function saveUserImgFromCookie(value) {
  document.cookie = `login_img=${value}${options}`;
}
function saveUserTemperatureFromCookie(value) {
  document.cookie = `login_temperature=${value}${options}`;
}
function getUserIdFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_id\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserUidFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_uid\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserNameFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_name\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserEmailFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_email\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserImgFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_img\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}
function getUserTemperatureFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_temperature\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
}

function getAuthFromCookie() {
  return document.cookie.replace(
    /(?:(?:^|.*;\s*)login_token\s*=\s*([^;]*).*$)|^.*$/,
    '$1',
  );
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
  saveUserTemperatureFromCookie,
  getAuthFromCookie,
  getUserIdFromCookie,
  getUserUidFromCookie,
  getUserNameFromCookie,
  getUserEmailFromCookie,
  getUserImgFromCookie,
  getUserTemperatureFromCookie,
  deleteCookie,
};
