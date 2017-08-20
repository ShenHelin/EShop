package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IUserAddressDao;
import com.eshop.dao.pojo.UserAddress;

@Repository("userAddressDao")
public class DaoUserAddressImpl implements IUserAddressDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(UserAddress t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserAddress t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(UserAddress t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserAddress> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAddress findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAddress> findByName(String addressName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAddress findIsDefault() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserAddress> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
