package com.exe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exe.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
}
