package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.User;

public interface IUserService extends IBaseService<User,Integer>{
	
	List<User> findByName(String username) ;
	List<User> findByPage(int page, int size) ;
	User findByUP(String username,String password);
}
