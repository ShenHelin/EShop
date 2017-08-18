package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Goods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int goodsId;
	private String goodsName;
	private String description;
	private double price;
	private int amount;
	private int leaveNum;
	private String regTime;//商品上架时间
	private String image;
	private Admin admin;
	private GoodsClass goodsClass;
	
	private Set<SellItem> sellItemSet = new HashSet<SellItem>();
	private Set<ShoppingCart> shoppingCartSet = new HashSet<ShoppingCart>();
	private Set<OrderItem> orderItemSet = new HashSet<OrderItem>();
	
	
	public Goods(String goodsName, String description, double price, int amount, int leaveNum, String regTime,
			String image) {
		super();
		this.goodsName = goodsName;
		this.description = description;
		this.price = price;
		this.amount = amount;
		this.leaveNum = leaveNum;
		this.regTime = regTime;
		this.image = image;
	}
	public Goods() {
		super();
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getLeaveNum() {
		return leaveNum;
	}
	public void setLeaveNum(int leaveNum) {
		this.leaveNum = leaveNum;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public GoodsClass getGoodsClass() {
		return goodsClass;
	}
	public void setGoodsClass(GoodsClass goodsClass) {
		this.goodsClass = goodsClass;
	}
	
	
	
	public Set<ShoppingCart> getShoppingCartSet() {
		return shoppingCartSet;
	}
	public void setShoppingCartSet(Set<ShoppingCart> shoppingCartSet) {
		this.shoppingCartSet = shoppingCartSet;
	}
	public Set<SellItem> getSellItemSet() {
		return sellItemSet;
	}
	public void setSellItemSet(Set<SellItem> sellItemSet) {
		this.sellItemSet = sellItemSet;
	}
	
	
	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}
	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}
	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", description=" + description + ", price="
				+ price + ", amount=" + amount + ", leaveNum=" + leaveNum + ", regTime=" + regTime + ", image=" + image
				+ "]";
	}
	
	
	
	
}
