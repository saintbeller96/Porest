package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterRepository extends JpaRepository<Letter, Long> {
}
