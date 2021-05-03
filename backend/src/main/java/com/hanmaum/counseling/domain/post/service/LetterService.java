package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;

public interface LetterService {
    Long readLetter(Long letterId, Long userId);
    Long writeLetter(FormDto form, Long counselId, Long parentLetterId, Long userId);

}
