package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.OrderStatus;

public interface IOrderStatusService extends IBaseService<OrderStatus, Integer> {
	
	//根据	订单状态statusName	进行查询
	List<OrderStatus> findByStatusName(String statusName) ;
	//根据	订单编号orderId	进行查询
	List<OrderStatus> findByOrderId(int orderId) ;
	
	
	
}
