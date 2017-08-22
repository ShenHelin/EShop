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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(OrderInfo t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(OrderInfo t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<OrderInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo").list();
	}

	@Override
	public OrderInfo findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return (OrderInfo) sessionFactory.getCurrentSession().createQuery("from OrderInfo where orderId=:orderId").setParameter("orderId", k).uniqueResult();
	}

	@Override
	public List<OrderInfo> findByOrderNo(String orderNo) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo where orderNo=:orderNo").setParameter("orderNo", orderNo).list();
	}

	@Override
	public List<OrderInfo> findBySubmitTime(String firstTime, String secondTime) throws Exception {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo where between firstTime=:firstTime and secondTime=:secondTime").setParameter("firstTime", firstTime).setParameter("secondTime", secondTime).list();
	}

	@Override
	public List<OrderInfo> findByOrderName(String orderName) throws Exception {
		
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo where orderName=:orderName").setParameter("orderName", orderName).list();
	}

	@Override
	public List<OrderInfo> findByOrderPhone(String orderPhone) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo where orderPhone=:orderPhone").setParameter("orderPhone", orderPhone).list();
	}

	@Override
	public List<OrderInfo> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo where userId=:userId").setParameter("userId", userId).list();
	}

	@Override
	public List<OrderInfo> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from OrderInfo").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}
}
