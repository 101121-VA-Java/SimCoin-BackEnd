package com.revature.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DAO.CurrencyDao;
import com.revature.DAO.UserCurrencyDao;
import com.revature.DAO.UserDao;
import com.revature.model.Currency;
import com.revature.model.User;
import com.revature.model.UserCurrency;

@Service
public class ExchangeService {

	private static CurrencyDao cd;
	private UserDao ud;
	private UserCurrencyDao uc;
	
	public ExchangeService(CurrencyDao cd, UserDao ud, UserCurrencyDao uc) {
		this.cd = cd;
		this.ud = ud;
		this.uc = uc;
	}	
	
	//@Transactional(propagation=Propagation.REQUIRED)
	public boolean exchange (int userId, double amount, String from , String to) {
		
//		User u = ud.findById(userId);  // user to modify.
//					
		double subtractCoin = amount;	// amount to subtract  
		
		double addCoin = exchangeValue(amount,from, to);  // amount to add
		
		ArrayList<UserCurrency> listUc = uc.findAllByUserid(userId);
		
		
		// ----- removing balance -----
		// looping to find the amount to subtract
		for (UserCurrency lc : listUc)	{
			Currency currency = cd.findById(lc.getCurrencyid());
			//find where Currency == from
			if (currency.getName().equals(from)) {
				 double currentAmount = lc.getAmount();
				 lc.setAmount(currentAmount - amount);		
				 uc.save(lc);
				
			}
		}
		// ----- end removing balance -----
		
		// ---  adding balance -----
		boolean coinExists = false;
		for (UserCurrency lc : listUc)	{
			Currency currency = cd.findById(lc.getCurrencyid());
			//find where Currency == from
			if (currency.getName().equals(to)) {
				coinExists = true;
				 // Add amount here	
				double currentAmount = lc.getAmount();
				double newAmount = currentAmount + addCoin;
				lc.setAmount(newAmount);
				uc.save(lc);
			}
		}
		
		if (coinExists == false) {
			// create new coin with balance if coin doesnt exist
			
			int currencyId = cd.findByName(to).getCurrencyid();			
			UserCurrency nc = new UserCurrency();
			nc.setCurrencyid(currencyId);
			nc.setUserid(userId);
			nc.setAmount(addCoin);			
			uc.save(nc);	
		}
		
		// ---  end adding balance -----
		

		return true;
		
		
		
	}

	public static double exchangeValue(double amount, String from , String to ) {
		
		// converting from Crypto to USD
		if ( to.equals("usd")) {
			return CurrencyDao.getUSD(from) * amount ;
		}
		
		else {
		// converting from Crypto to Crypto ( or USD to Crypto)
		String url = "https://api.cryptapi.io/" + to  + "/convert/?value=" + amount  +"&from=" + from ;
		RestTemplate rt = new RestTemplate();		
		String responseEntity = rt.getForObject(url,String.class);		
		
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			JsonNode actualObj = mapper.readTree(responseEntity);			
			String exchangeRate = actualObj.get("value_coin").asText();
			return Double.valueOf(exchangeRate);
					
		} catch (JsonProcessingException e) {
			return -1;
		}
		}
	}
}
