package com.eshop.service.iservice;

import com.eshop.dao.pojo.Admin;

public interface IAdminService extends IBaseService<Admin, Integer> {
	//根据   商户username 进行查询
	Admin findByUserName(String username) ;
	
}
