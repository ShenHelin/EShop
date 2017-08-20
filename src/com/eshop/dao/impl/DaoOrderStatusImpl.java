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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderStatus t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderStatus t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderStatus> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatus findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> findByStatusName(String statusName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderStatus> findByOrderId(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
