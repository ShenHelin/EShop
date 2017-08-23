package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class OrderInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private String orderNo;
	private String submitTime;
	private String orderName;
	private String orderAddress;
	private String orderCode;
	private String orderPhone;
	private OrderStatus orderStatus;
	private double totalPrice;
	private User user;
	
	private Set<OrderItem> orderItemSet = new HashSet<OrderItem>();
	//private Set<OrderStatus> orderStatusSet = new HashSet<OrderStatus>();
	
	
	public OrderInfo(String orderNo, String submitTime, String orderName, String orderAddress, String orderCode,
			String orderPhone,  double totalPrice) {
		super();
		this.orderNo = orderNo;
		this.submitTime = submitTime;
		this.orderName = orderName;
		this.orderAddress = orderAddress;
		this.orderCode = orderCode;
		this.orderPhone = orderPhone;
		this.totalPrice = totalPrice;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}
	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}
	public OrderInfo() {
		super();
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderNo=" + orderNo + ", submitTime=" + submitTime + ", orderName="
				+ orderName + ", orderAddress=" + orderAddress + ", orderCode=" + orderCode + ", orderPhone="
				+ orderPhone + ", orderStatus=" +  ", totalPrice=" + totalPrice + ", user=" + "]";
	}
	
	
	

}
