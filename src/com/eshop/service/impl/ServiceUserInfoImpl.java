package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IUserInfoDao;
import com.eshop.dao.pojo.UserInfo;
import com.eshop.service.iservice.IUserInfoService;

@Service("userInfoService")
public class ServiceUserInfoImpl implements IUserInfoService {

	@Autowired
	@Qualifier("userInfoDao")
	private IUserInfoDao userInfoDao;

	@Transactional
	@Override
	public String save(UserInfo t) {
		String msg = "error";
		try {
				userInfoDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(UserInfo t) {
		String msg = "error";
		try {
				userInfoDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(UserInfo t) {
		String msg = "error";
		try {
				userInfoDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findAll() {
		List<UserInfo> userInfoList = null;
		try {
			userInfoList = userInfoDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public UserInfo findById(Integer k) {
		UserInfo userInfo = null;
		try {
			userInfo = userInfoDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findByRegTime(String firstTime, String secondTime) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findByRegTime(firstTime, secondTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findByName(String name) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findBySex(String sex) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findBySex(sex);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findByPhone(String phone) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findByPhone(phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<UserInfo> findByEmail(String email) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	@Override
	public List<UserInfo> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<UserInfo> userInfoList = null;
		try {
			userInfoList =  userInfoDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfoList;
	}

}
