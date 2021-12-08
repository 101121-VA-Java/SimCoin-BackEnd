package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.model.Currency;

@Service
public class PriceListService {
	
	public ArrayList<Currency> getPriceList() {
		
		ArrayList<Currency> priceList = new ArrayList<Currency>();
		Currency BTC = new Currency();
		BTC.setName("BTC");
		BTC.setPrice(50000);
		BTC.setId(0);
		
		Currency ETH = new Currency();
		ETH.setName("ETH");
		ETH.setPrice(30000);
		ETH.setId(1);
		
		Currency LTC = new Currency();
		LTC.setName("LTC");
		LTC.setPrice(10000);
		LTC.setId(2);
		
		Currency MONERO = new Currency();
		MONERO.setName("MONERO");
		MONERO.setPrice(5000);
		MONERO.setId(3);
		
		Currency DOGE = new Currency();
		DOGE.setName("DOGE");
		DOGE.setPrice(5);
		DOGE.setId(4);
		
		priceList.add(BTC);
		priceList.add(ETH);
		priceList.add(LTC);
		priceList.add(DOGE);
		priceList.add(MONERO);
		
		return priceList;
		
	}
		
}
