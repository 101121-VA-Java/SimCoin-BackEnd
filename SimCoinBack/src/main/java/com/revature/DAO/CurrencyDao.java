package com.revature.DAO;

import org.springframework.web.client.RestTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.*;

@Repository
public interface CurrencyDao extends JpaRepository<Currency, Integer> {
	
	public static double getUSD(String coin) {
		String url = "https://api.cryptapi.io/" + coin + "/info/";
		
		RestTemplate rt = new RestTemplate();		
		String responseEntity = rt.getForObject(url,String.class);		
		
    	ObjectMapper mapper = new ObjectMapper();
    	try {
			JsonNode actualObj = mapper.readTree(responseEntity);
			JsonNode priceJSON = actualObj.path("prices");
			String USD = priceJSON.get("USD").asText();
			return Double.valueOf(USD);
					
		} catch (JsonProcessingException e) {
			return -1;
		}
	}
	
	Currency findById(int id);

}
