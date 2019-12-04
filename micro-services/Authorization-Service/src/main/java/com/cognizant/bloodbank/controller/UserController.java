package com.cognizant.bloodbank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.bloodbank.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.service.UserDetailsService;

@RestController
@RequestMapping("/usersignup")
public class UserController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("")
	public ResponseEntity<?> signup(@RequestBody @Valid User user) throws UserAlreadyExistsException{
		System.out.println("IN UC");
		if(userDetailsService.signup(user)){
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);	
		}
		else{
			return new ResponseEntity<String>(user.getEmail()+" Already Exists", HttpStatus.BAD_REQUEST);
		}
	}
}
