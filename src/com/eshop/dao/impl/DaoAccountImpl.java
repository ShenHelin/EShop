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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(Account t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(Account t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<Account> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Account").list();
	}

	@Override
	public Account findById(Integer k) throws Exception {
		return (Account) sessionFactory.getCurrentSession().createQuery("from Account a where a.accountId=:accountId")
				.setParameter("accountId", k).uniqueResult();
	}

	@Override
	public Account findByAccountName(String accountName) throws Exception {		
		
		return (Account) sessionFactory.getCurrentSession().createQuery("from Account a where a.accountName like :accountName")
				.setParameter("accountName", "%" + accountName + "%").uniqueResult();
	}


	@Override
	public List<Account> findByUserId(int userId)  {
		List<Account> x =   sessionFactory.getCurrentSession().createQuery("from Account where user.userId=1").list();
		System.out.println(x);
		return x;
	}
}
