package com.revature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class User {
	
	@Id
	int userId;
	@ManyToMany
	@JoinTable(
			name="currency_owned",
			joinColumns=@JoinColumn(name="userId"),
			inverseJoinColumns=@JoinColumn(name="currencyId"))
	Set<Currency> ownedCurrency;
	
	private String username;
	private String password;
	private String email;
	private Currency currencies;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Currency getCurrencies() {
		return currencies;
	}
	public void setCurrencies(Currency currencies) {
		this.currencies = currencies;
	}
	
	
	
}
