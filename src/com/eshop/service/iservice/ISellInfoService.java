package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.SellInfo;

public interface ISellInfoService extends IBaseService<SellInfo, Integer> {
	
	//根据	销售订单编号sellNo	进行查询
	List<SellInfo> findBySellNo(String sellNo) ;
	//根据	订单提交时间submitTime	进行查询
	List<SellInfo> findBySubmitTime(String firsetTime,String secondTime) ;
	//根据	商户adminId	进行查询
	List<SellInfo> findByAdminId(int adminId) ;
	//根据	用户userId	进行查询
	List<SellInfo> findByUserId(int userId) ;
	
	
}
