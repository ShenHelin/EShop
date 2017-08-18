package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.OrderStatus;

public interface IOrderStatusDao extends IBaseDao<OrderStatus, Integer> {
	
	//根据	订单状态statusName	进行查询
	List<OrderStatus> findByStatusName(String statusName) throws Exception;
	//根据	订单编号orderId	进行查询
	List<OrderStatus> findByOrderId(int orderId) throws Exception;
	
	
	
}
