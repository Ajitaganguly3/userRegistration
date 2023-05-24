package com.userRegistration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userRegistration.model.User;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends MongoRepository<User, String>{
	
	Optional<User> findByLoginId(String loginId);

}
