package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/account")
@CrossOrigin("*")
public class UserAuthController {
	
	private UserService us;
	
	@Autowired
	public UserAuthController(UserService us) {
		this.us = us;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getUsers(){
		return us.getAll();
		
	}
	
	
	

}
