package com.mwaqee.spring.auth.repository;

import com.mwaqee.spring.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
