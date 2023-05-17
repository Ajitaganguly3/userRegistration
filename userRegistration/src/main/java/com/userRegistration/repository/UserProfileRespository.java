package com.userRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userRegistration.model.User;

public interface UserProfileRespository extends MongoRepository<User, Integer>{
	

}
