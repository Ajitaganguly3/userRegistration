package com.userRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userRegistration.model.User;

public interface LoginRepository extends MongoRepository<User, Integer>{
	
	User findByLoginId(String loginId);

}
