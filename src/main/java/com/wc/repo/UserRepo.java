package com.wc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wc.domain.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
