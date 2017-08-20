package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Admin;
import com.eshop.service.iservice.IAdminService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction implements ModelDriven<Admin>, RequestAware{
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	private Admin admin = new Admin();
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}




}
