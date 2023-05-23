package com.userRegistration.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userRegistration.model.User;

public interface UserProfileRespository extends MongoRepository<User, Integer>{

	Optional<User> findByLoginId(String loginId);
	

}
