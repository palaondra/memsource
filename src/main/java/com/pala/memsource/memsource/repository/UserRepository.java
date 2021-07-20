package com.pala.memsource.memsource.repository;

import com.pala.memsource.memsource.repository.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for managing <code>User</code> entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByUsername(String username);

}
