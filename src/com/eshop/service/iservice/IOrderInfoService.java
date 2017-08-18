package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.OrderInfo;

public interface IOrderInfoService extends IBaseService<OrderInfo, Integer> {
	
	//根据	订单编号orderNo	进行查询
	List<OrderInfo> findByOrderNo(String orderNo) ;
	//根据	订单提交时间	进行查询
	List<OrderInfo> findBySubmitTime(String firstTime,String secondTime) ;
	//根据	收货人姓名orderName	进行查询
	List<OrderInfo> findByOrderName(String orderName) ;
	//根据	订单收货手机orderPhone	进行查询
	List<OrderInfo> findByOrderPhone(String orderPhone) ;
	//根据	用户userId	进行查询
	List<OrderInfo> findByUserId(int userId) ;


	List<OrderInfo> findByPage(int page, int size) ;
	
	
}
