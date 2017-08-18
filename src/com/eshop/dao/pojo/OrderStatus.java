package com.eshop.dao.pojo;

import java.io.Serializable;

public class OrderStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private String isSend;
	private String isPay;
	private OrderInfo orderInfo;
	public OrderStatus(String isSend, String isPay) {
		super();
		this.isSend = isSend;
		this.isPay = isPay;
	}
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderStatus() {
		super();
	}

	public String getIsSend() {
		return isSend;
	}
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	@Override
	public String toString() {
		return "OrderStatus [isSend=" + isSend + ", isPay=" + isPay + ", orderInfo=" + orderInfo.getOrderId() + "]";
	}
	
	
	

	
	
	
}
