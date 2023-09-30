package com.mwaqee.spring.auth.repository;

import com.mwaqee.spring.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String username);
}
