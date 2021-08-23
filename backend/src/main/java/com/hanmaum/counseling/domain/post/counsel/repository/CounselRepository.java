package com.hanmaum.counseling.domain.post.counsel.repository;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<Counsel, Long>, CounselRepositoryCustom{
}
