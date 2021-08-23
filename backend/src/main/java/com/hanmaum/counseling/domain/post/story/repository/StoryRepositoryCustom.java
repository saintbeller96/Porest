package com.hanmaum.counseling.domain.post.story.repository;

import com.hanmaum.counseling.presentation.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.story.Story;

import java.util.List;
import java.util.Optional;

public interface StoryRepositoryCustom {
    List<SimpleStoryDto> getCandidates(Long userId);
    List<Story> findByWriterId(Long writerId);
    Optional<Story> findByIdFetch(Long storyId);
}
