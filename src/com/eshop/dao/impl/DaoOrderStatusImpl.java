package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IOrderStatusDao;
import com.eshop.dao.pojo.OrderStatus;

@Repository("orderStatusDao")
public class DaoOrderStatusImpl implements IOrderStatusDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(OrderStatus t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(OrderStatus t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(OrderStatus t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public List<OrderStatus> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderStatus").list();
	}

	@Override
	public OrderStatus findById(Integer k) throws Exception {
		return (OrderStatus) sessionFactory.getCurrentSession().createQuery("from OrderStatus o where o.ispay=:ispay")
				.setParameter("ispay", k).uniqueResult();
	}

	@Override
	public List<OrderStatus> findByStatusName(String statusName) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderStatus o where o.issend like :issend")
				.setParameter("issend", "%" + statusName + "%").list();
	}

	@Override
	public List<OrderStatus> findByOrderId(int orderId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from OrderStatus o where o.orderId like :orderId")
				.setParameter("orderId", "%" + orderId + "%").list();
	}
}
