package com.springboot.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
//	Optional<User> findByEmail(String email);
//	Optional<User> findyUsername(String username);
//	Optional<User> findByUsernameOrEmail(String username, String email);
//	Boolean existByUsername(String username);
//	Boolean existByEmail(String email);
}
