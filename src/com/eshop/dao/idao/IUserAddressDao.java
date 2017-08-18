package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.UserAddress;

public interface IUserAddressDao extends IBaseDao<UserAddress, Integer> {

		// 根据收货姓名进行模糊查询
		List<UserAddress> findByName(String addressName) throws Exception;
		// 返回默认收货地址
		UserAddress findIsDefault() throws Exception;
		
		List<UserAddress> findByPage(int page, int size) throws Exception;
	
		
}
