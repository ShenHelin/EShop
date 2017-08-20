package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Account;
import com.eshop.dao.pojo.OrderItem;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.service.iservice.IOrderStatusService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("orderStatusAction")
@Scope("prototype")
public class OrderStatusAction implements ModelDriven<OrderStatus>, RequestAware{
	@Autowired
	@Qualifier("orderStatusService")
	private IOrderStatusService orderStatusService;	
	private OrderStatus orderStatus = new OrderStatus();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public OrderStatus getModel() {
		// TODO Auto-generated method stub
		return orderStatus;
	}
}
