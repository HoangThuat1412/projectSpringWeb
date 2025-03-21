package com.projectvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectvn.models.User;


public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);
	
}
