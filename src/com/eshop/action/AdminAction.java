package com.eshop.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eshop.dao.pojo.Admin;
import com.eshop.service.iservice.IAdminService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class AdminAction {
	@Autowired
	@Qualifier("adminService")
	private IAdminService adminService;
	
	//@ModelAttribute Goods goods,Map<String,Object> map



}
