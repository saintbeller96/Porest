package com.hanmaum.counseling.domain.model.post.counsel;

import com.hanmaum.counseling.domain.model.post.counsel.Counsel;

import java.util.List;
import java.util.Optional;

public interface CounselRepositoryCustom {
    Optional<Counsel> findByCounselId(Long counselId);
    List<Counsel> findByCounsellorId(Long counsellorId);
    List<Counsel> findByUserId(Long userId);
}
