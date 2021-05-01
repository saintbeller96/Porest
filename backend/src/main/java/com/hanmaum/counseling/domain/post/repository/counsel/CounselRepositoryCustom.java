package com.hanmaum.counseling.domain.post.repository.counsel;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;

import java.util.List;
import java.util.Optional;

public interface CounselRepositoryCustom {
    Optional<Counsel> findByCounselId(Long counselId);
}
