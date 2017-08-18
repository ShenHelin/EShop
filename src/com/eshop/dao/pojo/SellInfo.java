package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SellInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sellId;
	private String sellNo;
	private String submitTime;
	private double totalPrice;
	private Admin admin;
	private User user;
	private Set<SellItem> sellItemSet = new HashSet<SellItem>();
	
	
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public String getSellNo() {
		return sellNo;
	}
	public void setSellNo(String sellNo) {
		this.sellNo = sellNo;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Set<SellItem> getSellItemSet() {
		return sellItemSet;
	}
	public void setSellItemSet(Set<SellItem> sellItemSet) {
		this.sellItemSet = sellItemSet;
	}
	public SellInfo(String sellNo, String submitTime, double totalPrice) {
		super();
		this.sellNo = sellNo;
		this.submitTime = submitTime;
		this.totalPrice = totalPrice;
	}
	
	public SellInfo(String sellNo, String submitTime, double totalPrice, Admin admin, User user) {
		super();
		this.sellNo = sellNo;
		this.submitTime = submitTime;
		this.totalPrice = totalPrice;
		this.admin = admin;
		this.user = user;
	}
	public SellInfo() {
		super();
	}
	@Override
	public String toString() {
		return "SellInfo [sellId=" + sellId + ", sellNo=" + sellNo + ", submitTime=" + submitTime + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
