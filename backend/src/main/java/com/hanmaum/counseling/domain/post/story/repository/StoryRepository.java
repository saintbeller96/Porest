package com.hanmaum.counseling.domain.post.story.repository;

import com.hanmaum.counseling.domain.post.story.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long>, StoryRepositoryCustom {
}
