package com.revature.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="currencies")
public class Currency {
	
	@Id
//	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int currencyid;
	
	@Transient 
	private double price;
	 
	@Column(nullable=false)
	private String name;	
	
	
	@ManyToMany(mappedBy="ownedCurrency")
	Set<User> owned;
	
	

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrencyid() {
		return currencyid;
	}
	public void setCurrencyid(Integer id) {
		this.currencyid = id;
	}
	@Override
	public String toString() {
		return "Currency [currencyid=" + currencyid + ", price=" + price + ", name=" + name + "]";
	}
	
	
}
