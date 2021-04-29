package com.hanmaum.counseling.domain.post.service;

import com.hanmaum.counseling.domain.post.dto.FormDto;

public interface ReplyService {
    Long writeReply(FormDto form, Long letterId, Long userId);
}
