package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.SellInfo;

public interface ISellInfoDao extends IBaseDao<SellInfo, Integer> {
	
	//根据	销售订单编号sellNo	进行查询
	List<SellInfo> findBySellNo(String sellNo) throws Exception;
	//根据	订单提交时间submitTime	进行查询
	List<SellInfo> findBySubmitTime(String firsetTime,String secondTime) throws Exception;
	//根据	商户adminId	进行查询
	List<SellInfo> findByAdminId(int adminId) throws Exception;
	//根据	用户userId	进行查询
	List<SellInfo> findByUserId(int userId) throws Exception;
	
	
}
