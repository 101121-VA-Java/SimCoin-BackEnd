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
		User u = new User();
		
		u.setUserid(1);
		u.setUsername("test username");
		u.setEmail("testuser@testing.com");
		u.setPassword("testpass");
		/*
		 * u.setTotal(75000); u.setCash(25000); u.setNetGain(25000); u.setBtc(30000);
		 * u.setEth(1500); u.setLtc(10000); u.setXmr(0); u.setTrx(0);
		 */
		
		return u;
	}
	
}
