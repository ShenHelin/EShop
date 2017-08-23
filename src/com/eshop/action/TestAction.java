package com.eshop.action;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserAddress;
import com.eshop.service.iservice.IUserAddressService;
import com.opensymphony.xwork2.ActionContext;

public class TestAction {
	
	@Autowired
	@Qualifier("userAddressService")
	private static IUserAddressService userAddressService;	
	
	public static void main(String[] args) {
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(user);
		UserAddress userAddress = new UserAddress("yulei", "DALIAN-QIANFENG", "150030", "13366666666", "1");
		userAddress.setUser(user);
		
		userAddressService.save(userAddress);
		
	}
	
	@Test
	public void test(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(user);
		UserAddress userAddress = new UserAddress("yulei", "DALIAN-QIANFENG", "150030", "13366666666", "1");
		userAddress.setUser(user);
		
		userAddressService.save(userAddress);
	}
	
	
}
