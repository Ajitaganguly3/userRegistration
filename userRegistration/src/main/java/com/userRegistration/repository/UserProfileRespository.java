package com.userRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userRegistration.model.User;

public interface UserProfileRespository extends JpaRepository<User, Integer>{
	

}
