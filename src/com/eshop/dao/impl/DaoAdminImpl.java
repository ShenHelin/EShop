package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IAdminDao;
import com.eshop.dao.pojo.Admin;
import com.eshop.dao.pojo.Goods;

@Repository("adminDao")
public class DaoAdminImpl implements IAdminDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(Admin g) throws Exception {
		sessionFactory.getCurrentSession().save(g);
	}

	@Override
	public void update(Admin g) throws Exception {
		sessionFactory.getCurrentSession().update(g);
	}

	@Override
	public void delete(Admin g) throws Exception {
		sessionFactory.getCurrentSession().delete(g);
	}

	@Override
	public List<Admin> findAll() throws Exception {
		
		return sessionFactory.getCurrentSession().createQuery("from Admin").list();
		
	}

	@Override
	public Admin findById(Integer k) throws Exception {
		return (Admin) sessionFactory.getCurrentSession().createQuery("from Admin g where g.adminId=:adminId")
				.setParameter("adminId", k).uniqueResult();
	}

	@Override
	public Admin findByUserName(String username) throws Exception {
		// TODO Auto-generated method stub
		return (Admin) sessionFactory.getCurrentSession().createQuery("from Admin g where g.username=:username")
				.setParameter("username", username).uniqueResult();
	}

}
