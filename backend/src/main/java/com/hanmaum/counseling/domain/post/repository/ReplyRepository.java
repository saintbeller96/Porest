package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
