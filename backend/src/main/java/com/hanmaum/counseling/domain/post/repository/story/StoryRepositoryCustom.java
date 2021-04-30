package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;
import java.util.Optional;

public interface StoryRepositoryCustom {
    List<SimpleStoryDto> getCandidates(Long userId);
    List<PostContent> getStory(Long storyId, Long userId);
}
