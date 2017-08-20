package com.eshop.dao.pojo;

import java.io.Serializable;

public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountId;
	private String accountName;
	private double accountMoney;
	private User user;
	public Account(String accountName, double accountMoney) {
		super();
		this.accountName = accountName;
		this.accountMoney = accountMoney;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getAccountMoney() {
		return accountMoney;
	}
	public void setAccountMoney(double accountMoney) {
		this.accountMoney = accountMoney;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountMoney=" + accountMoney
				+ ", user=" + user + "]";
	}
	
	
	
	
}
