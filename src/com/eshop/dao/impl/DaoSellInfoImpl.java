package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.ISellInfoDao;
import com.eshop.dao.pojo.SellInfo;

@Repository("sellInfoDao")
public class DaoSellInfoImpl implements ISellInfoDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(SellInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SellInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SellInfo t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SellInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellInfo findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellInfo> findBySellNo(String sellNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellInfo> findBySubmitTime(String firsetTime, String secondTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellInfo> findByAdminId(int adminId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellInfo> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
