import { instanceAuth } from "@/api";

//counselsid와 letterid가 필요하다.
const writeLetter = (letterData) =>
  instanceAuth
    .post(`/counsels/${letterData.ids.counselId}/letters/${letterData.ids.letterId}`, letterData.body)
    .then((res) => {
      console.log(res.data);
    });

const readLetter = (letterData) =>
  instanceAuth.get(`/counsels/${letterData.ids.counselId}/letters/${letterData.ids.letterId}/read`);

export { writeLetter, readLetter };
