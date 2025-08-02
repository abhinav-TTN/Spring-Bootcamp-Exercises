package com.abhinav.base.repository;

import com.abhinav.base.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
