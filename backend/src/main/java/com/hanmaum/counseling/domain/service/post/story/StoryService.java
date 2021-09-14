package com.hanmaum.counseling.domain.service.post.story;

import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.story.Story;

import java.util.List;

public interface StoryService {
    Story putStory(String title, String content, Long userId);
    List<Story> getCandidates(Long userId);
    Counsel pickStory(Long storyId, Long userId);
    List<Story> getStoriesOfUser(Long userId);
    Story getStoryOfUser(Long storyId, Long userId);
    Long deleteStory(Long storyId, Long userId);
}
