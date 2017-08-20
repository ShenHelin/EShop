package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IUserInfoDao;
import com.eshop.dao.pojo.UserInfo;

@Repository("userInfoDao")
public class DaoUserInfoImpl implements IUserInfoDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(UserInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByRegTime(String firstTime, String secondTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findBySex(String sex) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

