package com.hanmaum.counseling.domain.account.repository;

import com.hanmaum.counseling.domain.account.entity.Role;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(RoleType name);
}
