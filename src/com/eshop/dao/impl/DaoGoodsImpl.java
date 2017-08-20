package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IGoodsDao;
import com.eshop.dao.pojo.Goods;

@Repository("goodsDao")
public class DaoGoodsImpl implements IGoodsDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Goods g) throws Exception {
		sessionFactory.getCurrentSession().save(g);
	}

	@Override
	public void update(Goods g) throws Exception {
		sessionFactory.getCurrentSession().update(g);
	}

	@Override
	public void delete(Goods g) throws Exception {
		sessionFactory.getCurrentSession().delete(g);
	}

	@Override
	public List<Goods> findAll() throws Exception {
		
		return sessionFactory.getCurrentSession().createQuery("from Goods").list();
		
	}

	@Override
	public Goods findById(Integer k) throws Exception {
		return (Goods) sessionFactory.getCurrentSession().createQuery("from Goods g where g.goodsId=:goodsId")
				.setParameter("goodsId", k).uniqueResult();
	}

	@Override
	public List<Goods> findByGoodsName(String goodsName) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods g where g.goodsName like :goodsName")
				.setParameter("goodsName", "%" + goodsName + "%").list();
	}

	@Override
	public List<Goods> findByManufacturer(String manufacturer) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods g where g.manufacturer like :manufacturer")
				.setParameter("manufacturer", "%" + manufacturer + "%").list();
	}

	@Override
	public List<Goods> findByPrice(double firstPrice, double secondPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findByRegTime(String regTime) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findByAdminId(int adminId) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods g where g.adminId like :adminId")
				.setParameter("adminId", "%" + adminId + "%").list();
	}

	@Override
	public List<Goods> findByClassId(int classId) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods g where g.classId like :classId")
				.setParameter("classId", "%" + classId + "%").list();
	}

	@Override
	public List<Goods> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Goods").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

}
