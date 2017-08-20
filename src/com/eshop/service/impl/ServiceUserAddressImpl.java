package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IUserAddressDao;
import com.eshop.dao.pojo.UserAddress;
import com.eshop.service.iservice.IUserAddressService;

@Service("userAddressService")
public class ServiceUserAddressImpl implements IUserAddressService {

	@Autowired
	@Qualifier("userAddressDao")
	private IUserAddressDao userAddressDao;

	@Transactional
	@Override
	public String save(UserAddress t) {
		String msg = "error";
		try {
				userAddressDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(UserAddress t) {
		String msg = "error";
		try {
				userAddressDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(UserAddress t) {
		String msg = "error";
		try {
				userAddressDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserAddress> findAll() {
		List<UserAddress> userAddressList = null;
		try {
			userAddressList = userAddressDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddressList;
	}

	@Transactional(readOnly=true)
	@Override
	public UserAddress findById(Integer k) {
		UserAddress userAddress = null;
		try {
			userAddress = userAddressDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddress;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserAddress> findByName(String addressName) {
		// TODO Auto-generated method stub
		List<UserAddress> userAddressList = null;
		try {
			userAddressList =  userAddressDao.findByName(addressName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddressList;
	}

	@Transactional(readOnly=true)
	@Override
	public UserAddress findIsDefault() {
		// TODO Auto-generated method stub
		UserAddress userAddressList = null;
		try {
			userAddressList =  userAddressDao.findIsDefault();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddressList;
	}

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	@Override
	public List<UserAddress> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<UserAddress> userAddressList = null;
		try {
			userAddressList =  userAddressDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userAddressList;
	}

}
