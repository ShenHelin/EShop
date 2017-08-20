package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.ShoppingCart;
import com.eshop.service.iservice.IShoppingCartService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("shoppingCartAction")
@Scope("prototype")
public class ShoppingCartAction implements ModelDriven<ShoppingCart>, RequestAware{
	@Autowired
	@Qualifier("shoppingCartService")
	private IShoppingCartService shoppingCartService;	
	private ShoppingCart shoppingCart = new ShoppingCart();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public ShoppingCart getModel() {
		// TODO Auto-generated method stub
		return shoppingCart;
	}
}
