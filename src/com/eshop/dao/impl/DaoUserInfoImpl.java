package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IUserInfoDao;
import com.eshop.dao.pojo.UserInfo;

@Repository("userInfoDao")
public class DaoUserInfoImpl implements IUserInfoDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(UserInfo t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(UserInfo t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(UserInfo t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<UserInfo> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo").list();
	}

	@Override
	public UserInfo findById(Integer k) throws Exception {
		return (UserInfo) sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.userId=:userId")
				.setParameter("userInfo", k).uniqueResult();
	}

	@Override
	public List<UserInfo> findByRegTime(String firstTime, String secondTime) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where between firstTime=:firstTime and secondTime=:secondTime").setParameter("firstTime", firstTime).setParameter("secondTime", secondTime).list();
	}

	@Override
	public List<UserInfo> findByName(String name) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.name like :name")
				.setParameter("name", "%" + name + "%").list();
	}

	@Override
	public List<UserInfo> findBySex(String sex) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where sex=:sex").setParameter("sex",sex).list();
	}

	@Override
	public List<UserInfo> findByPhone(String phone) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where phone=:phone").setParameter("phone",phone).list();
	}

	@Override
	public List<UserInfo> findByEmail(String email) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo where email=:email").setParameter("email",email).list();
	}

	@Override
	public List<UserInfo> findByPage(int page, int size) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from UserInfo").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}
}

