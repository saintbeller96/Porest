package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.dto.UserStoryInfoDto;

import java.util.List;
import java.util.Map;

public interface StoryService {
    Long putStory(SimpleStoryDto storyDto, Long userId);
    List<SimpleStoryDto> getCandidates(Long userId);
    SimpleCounselDto pickStory(Long storyId, Long userId);
    List<UserStoryInfoDto> getUserStoryInfo(Long userId);
    List<DetailCounselDto> getStory(Long storyId, Long userId);
}
