import { instanceAuth } from '@/api';

const getEmotionsOfRecord = (month, year) => instanceAuth.get(`/emotions?month=${month}&year=${year}`);
const createEmotion = userData => instanceAuth.post('/emotions', userData);
const getEmotionDetail = emotionId => instanceAuth.get(`/emotions/${emotionId}`);
const updateEmotion = (emotionId, userData) => instanceAuth.put(`/emotions/${emotionId}`, userData);
const deleteEmotionDetail = emotionId => instanceAuth.delete(`/emotions/${emotionId}`);

export { getEmotionsOfRecord, createEmotion, getEmotionDetail, updateEmotion, deleteEmotionDetail };
