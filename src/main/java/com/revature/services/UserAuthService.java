package com.revature.services;
import com.revature.dtos.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.UserDao;
import com.revature.exceptions.LoginException;
import com.revature.model.User;

@Service
public class UserAuthService {
	
	private UserDao ud;
	
	@Autowired
	public UserAuthService(UserDao ud) {
		this.ud = ud;
	}
	
	public Principal login(String username, String password) {
		User u = ud.findByUsername(username);
		if(u == null || !password.equals(u.getPassword())) {
			throw new LoginException();
		}
		return new Principal(u);
	}
	
	public String generateToken(Principal principal) {
		String token = principal.getId() + ":" + principal.getRole() + ":"+ principal.getName();
		
		return token;
	}
	
	

}
