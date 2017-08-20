package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.ISellInfoDao;
import com.eshop.dao.pojo.SellInfo;
import com.eshop.service.iservice.ISellInfoService;

@Service("sellInfoService")
public class ServiceSellInfoImpl implements ISellInfoService {

	@Autowired
	@Qualifier("sellInfoDao")
	private ISellInfoDao sellInfoDao;

	@Transactional
	@Override
	public String save(SellInfo t) {
		String msg = "error";
		try {
				sellInfoDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(SellInfo t) {
		String msg = "error";
		try {
				sellInfoDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	@Transactional
	@Override
	public String delete(SellInfo t) {
		String msg = "error";
		try {
				sellInfoDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellInfo> findAll() {
		List<SellInfo> sellInfoList = null;
		try {
			sellInfoList = sellInfoDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public SellInfo findById(Integer k) {
		SellInfo sellInfo = null;
		try {
			sellInfo = sellInfoDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfo;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellInfo> findBySellNo(String sellNo) {
		// TODO Auto-generated method stub
		List<SellInfo> sellInfoList = null;
		try {
			sellInfoList =  sellInfoDao.findBySellNo(sellNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellInfo> findBySubmitTime(String firsetTime, String secondTime) {
		// TODO Auto-generated method stub
		List<SellInfo> sellInfoList = null;
		try {
			sellInfoList =  sellInfoDao.findBySubmitTime(firsetTime, secondTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellInfo> findByAdminId(int adminId) {
		// TODO Auto-generated method stub
		List<SellInfo> sellInfoList = null;
		try {
			sellInfoList =  sellInfoDao.findByAdminId(adminId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfoList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellInfo> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<SellInfo> sellInfoList = null;
		try {
			sellInfoList =  sellInfoDao.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellInfoList;
	}

}
