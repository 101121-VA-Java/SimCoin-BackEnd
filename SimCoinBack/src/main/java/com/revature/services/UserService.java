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
	
	@Autowired
	public UserService(UserDao ud, UserCurrencyDao ucd, CurrencyDao cd) {
		this.ud = ud;
		this.ucd = ucd;
		this.cd = cd;
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
		System.out.println(holdings);
		
			
		
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
			System.out.println("User to be returned to front end from UserService: " + u);
			return u;
		}
		
}

