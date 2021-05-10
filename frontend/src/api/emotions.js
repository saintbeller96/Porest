import { instanceAuth } from "@/api";

const getEmotionsOfRecord = () => instanceAuth.get("/emotions");
const createEmotion = () => instanceAuth.post("/emotions");
const getEmotionDetail = (emotionId) => instanceAuth.get(`/emotions/${emotionId}`);
const updateEmotion = (emotionId) => instanceAuth.put(`/emotions/${emotionId}`);
const deleteEmotionDetail = (emotionId) => instanceAuth.delete(`/emotions/${emotionId}`);

export { getEmotionsOfRecord, createEmotion, getEmotionDetail, updateEmotion, deleteEmotionDetail };
