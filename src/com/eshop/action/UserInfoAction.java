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
public class UserInfoAction {
	@Autowired
	@Qualifier("userAddressService")
	private IUserInfoService userInfoService;	

	
	//@ModelAttribute Goods goods,Map<String,Object> map
	
}
