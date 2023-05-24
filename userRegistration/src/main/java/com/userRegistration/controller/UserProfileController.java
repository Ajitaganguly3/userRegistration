package com.userRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.userRegistration.dto.UserProfileDTO;
import com.userRegistration.service.UserProfileService;
import com.userRegistration.service.UserProfileServiceImpl;

@RestController
@RequestMapping("/moviebooking")

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
	public ResponseEntity<String> login(@RequestParam String loginId, @RequestParam String password) {
		
		String token =  userProfileServiceImpl.getUserByLoginId(loginId, password);
		
		if(token != null) {
			return ResponseEntity.ok(token);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login credentials");

	}

}
