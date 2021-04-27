package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {
    List<Story> findByUserId(Long userId);
}
