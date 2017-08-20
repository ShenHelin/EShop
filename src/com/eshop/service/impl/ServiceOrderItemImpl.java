package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IOrderItemDao;
import com.eshop.dao.pojo.OrderItem;
import com.eshop.service.iservice.IOrderItemService;

@Service("orderItemService")
public class ServiceOrderItemImpl implements IOrderItemService {

	@Autowired
	@Qualifier("orderItemDao")
	private IOrderItemDao orderItemDao;

	@Transactional
	@Override
	public String save(OrderItem t) {
		String msg = "error";
		try {
				orderItemDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(OrderItem t) {
		String msg = "error";
		try {
				orderItemDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(OrderItem t) {
		String msg = "error";
		try {
				orderItemDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderItem> findAll() {
		List<OrderItem> orderItemList = null;
		try {
			orderItemList = orderItemDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Transactional(readOnly=true)
	@Override
	public OrderItem findById(Integer k) {
		OrderItem orderItem = null;
		try {
			orderItem = orderItemDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		// TODO Auto-generated method stub
		List<OrderItem> orderItemList = null;
		try {
			orderItemList =  orderItemDao.findByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderItem> findByGoodsId(int goodsId) {
		// TODO Auto-generated method stub
		List<OrderItem> orderItemList = null;
		try {
			orderItemList =  orderItemDao.findByGoodsId(goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItemList;
	}

}
