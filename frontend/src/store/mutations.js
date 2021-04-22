export default {
    setUserId(state, id) {
      state.id = id;
    },
    setUsername(state, username) {
      state.username = username;
    },
    setUserEmail(state, email) {
      state.email = email;
    },
    setToken(state, token) {
      state.token = `Token ${token}`;
    },
    setImg(state, img) {
      state.profileImg = img;
    },
  };
  