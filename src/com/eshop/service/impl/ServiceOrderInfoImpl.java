package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IOrderInfoDao;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.service.iservice.IOrderInfoService;

@Service("orderInfoService")
public class ServiceOrderInfoImpl implements IOrderInfoService {

	@Autowired
	@Qualifier("orderInfoDao")
	private IOrderInfoDao orderInfoDao;

	@Transactional
	@Override
	public String save(OrderInfo t) {
		String msg = "error";
		try {
				orderInfoDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(OrderInfo t) {
		String msg = "error";
		try {
				orderInfoDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(OrderInfo t) {
		String msg = "error";
		try {
				orderInfoDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findAll() {
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList = orderInfoDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public OrderInfo findById(Integer k) {
		OrderInfo orderInfo = null;
		try {
			orderInfo = orderInfoDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfo;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findByOrderNo(String orderNo) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findByOrderNo(orderNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findBySubmitTime(String firstTime, String secondTime) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findBySubmitTime(firstTime, secondTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findByOrderName(String orderName) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findByOrderName(orderName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findByOrderPhone(String orderPhone) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findByOrderPhone(orderPhone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<OrderInfo> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	@Override
	public List<OrderInfo> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<OrderInfo> orderInfoList = null;
		try {
			orderInfoList =  orderInfoDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderInfoList;
	}

}
