package com.assign3.Assignment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assign3.Assignment3.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

//	List<User> findByUserId(long id);
}
