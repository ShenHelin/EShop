package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.UserInfo;
import com.eshop.service.iservice.IUserInfoService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userInfoAction")
@Scope("prototype")
public class UserInfoAction implements ModelDriven<UserInfo>, RequestAware{
	@Autowired
	@Qualifier("userAddressService")
	private IUserInfoService userInfoService;	
	private UserInfo userInfo = new UserInfo();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public UserInfo getModel() {
		// TODO Auto-generated method stub
		return userInfo;
	}
}
