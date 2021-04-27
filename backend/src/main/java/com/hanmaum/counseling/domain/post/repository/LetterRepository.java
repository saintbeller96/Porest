package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterRepository extends JpaRepository<Long, Letter> {

    List<Letter> findByStoryId(Long storyId);

}
