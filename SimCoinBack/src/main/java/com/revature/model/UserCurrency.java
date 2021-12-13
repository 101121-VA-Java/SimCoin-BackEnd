package com.revature.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="users_currencies")
public class UserCurrency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	private int userid;
	
	@OneToOne
	@JoinColumn(name = "currencyid", referencedColumnName = "currencyid")
	private int currencyid;
	
	@Column(name="amount")
	private int amount;

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + currencyid;
		result = prime * result + id;
		result = prime * result + userid;
		return result;
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
