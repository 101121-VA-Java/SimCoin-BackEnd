package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Currency;
import com.revature.services.PriceListService;

@RestController
@RequestMapping("/price")
@CrossOrigin("*")
public class PriceListController {
	
	private PriceListService p;
	
	@Autowired
	public PriceListController(PriceListService p) {
		this.p = p;
	}
	
	@RequestMapping(method=RequestMethod.GET) 
	public ArrayList<Currency> getPriceList(){		
		return  p.getPriceList();
	}

}
