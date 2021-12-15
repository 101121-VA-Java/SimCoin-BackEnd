package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Embeddable
@Table(name="users_currencies")
public class UserCurrency implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "userid")
	private int userid;
	
	@Column(name = "currencyid")
	private int currencyid;
	
	@Column(name = "amount")
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCurrencyid() {
		return currencyid;
	}

	public void setCurrencyid(int currencyid) {
		this.currencyid = currencyid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCurrency other = (UserCurrency) obj;
		if (amount != other.amount)
			return false;
		if (currencyid != other.currencyid)
			return false;
		if (id != other.id)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCurrency [id=" + id + ", userid=" + userid + ", currencyid=" + currencyid + ", amount=" + amount
				+ "]";
	}
}
