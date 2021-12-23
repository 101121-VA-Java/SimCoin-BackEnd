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
//	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false, name="user_role")
	private String role;
	
	@Transient
	private double netGain;
	@Transient
	private double total;
	@Transient
	private double btc;
	@Transient
	private double eth;
	@Transient
	private double ltc;
	@Transient
	private double xmr;
	@Transient
	private double trx;
	@Transient
	private double cash;
	
	@ManyToMany
	@JoinTable(
			name="users_currencies",
			joinColumns=@JoinColumn(name="userid"),
			inverseJoinColumns=@JoinColumn(name="currencyid"))
			Set<Currency> ownedCurrency;

	
	public double getCash() {
		return cash;
	}
	public void setCash(double cash) {
		this.cash = cash;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public double getNetGain() {
		return netGain;
	}
	public void setNetGain(double netGain) {
		this.netGain = netGain;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getBtc() {
		return btc;
	}
	public void setBtc(double btc) {
		this.btc = btc;
	}
	public double getEth() {
		return eth;
	}
	public void setEth(double eth) {
		this.eth = eth;
	}
	public double getLtc() {
		return ltc;
	}
	public void setLtc(double ltc) {
		this.ltc = ltc;
	}
	public double getXmr() {
		return xmr;
	}
	public void setXmr(double xmr) {
		this.xmr = xmr;
	}
	public double getTrx() {
		return trx;
	}
	public void setTrx(double trx) {
		this.trx = trx;
	}
	public Set<Currency> getOwnedCurrency() {
		return ownedCurrency;
	}
	public void setOwnedCurrency(Set<Currency> ownedCurrency) {
		this.ownedCurrency = ownedCurrency;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(btc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		temp = Double.doubleToLongBits(eth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ltc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netGain);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ownedCurrency == null) ? 0 : ownedCurrency.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(trx);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		temp = Double.doubleToLongBits(xmr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		User other = (User) obj;
		if (Double.doubleToLongBits(btc) != Double.doubleToLongBits(other.btc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (Double.doubleToLongBits(eth) != Double.doubleToLongBits(other.eth))
			return false;
		if (Double.doubleToLongBits(ltc) != Double.doubleToLongBits(other.ltc))
			return false;
		if (Double.doubleToLongBits(netGain) != Double.doubleToLongBits(other.netGain))
			return false;
		if (ownedCurrency == null) {
			if (other.ownedCurrency != null)
				return false;
		} else if (!ownedCurrency.equals(other.ownedCurrency))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		if (Double.doubleToLongBits(trx) != Double.doubleToLongBits(other.trx))
			return false;
		if (userid != other.userid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (Double.doubleToLongBits(xmr) != Double.doubleToLongBits(other.xmr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", netGain=" + netGain + ", total=" + total + ", btc=" + btc + ", eth=" + eth
				+ ", ltc=" + ltc + ", xmr=" + xmr + ", trx=" + trx + ", ownedCurrency=" + ownedCurrency + "]";
	}

	
	
	
	
}
