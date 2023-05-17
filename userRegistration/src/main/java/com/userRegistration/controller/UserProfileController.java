package com.userRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.service.UserProfileService;

@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileService userProfileService;
	@PostMapping("/register")
	public String createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
		
		String response = userProfileService.CreateUserProfile(userProfileDTO);
		
		return response;
	}
	
	@GetMapping("/login") //TODO Need to change parameters
	public String login(@RequestBody UserProfileDTO userProfileDTO) {
		return "login";
	}

}
