package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;

import java.util.List;

public interface StoryRepositoryCustom {
    int CANDIDATES = 6;
    List<SimpleStoryDto> pickCandidates(Long userId);
}
