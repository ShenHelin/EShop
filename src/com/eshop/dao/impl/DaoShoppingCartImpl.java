package com.eshop.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.eshop.dao.idao.IShoppingCartDao;
import com.eshop.dao.pojo.ShoppingCart;

@Repository("shoppingCartDao")
public class DaoShoppingCartImpl implements IShoppingCartDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void save(ShoppingCart t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ShoppingCart t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ShoppingCart t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShoppingCart> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart findById(Integer k) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCart> findByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCart> findByGoodsId(int goodsId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCart> findByPage(int page, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
