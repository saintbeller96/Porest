package com.hanmaum.counseling.domain.post.repository.post;

import com.hanmaum.counseling.domain.post.entity.Counsel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<Counsel, Long>, CounselRepositoryCustom{
}
