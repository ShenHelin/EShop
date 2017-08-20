package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IOrderItemDao;
import com.eshop.dao.pojo.OrderItem;

@Repository("orderItemDao")
public class DaoOrderItemImpl implements IOrderItemDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(OrderItem t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderItem t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderItem t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItem> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByOrderId(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
