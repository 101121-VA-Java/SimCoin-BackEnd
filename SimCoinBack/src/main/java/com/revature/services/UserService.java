package com.revature.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.revature.DAO.UserRepository;
import com.revature.model.User;

@Service
public class UserService {
	
	private static UserRepository ur;
	
	@Autowired
	public UserService(UserRepository ur) {
		this.ur = ur;
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}
	
	public List<User> getUserByRole(String role){
		return ur.findUsersByRole(role);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		ur.save(user);
		
	}
	
}
