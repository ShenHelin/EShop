package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IAccountDao;
import com.eshop.dao.pojo.Account;

@Repository("accountDao")
public class DaoAccountImpl implements IAccountDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findByAccountName(String accountName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
