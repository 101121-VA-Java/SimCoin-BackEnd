package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Currency;
import com.revature.model.User;

@Service
public class PriceService {
	
	
	@Autowired
	public ArrayList<Currency> getPriceList() {		
		ArrayList<Currency> priceList = new ArrayList<Currency>();
		return priceList;		
	}
	
	public ArrayList<User> getLeaderBoard(){
		return null;
		
	}

}
