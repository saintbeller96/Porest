package com.hanmaum.counseling.domain.post.letter.service;

import com.hanmaum.counseling.domain.post.letter.Letter;
import com.hanmaum.counseling.presentation.post.dto.FormDto;

public interface LetterService {
    Letter readLetter(Long letterId, Long userId);
    Letter writeLetter(String title, String content, Long counselId, Long parentLetterId, Long userId);

}
