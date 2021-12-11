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
	private PriceService ps;


	@Autowired
	private PriceService(CurrencyDao cd) {
		this.cd = cd;
	}
	
	
	public static ArrayList<Currency> getPriceList(){

        ArrayList<Currency> priceList = new ArrayList<Currency>();

        String [] currNames = {"btc", "eth", "ltc", "mxr", "trx"};
        String [] cryptNames = {"btc", "eth", "ltc", "xmr", "trx"};
        Integer [] currIds = {1, 2, 3, 4, 5};

        Currency c = new Currency();

        for (int i = 0; i < 5; i++) { 
            c.setName(currNames[i]);
            c.setCurrencyid(currIds[i]);

            double price = CurrencyDao.getUSD(cryptNames[i]);

            c.setPrice(price);

            priceList.add(c);
        	}
       System.out.println("price list from PriceService: " + priceList); 
       return priceList;
	}
}

