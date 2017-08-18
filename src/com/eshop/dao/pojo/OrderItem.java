package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class OrderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderItemId;
	private int amount;
	private double price;
	private OrderInfo orderInfo;
	private Goods goods;
	
	private Set<Comment> commentSet = new HashSet<Comment>();
	
	
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	
	
	public Set<Comment> getCommentSet() {
		return commentSet;
	}
	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}
	public OrderItem(int amount, double price) {
		super();
		this.amount = amount;
		this.price = price;
	}
	public OrderItem() {
		super();
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", amount=" + amount + ", price=" + price + ", orderInfo="
				+ orderInfo.getOrderId() + ", goods=" + goods.getGoodsName() + "]";
	}
	
	

}
