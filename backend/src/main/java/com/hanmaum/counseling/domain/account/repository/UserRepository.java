package com.hanmaum.counseling.domain.account.repository;

import com.hanmaum.counseling.domain.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
