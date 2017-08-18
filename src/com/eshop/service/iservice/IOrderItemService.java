package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.OrderItem;

public interface IOrderItemService extends IBaseService<OrderItem, Integer> {
	
	//根据	订单编号orderId	进行查询
	List<OrderItem> findByOrderId(int orderId) ;
	//根据	商品goodsId	进行查询
	List<OrderItem> findByGoodsId(int goodsId) ;
	
	
}
