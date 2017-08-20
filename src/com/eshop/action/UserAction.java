package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.User;
import com.eshop.service.iservice.IUserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<User>, RequestAware{
	@Autowired
	@Qualifier("userService")
	private IUserService userService;	
	private User user = new User();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
