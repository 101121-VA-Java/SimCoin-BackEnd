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
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String email;
	@Transient
	private double netGain;
	
	@ManyToMany
	@JoinTable(
			name="currency_owned",
			joinColumns=@JoinColumn(name="userId"),
			inverseJoinColumns=@JoinColumn(name="currencyId"))
			Set<Currency> ownedCurrency;

	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Set<Currency> getOwnedCurrency() {
		return ownedCurrency;
	}
	public void setOwnedCurrency(Set<Currency> ownedCurrency) {
		this.ownedCurrency = ownedCurrency;
	}
	public double getNetGain() {
		return netGain;
	}
	public void setNetGain(double netGain) {
		this.netGain = netGain;
	}
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

	
	
}
