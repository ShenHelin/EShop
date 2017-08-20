package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IUserDao;
import com.eshop.dao.pojo.User;

@Repository("userDao")
public class DaoUserImpl implements IUserDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(User t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByName(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
