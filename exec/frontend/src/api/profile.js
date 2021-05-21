import { instanceAuth } from '@/api';

const updateProfileImg = imageId => instanceAuth.put(`/profileImg/${imageId}`);
const updateNickname = userData => instanceAuth.put(`/update-nickname`, userData);
const updatePassword = userData => instanceAuth.put(`/update-password`, userData);

export { updateProfileImg, updateNickname, updatePassword };
