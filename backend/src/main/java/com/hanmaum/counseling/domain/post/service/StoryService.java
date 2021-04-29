package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface StoryService {
    Long putStory(SimpleStoryDto storyDto, Long userId);
    List<SimpleStoryDto> showStories(Long userId);
    SimpleStoryDto pickStory(Long userId, Long storyId);
}
