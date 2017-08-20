package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.SellItem;
import com.eshop.service.iservice.ISellItemService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sellItemAction")
@Scope("prototype")
public class SellItemAction implements ModelDriven<SellItem>, RequestAware{
	@Autowired
	@Qualifier("sellItemService")
	private ISellItemService sellItemService;	
	private SellItem sellItem = new SellItem();

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public SellItem getModel() {
		// TODO Auto-generated method stub
		return sellItem;
	}
}
