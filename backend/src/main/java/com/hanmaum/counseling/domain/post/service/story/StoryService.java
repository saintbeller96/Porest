package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.*;

import java.util.List;

public interface StoryService {
    Long putStory(FormDto formDto, Long userId);
    List<SimpleStoryDto> getCandidates(Long userId);
    SimpleCounselDto pickStory(Long storyId, Long userId);
    List<UserStoryStateDto> getUserStoryState(Long userId);
    List<UserCounselStateDto> getCounselStateOfUserWithStory(Long storyId, Long userId);
    Long deleteStory(Long storyId, Long userId);
}
