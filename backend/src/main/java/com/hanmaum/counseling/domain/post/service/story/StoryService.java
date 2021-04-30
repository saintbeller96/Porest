package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.DetailStoryDto;
import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimplePostDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface StoryService {
    Long putStory(SimpleStoryDto storyDto, Long userId);
    List<SimpleStoryDto> getCandidates(Long userId);
    SimplePostDto pickStory(Long storyId, Long userId);
    List<DetailStoryDto> getStory(Long storyId, Long userId);
}
