package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int adminId;
	private String username;
	private String password;
	private double money;
	private Set<SellInfo> sellInfoSet = new HashSet<SellInfo>();
	private Set<Goods> goodsSet = new HashSet<Goods>();
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	public Set<SellInfo> getSellInfoSet() {
		return sellInfoSet;
	}
	public void setSellInfoSet(Set<SellInfo> sellInfoSet) {
		this.sellInfoSet = sellInfoSet;
	}
	
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}
	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	public Admin(String username, String password, double money) {
		super();
		this.username = username;
		this.password = password;
		this.money = money;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + ", money=" + money
				+ "]";
	}
	
}
