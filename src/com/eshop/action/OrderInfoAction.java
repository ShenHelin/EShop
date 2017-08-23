package com.eshop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.OrderInfo;
import com.eshop.dao.pojo.User;
import com.eshop.service.iservice.IOrderInfoService;
import com.opensymphony.xwork2.ActionContext;
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


	public String findByUserId(){
		String msg = "error";
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<OrderInfo> orderInfoList = orderInfoService.findByUserId(user.getUserId());
		if(orderInfoList != null && orderInfoList.size()>0){
			request.put("orderInfoListFromServer", orderInfoList);
			msg = "success";
		}
		System.out.println("orderInfoList ========= "+orderInfoList);
		for(OrderInfo orderInfo : orderInfoList){
			System.out.println(orderInfo.getOrderItemSet().size());
			System.out.println(orderInfo.getOrderItemSet());
		}
		return msg;
	}
	
	
	
}
