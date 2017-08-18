package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.SellItem;

public interface ISellItemService extends IBaseService<SellItem, Integer> {
	
	//根据	销售信息Id sellId	进行查询
	List<SellItem> findBySellId(int sellId) ;
	//根据	商品goodsId	进行查询
	List<SellItem> findByGoodsId(int goodsId) ;
	
	
}
