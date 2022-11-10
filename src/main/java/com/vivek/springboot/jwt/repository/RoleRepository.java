package com.vivek.springboot.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.springboot.jwt.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRoleName(String roleName);
}