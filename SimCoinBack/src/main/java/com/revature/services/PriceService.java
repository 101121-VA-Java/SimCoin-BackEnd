package com.revature.services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.CurrencyDao;
import com.revature.model.Currency;
import com.revature.model.User;



@Service
public class PriceService {
	
	
	private static CurrencyDao cd;

	@Autowired
	private PriceService(CurrencyDao cd) {
		this.cd = cd;
	}
	
	
	public static ArrayList<Currency> getPriceList(){

        ArrayList<Currency> priceList = new ArrayList<Currency>();

        String [] currNames = {"btc", "eth", "ltc", "xmr", "trx"};
        String [] cryptNames = {"btc", "eth", "ltc", "xmr", "trx"};
        Integer [] currIds = {1, 2, 3, 4, 5};

        

        for (int i = 0; i < 5; i++) { 
        	Currency c = new Currency();
        	
            c.setName(currNames[i]);
            c.setCurrencyid(currIds[i]);
            c.setPrice(CurrencyDao.getUSD(cryptNames[i]));
            
//            System.out.println("value of i in the getPriceList for loop: " + i);
//            System.out.println("current currency object in the getPriceList for loop: " + c);
            priceList.add(c);
//            System.out.println("price list from PriceService: " + priceList); 
        	}
       return priceList;
	}
}

