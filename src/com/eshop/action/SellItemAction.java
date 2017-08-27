package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.pojo.SellItem;
import com.eshop.service.iservice.ISellItemService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@RequestMapping("sellItem")
public class SellItemAction {
	@Autowired
	@Qualifier("sellItemService")
	private ISellItemService sellItemService;	
	
	//@ModelAttribute Goods goods,Map<String,Object> map
	
	
	
}
