package com.eshop.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IGoodsClassDao;
import com.eshop.dao.pojo.GoodsClass;

@Repository("goodsClassDao")
public class DaoGoodsClassImpl implements IGoodsClassDao,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public void save(GoodsClass g) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(g);
	}

	@Override
	public void update(GoodsClass t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(GoodsClass t) throws Exception {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public List<GoodsClass> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from GoodsClass").list();
	}

	@Override
	public GoodsClass findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return (GoodsClass) sessionFactory.getCurrentSession().createQuery("from GoodsClass g where g.classId=:classId")
				.setParameter("classId", k).uniqueResult();
	}

	@Override
	public GoodsClass findByClassNo(String classNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findByName(String className) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findBySuperClass(String superClass) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
