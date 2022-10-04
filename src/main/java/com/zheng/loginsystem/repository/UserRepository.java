package com.zheng.loginsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zheng.loginsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
