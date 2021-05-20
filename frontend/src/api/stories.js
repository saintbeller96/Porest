import { instanceAuth } from '@/api';

const getMyStories = () =>
  instanceAuth.get('/stories').then(res => {
    return res.data;
  });

const writeStory = storyData => instanceAuth.post('/stories', storyData);

const getStoryOfAllLetters = storyId =>
  instanceAuth.get(`/stories/${storyId}/counsels`).then(res => {
    return res.data;
  });

const selectStory = storyId =>
  instanceAuth.post(`/stories/${storyId}`).then(res => {
    return res.data;
  });

const getCandidatesOfStories = () =>
  instanceAuth.get('/stories/candidates').then(res => {
    return res.data;
  });

export {
  getMyStories,
  writeStory,
  getStoryOfAllLetters,
  selectStory,
  getCandidatesOfStories,
};
