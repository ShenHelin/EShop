package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.ISellItemDao;
import com.eshop.dao.pojo.SellItem;

@Repository("sellItemDao")
public class DaoSellItemImpl implements ISellItemDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(SellItem t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(SellItem t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(SellItem t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}
	@Override
	public List<SellItem> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellItem").list();
	}

	@Override
	public SellItem findById(Integer k) throws Exception {
		return (SellItem) sessionFactory.getCurrentSession().createQuery("from SellItem s where s.sellItemId=:sellItemId")
				.setParameter("shoppingCartId", k).uniqueResult();
	}

	@Override
	public List<SellItem> findBySellId(int sellId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellItem s where s.sellId like :sellId")
				.setParameter("sellId", "%" + sellId + "%").list();
	}

	@Override
	public List<SellItem> findByGoodsId(int goodsId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from SellItem s where s.goodsId like :goodsId")
				.setParameter("goodsId", "%" + goodsId + "%").list();
	}

}
