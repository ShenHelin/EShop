package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.UserAddress;
import com.eshop.service.iservice.IUserAddressService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAddressAction")
@Scope("prototype")
public class UserAddressAction implements ModelDriven<UserAddress>, RequestAware{
	@Autowired
	@Qualifier("userAddressService")
	private IUserAddressService userAddressService;	
	private UserAddress userAddress = new UserAddress();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public UserAddress getModel() {
		// TODO Auto-generated method stub
		return userAddress;
	}
}
