package com.hanmaum.counseling.domain.model.user;

import com.hanmaum.counseling.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndNickname(String email, String nickname);
    boolean existsByEmail(String email);
}
