package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Story;

import java.util.List;
import java.util.Optional;

public interface StoryRepositoryCustom {
    List<SimpleStoryDto> getCandidates(Long userId);
    List<Story> findByWriterId(Long writerId);
    Optional<Story> findByIdFetch(Long storyId);
}
