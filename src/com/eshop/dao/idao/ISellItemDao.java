package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.SellItem;

public interface ISellItemDao extends IBaseDao<SellItem, Integer> {
	
	//根据	销售信息Id sellId	进行查询
	List<SellItem> findBySellId(int sellId) throws Exception;
	//根据	商品goodsId	进行查询
	List<SellItem> findByGoodsId(int goodsId) throws Exception;
	
	
}
