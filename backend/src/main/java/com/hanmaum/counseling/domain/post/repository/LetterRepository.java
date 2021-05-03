package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LetterRepository extends JpaRepository<Letter, Long> {
    @Query("select l from Letter l join fetch l.parentLetter join fetch l.counsel where l.id = :letterId")
    Optional<Letter> findByIdFetch(@Param("letterId") Long letterId);
}
