package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimplePostDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface StoryService {
    Long putStory(SimpleStoryDto storyDto, Long userId);
    List<SimpleStoryDto> getCandidates(Long userId);
    SimplePostDto pickStory(Long userId, Long storyId);
    List<LetterReplyDto> getStories(Long storyId, Long userId);
}
