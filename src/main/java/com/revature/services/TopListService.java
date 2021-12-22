package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.UserDao;
import com.revature.model.User;

@Service
public class TopListService {
	
	private UserDao ud;
	private UserService us;
	
	@Autowired
	public TopListService(UserDao ud, UserService us) {
		this.ud = ud;
		this.us = us;
	}
	
	public ArrayList<User> getTop(){
		
		ArrayList<User> topList = new ArrayList<User>();
		ArrayList<User> users2 = new ArrayList<User>();
		ArrayList<User> users = ud.findAll();
		
		//System.out.println("All users: " + users);
		for (int i = 0; i < users.size(); i++) {
			
			User u = users.get(i);
			int id = u.getUserid();
			users2.add(us.getUserById(id));
		}
		
		//System.out.println("All users with data: " + users2);
		for (int i = 0; i < users2.size(); i++) {
			for (int j = 1; j < (users2.size()-i); j++) {
			
				User user1 = users2.get(j-1);
				User user2 = users2.get(j);
				double user1net = user1.getNetGain();
				double user2net = user2.getNetGain();
			
				if(user2net > user1net) {
					users2.remove(j);
					users2.add(j-1, user2);
				}
			}
		}
		
		//System.out.println("Ordered users2: " + users2);
		for (int i = 0; i < 3; i++) {
			topList.add(i, users2.get(i));
		}
		
		//System.out.println("TopList:" + topList);
		return topList;
	}

}
