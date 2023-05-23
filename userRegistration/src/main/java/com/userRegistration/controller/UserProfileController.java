package com.userRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.service.UserProfileService;
import com.userRegistration.service.UserProfileServiceImpl;

@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserProfileServiceImpl userProfileServiceImpl;
	
	@PostMapping("/register")
	public String createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
		
		String response = userProfileService.CreateUserProfile(userProfileDTO);
		
		return response;
	}
	
	@GetMapping("/login")
	public UserProfileDTO login(@PathVariable String loginId) {
		
		return userProfileServiceImpl.getUserByLoginId(loginId);

	}

}
