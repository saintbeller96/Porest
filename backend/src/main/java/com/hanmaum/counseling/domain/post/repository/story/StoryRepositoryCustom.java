package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface StoryRepositoryCustom {
    List<SimpleStoryDto> getCandidates(Long userId);
    List<CounselContent> getStory(Long storyId, Long userId);
}
