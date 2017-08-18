package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.ShoppingCart;

public interface IShoppingCartService extends IBaseService<ShoppingCart, Integer> {
	
		//根据用户id查询购物车里的内容
		List<ShoppingCart> findByUserId(int userId) ;
		
		//根据商品goodsId查询哪些用户收藏了该件商品
		List<ShoppingCart> findByGoodsId(int goodsId) ;
		
		List<ShoppingCart> findByPage(int page, int size) ;
		
	
}
