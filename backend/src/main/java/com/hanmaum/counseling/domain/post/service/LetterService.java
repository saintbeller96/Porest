package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;

public interface LetterService {

    Long writeLetter(FormDto form, Long postId, Long userId);

}
