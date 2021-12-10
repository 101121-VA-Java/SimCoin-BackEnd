package com.revature.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.revature.model.Currency;
import com.revature.model.User;

@Service
public class PriceService {
	
	
	public PriceService() {
		
	}
	
	public ArrayList<Currency> getPriceList() {		
		ArrayList<Currency> priceList = new ArrayList<Currency>();
		return priceList;		
	}
	
	public ArrayList<User> getLeaderBoard(){
		return null;
		
	}

}
