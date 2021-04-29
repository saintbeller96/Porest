package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
