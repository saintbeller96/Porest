package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface PostService {
    List<SimpleStoryDto> getCandidates(Long userId);
    Long saveStory(FormDto form, Long userId);
}
