package com.vivek.springboot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.springboot.jwt.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
