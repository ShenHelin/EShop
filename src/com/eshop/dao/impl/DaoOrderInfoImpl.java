package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IOrderInfoDao;
import com.eshop.dao.pojo.OrderInfo;

@Repository("orderInfoDao")
public class DaoOrderInfoImpl implements IOrderInfoDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(OrderInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderInfo findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByOrderNo(String orderNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findBySubmitTime(String firstTime, String secondTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByOrderName(String orderName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByOrderPhone(String orderPhone) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInfo> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
