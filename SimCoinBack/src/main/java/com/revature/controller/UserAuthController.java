package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.services.UserAuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(exposedHeaders="Authorization")
public class UserAuthController {
	
	private UserAuthService as;
	
	@Autowired
	public UserAuthController(UserAuthService as) {
		this.as = as;
	}
	
	@PostMapping
	public ResponseEntity<Principal> login(@RequestParam(name="username")String username, @RequestParam(name="password") String password){
		Principal principal = as.login(username, password);
		String token = as.generateToken(principal);
		HttpHeaders hh = new HttpHeaders();
		hh.set("Authorization", token);
		return new ResponseEntity<>(principal, hh, HttpStatus.OK);
	}
	
	
	
//	@Autowired
//	public UserAuthController(UserService us) {
//		this.us = us;
//	}
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public List<User> getUsers(@RequestParam(name="user_role", required = false)String role){
//		if(role!=null) {
//			return us.getUserByRole(role);
//		}
//		return us.getAllUsers();
//		
//	}
//
//	This was a test we did to check endpoints, leaving to move to a User Controller!
//	

}
