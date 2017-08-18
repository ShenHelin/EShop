package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eshop.dao.idao.IShoppingCartDao;
import com.eshop.dao.pojo.ShoppingCart;
import com.eshop.service.iservice.IShoppingCartService;

@Service("shoppingCartService")
public class ServiceShoppingCartImpl implements IShoppingCartService {

	@Autowired
	@Qualifier("shoppingCartDao")
	private IShoppingCartDao shoppingCartDao;

	@Override
	public String save(ShoppingCart t) {
		String msg = "error";
		try {
				shoppingCartDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(ShoppingCart t) {
		String msg = "error";
		try {
				shoppingCartDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(ShoppingCart t) {
		String msg = "error";
		try {
				shoppingCartDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<ShoppingCart> findAll() {
		List<ShoppingCart> shoppingCartList = null;
		try {
			shoppingCartList = shoppingCartDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartList;
	}

	@Override
	public ShoppingCart findById(Integer k) {
		ShoppingCart shoppingCart = null;
		try {
			shoppingCart = shoppingCartDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCart;
	}

	@Override
	public List<ShoppingCart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<ShoppingCart> shoppingCartList = null;
		try {
			shoppingCartList =  shoppingCartDao.findByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartList;
	}

	@Override
	public List<ShoppingCart> findByGoodsId(int goodsId) {
		// TODO Auto-generated method stub
		List<ShoppingCart> shoppingCartList = null;
		try {
			shoppingCartList =  shoppingCartDao.findByGoodsId(goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartList;
	}

	@Override
	public List<ShoppingCart> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<ShoppingCart> shoppingCartList = null;
		try {
			shoppingCartList =  shoppingCartDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shoppingCartList;
	}

}
