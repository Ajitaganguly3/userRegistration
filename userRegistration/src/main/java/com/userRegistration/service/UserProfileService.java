package com.userRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.repository.UserProfileRespository;

@Service
public class UserProfileService {
	
	@Autowired
	UserProfileRespository userProfileRepository;
	
	public String CreateUserProfile(UserProfileDTO userProfileDTO) {
		
		String message = "working fine";
		
		return message;
	}

}
