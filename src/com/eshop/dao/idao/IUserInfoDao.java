package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserInfo;

public interface IUserInfoDao extends IBaseDao<UserInfo, Integer> {
	
	//根据两个时间段查找 注册的用户
	List<UserInfo> findByRegTime(String firstTime,String secondTime) throws Exception;
	//根据用户的名字进行模糊查询
	List<UserInfo> findByName(String name) throws Exception;
	//根据用户的性别进行查询
	List<UserInfo> findBySex(String sex) throws Exception;
	//根据用户的注册手机号进行查询
	List<UserInfo> findByPhone(String phone) throws Exception;
	//根据用户的注册邮箱号进行查询
	List<UserInfo> findByEmail(String email) throws Exception;
	
	List<UserInfo> findByPage(int page, int size) throws Exception;
	
}
