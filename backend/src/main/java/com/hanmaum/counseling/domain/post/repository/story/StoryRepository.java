package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long>, StoryRepositoryCustom {
}
