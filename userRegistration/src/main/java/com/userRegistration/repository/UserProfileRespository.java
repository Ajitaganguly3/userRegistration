package com.userRegistration.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userRegistration.model.User;

import org.springframework.stereotype.Repository;

import com.userRegistration.model.User;

@Repository
public interface UserProfileRespository extends MongoRepository<User, Integer>{

	Optional<User> findByLoginId(String loginId);
	

}
