package com.hanmaum.counseling.domain.model.post.story;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long>, StoryRepositoryCustom {
}
