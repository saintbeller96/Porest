package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.*;

import java.util.List;
import java.util.Map;

public interface StoryService {
    Long putStory(FormDto formDto, Long userId);
    List<SimpleStoryDto> getCandidates(Long userId);
    SimpleCounselDto pickStory(Long storyId, Long userId);
    List<UserStoryInfoDto> getUserStoryInfo(Long userId);
    List<DetailCounselDto> getStory(Long storyId, Long userId);
}
