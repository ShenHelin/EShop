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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(User t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(User t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<User> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User findById(Integer k) throws Exception {
		return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.userId=:userId")
				.setParameter("userId", k).uniqueResult();
	}
	
	@Override
	public User findByUP(String username,String password) throws Exception {
		
		return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username and u.password=:password")
				.setParameter("username", username).setParameter("password", password).uniqueResult();
		
	}

	@Override
	public List<User> findByName(String username) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from User u where u.userName like :userName")
				.setParameter("userName", "%" + username + "%").list();
	}

	@Override
	public List<User> findByPage(int page, int size) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from User").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

}
