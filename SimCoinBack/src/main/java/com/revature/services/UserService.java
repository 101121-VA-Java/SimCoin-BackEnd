package com.revature.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.DAO.UserDao;
import com.revature.model.User;

@Service
public class UserService {
	
	private UserDao ud;
	
	@Autowired
	public UserService(UserDao ud) {
		this.ud = ud;
	}

	public List<User> getAllUsers() {
		return ud.findAll();
	}
	
	public List<User> getUserByRole(String role){
		return ud.findUsersByRole(role);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		ud.save(user);
		
	}

	
}
