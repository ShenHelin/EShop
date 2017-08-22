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
		sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void update(ShoppingCart t) throws Exception {
		sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public void delete(ShoppingCart t) throws Exception {
		sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public List<ShoppingCart> findAll() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from ShoppingCart").list();
	}

	@Override
	public ShoppingCart findById(Integer k) throws Exception {
		return (ShoppingCart) sessionFactory.getCurrentSession().createQuery("from ShoppingCart s where s.shoppingCartId=:shoppingCartId")
				.setParameter("shoppingCartId", k).uniqueResult();
	}

	@Override
	public List<ShoppingCart> findByUserId(int userId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from ShoppingCart s where s.user.userId=:userId")
				.setParameter("userId", userId).list();
	}

	@Override
	public List<ShoppingCart> findByGoodsId(int goodsId) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from ShoppingCart s where s.goodsId like :goodsId")
				.setParameter("goodsId", "%" + goodsId + "%").list();
	}

	@Override
	public List<ShoppingCart> findByPage(int page, int size) throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from ShoppingCart").setFirstResult((page - 1) * size)
				.setMaxResults(size).list();
	}

}
