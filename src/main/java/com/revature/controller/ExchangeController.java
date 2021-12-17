package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.Principal;
import com.revature.services.ExchangeService;


@RestController
@RequestMapping("/exchange")
@CrossOrigin("*")
public class ExchangeController {
	private ExchangeService es;
 
	@Autowired public ExchangeController(ExchangeService es) { 
	this.es = es; 
	} 
	
	@PutMapping
	public ResponseEntity login(@RequestParam(name="userId")int userId, @RequestParam(name="amount") String amount,
			@RequestParam(name="from") String from, @RequestParam(name="to") String to){
		
		System.out.println(userId + amount + from + to);
		boolean validRequest = false;
		
		try {
		validRequest = es.exchange(Integer.valueOf(userId), Double.valueOf(amount), from, to);
		}
		catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		if (validRequest) {
			return new ResponseEntity(HttpStatus.OK);
		};
		return new ResponseEntity(HttpStatus.UNAUTHORIZED);
	}
}
