package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.pojo.Account;
import com.eshop.dao.pojo.OrderItem;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.service.iservice.IOrderStatusService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@RequestMapping("orderStatus")
public class OrderStatusAction {
	@Autowired
	@Qualifier("orderStatusService")
	private IOrderStatusService orderStatusService;	
	private OrderStatus orderStatus = new OrderStatus();

	//@ModelAttribute Goods goods,Map<String,Object> map
	
	
	
}
