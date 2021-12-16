package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.DAO.CurrencyDao;
import com.revature.DAO.UserCurrencyDao;
import com.revature.DAO.UserDao;
import com.revature.model.Currency;
import com.revature.model.User;
import com.revature.model.UserCurrency;

@Service
public class UserService {
	
	private UserDao ud;
	private UserCurrencyDao ucd;
	private CurrencyDao cd;
	private UserService us;
	
	@Autowired
	public UserService(UserDao ud, UserCurrencyDao ucd, CurrencyDao cd, UserService us) {
		this.ud = ud;
		this.ucd = ucd;
		this.cd = cd;
		this.us = us;
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
	
	public User findUserById(int id) {
		return ud.findById(id);
	}
	
	public User getUserById(int id) {
		User u = ud.findById(id);
		//System.out.println(u);
		ArrayList<UserCurrency> holdings = ucd.findAllByUserid(id);
		//System.out.println(holdings);
		
			for (int i = 0; i < holdings.size(); i++) {
				
				UserCurrency thisHolding = holdings.get(i);
				int currId = thisHolding.getCurrencyid();
				
				//System.out.println("flag1");
				
				switch (currId) {
					case 1:{
						double currPrice = CurrencyDao.getUSD("btc");
						u.setBtc(thisHolding.getAmount() * currPrice);
						break;
					}
					case 2:{
						double currPrice = CurrencyDao.getUSD("eth");
						u.setEth(thisHolding.getAmount() * currPrice);
						break;
					}
					case 3:{
						double currPrice = CurrencyDao.getUSD("ltc");
						u.setLtc(thisHolding.getAmount() * currPrice);
						break;
					}
					case 4:{
						double currPrice = CurrencyDao.getUSD("xmr");
						u.setXmr(thisHolding.getAmount() * currPrice);
						break;
					}
					case 5:{
						double currPrice = CurrencyDao.getUSD("trx");
						u.setTrx(thisHolding.getAmount() * currPrice);
						break;
					}
					case 6:{
						u.setCash(thisHolding.getAmount());
						break;
					}
				}
			}
			u.setTotal(u.getCash() + u.getBtc() + u.getEth() + u.getLtc() + u.getXmr() + u.getXmr() + u.getTrx());
			u.setNetGain(u.getTotal() - 50000);
			//System.out.println("User to be returned to front end from UserService: " + u);
			return u;
		}
	
	public ArrayList<User> getTop(){
		
		ArrayList<User> topList = new ArrayList<User>();
		ArrayList<User> users2 = new ArrayList<User>();
		ArrayList<User> users = ud.findAll();
		
		for (int i = 0; i < users.size(); i++) {
			
			User u = users.get(i);
			int id = u.getUserid();
			users2.add(us.getUserById(id));
		}
		
		System.out.println(users2);
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

