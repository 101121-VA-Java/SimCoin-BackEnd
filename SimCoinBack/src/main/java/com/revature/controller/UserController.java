package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Currency;
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
	@PostMapping // @RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody User user) {
		System.out.println("Hello from user Controller");
		System.out.println(user);
		us.addUser(user);
		return new ResponseEntity<>(user.getUserid() + " was created.", HttpStatus.CREATED);
	}
	@RequestMapping(method=RequestMethod.GET) public User getCurrentUser(){
		
		int id = 1;
		User u = us.getUserById(id);
		
		return u;
	}
	
}
