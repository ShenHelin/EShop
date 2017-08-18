package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.UserAddress;

public interface IUserAddressService extends IBaseService<UserAddress, Integer> {

		// 根据收货姓名进行模糊查询
		List<UserAddress> findByName(String addressName) ;
		// 返回默认收货地址
		UserAddress findIsDefault() ;
		
		List<UserAddress> findByPage(int page, int size) ;
	
		
}
