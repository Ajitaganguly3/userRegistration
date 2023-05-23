package com.userRegistration.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userRegistration.model.User;

@Repository
public interface LoginRepository extends MongoRepository<User, String>{
	
	Optional<User> findByLoginId(String loginId);

}
