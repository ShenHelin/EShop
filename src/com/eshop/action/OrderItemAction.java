package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.OrderItem;
import com.eshop.service.iservice.IOrderItemService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("orderItemAction")
@Scope("prototype")
public class OrderItemAction implements ModelDriven<OrderItem>, RequestAware{
	
	@Autowired
	@Qualifier("orderItemService")
	private IOrderItemService orderItemService;	
	private OrderItem orderItem = new OrderItem();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public OrderItem getModel() {
		// TODO Auto-generated method stub
		return orderItem;
	}
}

