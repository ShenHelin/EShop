package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.User;

public interface IUserDao extends IBaseDao<User,Integer>{
	
	List<User> findByName(String username) throws Exception;
	List<User> findByPage(int page, int size) throws Exception;
	User findByUP(String username,String password) throws Exception;
}
