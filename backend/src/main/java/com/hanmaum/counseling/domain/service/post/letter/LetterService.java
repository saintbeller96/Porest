package com.hanmaum.counseling.domain.service.post.letter;

import com.hanmaum.counseling.domain.model.post.letter.Letter;

public interface LetterService {
    Letter readLetter(Long letterId, Long userId);
    Letter writeLetter(String title, String content, Long counselId, Long parentLetterId, Long userId);

}
