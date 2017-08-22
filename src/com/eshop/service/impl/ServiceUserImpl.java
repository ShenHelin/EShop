package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IUserDao;
import com.eshop.dao.pojo.User;
import com.eshop.service.iservice.IUserService;

@Service("userService")
public class ServiceUserImpl implements IUserService {

	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Transactional
	@Override
	public String save(User t) {
		String msg = "error";
		try {
				userDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(User t) {
		String msg = "error";
		try {
				userDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@Transactional
	@Override
	public String delete(User t) {
		String msg = "error";
		try {
				userDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findAll() {
		List<User> userList = null;
		try {
			userList = userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Transactional(readOnly=true)
	@Override
	public User findById(Integer k) {
		User user = null;
		try {
			user = userDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Transactional(readOnly=true)
	@Override
	public User findByUP(String username,String password) {
		User user = null;
		try {
			user = userDao.findByUP(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findByName(String username) {
		// TODO Auto-generated method stub
		List<User> userList = null;
		try {
			userList =  userDao.findByName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	@Override
	public List<User> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<User> userList = null;
		try {
			userList =  userDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}
