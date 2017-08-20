package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IAdminDao;
import com.eshop.dao.pojo.Admin;

@Repository("adminDao")
public class DaoAdminImpl implements IAdminDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(Admin t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Admin t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
