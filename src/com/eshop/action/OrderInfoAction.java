package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.GoodsClass;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.service.iservice.IGoodsClassService;
import com.eshop.service.iservice.IOrderInfoService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("orderInfoAction")
@Scope("prototype")
public class OrderInfoAction implements ModelDriven<OrderInfo>, RequestAware{
	
	@Autowired
	@Qualifier("orderInfoService")
	private IOrderInfoService orderInfoService;	
	private OrderInfo orderInfo = new OrderInfo();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public OrderInfo getModel() {
		// TODO Auto-generated method stub
		return orderInfo;
	}
	
	
	
	
}
