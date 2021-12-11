package com.revature.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
public class Currency {
	
	@Id
//	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int currencyId;
	@Column(nullable=false)
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
	
	
}
