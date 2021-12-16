package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.CurrencyDao;
import com.revature.DAO.UserCurrencyDao;
import com.revature.DAO.UserDao;
import com.revature.model.User;

@Service
public class TopListService {
	
	private UserDao ud;
	@SuppressWarnings("unused")
	private UserCurrencyDao ucd;
	@SuppressWarnings("unused")
	private CurrencyDao cd;
	private UserService us;
	
	@Autowired
	public TopListService(UserDao ud, UserCurrencyDao ucd, CurrencyDao cd, UserService us) {
		this.ud = ud;
		this.ucd = ucd;
		this.cd = cd;
		this.us = us;
	}
	
	public ArrayList<User> getTop(){
		
		ArrayList<User> topList = new ArrayList<User>();
		ArrayList<User> users2 = new ArrayList<User>();
		ArrayList<User> users = ud.findAll();
		
		System.out.println("All users: " + users);
		for (int i = 0; i < users.size(); i++) {
			
			User u = users.get(i);
			int id = u.getUserid();
			users2.add(us.getUserById(id));
		}
		
		System.out.println("All users with data: " + users2);
		for (int i = 1; i < users2.size(); i++) {
			
			User user1 = users2.get(i-1);
			User user2 = users2.get(i);
			double user1net = user1.getNetGain();
			double user2net = user2.getNetGain();
			
			if(user2net > user1net) {
				users2.remove(i);
				users2.add(i-1, user2);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			topList.add(i, users2.get(i));
		}
		
		System.out.println(topList);
		return topList;
	}

}
