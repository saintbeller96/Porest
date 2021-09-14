package com.hanmaum.counseling.domain.model.post.counsel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CounselRepository extends JpaRepository<Counsel, Long>, CounselRepositoryCustom{
}
