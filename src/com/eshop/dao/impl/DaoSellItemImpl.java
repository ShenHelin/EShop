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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SellItem t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SellItem t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SellItem> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SellItem findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellItem> findBySellId(int sellId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SellItem> findByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
