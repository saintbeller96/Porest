package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;
import java.util.Optional;

public interface StoryRepositoryCustom {
    List<SimpleStoryDto> getCandidates(Long userId);
    Optional<SimpleStoryDto> pickOne(Long storyId);
}
