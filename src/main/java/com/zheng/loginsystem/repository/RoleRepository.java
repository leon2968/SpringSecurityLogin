package com.zheng.loginsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zheng.loginsystem.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}