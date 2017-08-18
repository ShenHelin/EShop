package com.eshop.dao.idao;

import com.eshop.dao.pojo.Admin;

public interface IAdminDao extends IBaseDao<Admin, Integer> {
	//根据   商户username 进行查询
	Admin findByUserName(String username) throws Exception;
}
