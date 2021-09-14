package com.hanmaum.counseling.domain.model.post.story;

import com.hanmaum.counseling.domain.model.post.story.Story;

import java.util.List;
import java.util.Optional;

public interface StoryRepositoryCustom {
    List<Story> getCandidates(Long userId);
    List<Story> findByWriterId(Long writerId);
    Optional<Story> findByIdFetch(Long storyId);
}
