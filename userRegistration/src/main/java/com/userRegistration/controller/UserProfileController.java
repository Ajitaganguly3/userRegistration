package com.userRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.service.UserProfileService;

@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	public String createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
		
		String response = userProfileService.CreateUserProfile(userProfileDTO);
		
		return response;
	}

}
