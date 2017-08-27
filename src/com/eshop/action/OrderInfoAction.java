package com.eshop.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.dao.pojo.User;
import com.eshop.service.iservice.IOrderInfoService;

@Controller
@Scope("prototype")
@RequestMapping("orderInfo")
public class OrderInfoAction {
	
	@Autowired
	@Qualifier("orderInfoService")
	private IOrderInfoService orderInfoService;	

	@RequestMapping(value="findByUserId/{userId}",method=RequestMethod.GET)
	public String findByUserId(@PathVariable("userId") Integer userId,@ModelAttribute Goods goods,Map<String,Object> map){
		List<OrderInfo> orderInfoList = orderInfoService.findByUserId(userId);
		if(orderInfoList != null && orderInfoList.size()>0){
			map.put("orderInfoListFromServer", orderInfoList);
		}
		System.out.println("orderInfoList ========= "+orderInfoList);
		for(OrderInfo orderInfo : orderInfoList){
			System.out.println(orderInfo.getOrderItemSet().size());
			System.out.println(orderInfo.getOrderItemSet());
		}
		return "orderInfo";
	}
	
	
	
	
	public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {} 
	        return session; 
	}
	public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
	} 
	
}
