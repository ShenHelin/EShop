package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.SellInfo;
import com.eshop.service.iservice.ISellInfoService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sellInfoAction")
@Scope("prototype")
public class SellInfoAction implements ModelDriven<SellInfo>, RequestAware{
	@Autowired
	@Qualifier("sellInfoService")
	private ISellInfoService sellInfoService;	
	private SellInfo sellInfo = new SellInfo();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public SellInfo getModel() {
		// TODO Auto-generated method stub
		return sellInfo;
	}
}
