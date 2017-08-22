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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(SellInfo t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(SellInfo t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<SellInfo> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellInfo").list();
	}

	@Override
	public SellInfo findById(Integer k) throws Exception {
		return (SellInfo) sessionFactory.getCurrentSession().createQuery("from SellInfo s where s.sellId=:sellId")
				.setParameter("sellId", k).uniqueResult();
	}

	@Override
	public List<SellInfo> findBySellNo(String sellNo) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellInfo s where s.sellNo like :sellNo")
				.setParameter("sellNo", "%" + sellNo + "%").list();
	}

	@Override
	public List<SellInfo> findBySubmitTime(String firsetTime, String secondTime) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellInfo where between firstTime=:firstTime and secondTime=:secondTime")
				.setParameter("firstTime", firsetTime).setParameter("secondTime", secondTime).list();

	}

	@Override
	public List<SellInfo> findByAdminId(int adminId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellInfo s where s.adminId like :adminId")
				.setParameter("adminId", "%" + adminId + "%").list();
	}

	@Override
	public List<SellInfo> findByUserId(int userId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellInfo s where s.userId like :userId")
				.setParameter("userId", "%" + userId + "%").list();
	}

}
