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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(UserAddress t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(UserAddress t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}
	@Override
	public List<UserAddress> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserAddress").list();
	}

	@Override
	public UserAddress findById(Integer k) throws Exception {
		return (UserAddress) sessionFactory.getCurrentSession().createQuery("from UserAddress u where u.addressId=:addressId")
				.setParameter("userAddress", k).uniqueResult();
	}

	@Override
	public List<UserAddress> findByName(String addressName) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserAddress u where u.addressName like :addressName")
				.setParameter("addressName", "%" + addressName + "%").list();
	}

	@Override
	public UserAddress findIsDefault() throws Exception {
		return (UserAddress) sessionFactory.getCurrentSession().createQuery("from UserAddress u where u.isDefault=:isDefault")
				.setParameter("userAddress", 1).uniqueResult();
	}

	@Override
	public List<UserAddress> findByPage(int page, int size) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserAddress").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

}
