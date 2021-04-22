package com.hanmaum.counseling.account.repository;

import com.hanmaum.counseling.account.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
