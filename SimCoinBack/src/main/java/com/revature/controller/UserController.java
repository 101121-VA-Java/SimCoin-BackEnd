package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	private UserService us;

	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}

//	@CrossOrigin
//	@RequestMapping(method=RequestMethod.POST)
//	public ResponseEntity<String> addUser(@RequestBody User user){
//		System.out.println("Hello from user Controller");
//		us.addUser(user);
//		return new ResponseEntity<>(user.getUserid() +" " + user.getUsername() + " Welcome To SimCoin New Member.", HttpStatus.CREATED);
//		
	@PostMapping // @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		System.out.println("Hello from user Controller");
		System.out.println(user);
		us.addUser(user);
		return new ResponseEntity<>(user.getUserid() + " was created.", HttpStatus.CREATED);
	}
}
