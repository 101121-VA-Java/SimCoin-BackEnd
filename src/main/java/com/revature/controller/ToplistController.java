package com.revature.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.model.User;
import com.revature.services.TopListService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/top")
@CrossOrigin("*")
public class ToplistController {
	
	private TopListService tls;
	
	@Autowired
	ToplistController(TopListService tls){
		this.tls = tls;
	}
	
	@GetMapping
	public ResponseEntity<ArrayList<User>> getTop() {
		
		ArrayList<User> topList = tls.getTop();
		
		return new ResponseEntity<ArrayList<User>>(topList, HttpStatus.CREATED);
	}

}
