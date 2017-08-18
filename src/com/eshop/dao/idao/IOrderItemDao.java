package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.OrderItem;

public interface IOrderItemDao extends IBaseDao<OrderItem, Integer> {
	
	//根据	订单编号orderId	进行查询
	List<OrderItem> findByOrderId(int orderId) throws Exception;
	//根据	商品goodsId	进行查询
	List<OrderItem> findByGoodsId(int goodsId) throws Exception;
	
	
}
