package com.hanmaum.counseling.domain.post.repository.post;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;

import java.util.List;

public interface CounselRepositoryCustom {
    List<LetterReplyDto> getLetterReply(Long postId);
}
