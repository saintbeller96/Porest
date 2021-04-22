package com.hanmaum.counseling.account.repository;

import com.hanmaum.counseling.account.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
