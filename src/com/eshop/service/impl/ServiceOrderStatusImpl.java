package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IOrderStatusDao;
import com.eshop.dao.pojo.OrderItem;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.service.iservice.IOrderStatusService;

@Service("orderStatusService")
public class ServiceOrderStatusImpl implements IOrderStatusService {

	@Autowired
	@Qualifier("orderStatusDao")
	private IOrderStatusDao orderStatusDao;

	@Transactional
	@Override
	public String save(OrderStatus t) {
		String msg = "error";
		try {
				orderStatusDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(OrderStatus t) {
		String msg = "error";
		try {
				orderStatusDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(OrderStatus t) {
		String msg = "error";
		try {
				orderStatusDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderStatus> findAll() {
		List<OrderStatus> orderStatusList = null;
		try {
			orderStatusList = orderStatusDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderStatusList;
	}

	@Transactional(readOnly=true)
	@Override
	public OrderStatus findById(Integer k) {
		OrderStatus orderStatus = null;
		try {
			orderStatus = orderStatusDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderStatus;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderStatus> findByStatusName(String statusName) {
		// TODO Auto-generated method stub
		List<OrderStatus> orderStatusList = null;
		try {
			orderStatusList =  orderStatusDao.findByStatusName(statusName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderStatusList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderStatus> findByOrderId(int orderId) {
		// TODO Auto-generated method stub
		List<OrderStatus> orderStatusList = null;
		try {
			orderStatusList =  orderStatusDao.findByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderStatusList;
	}

}
