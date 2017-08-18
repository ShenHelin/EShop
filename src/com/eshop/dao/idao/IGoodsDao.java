package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.GoodsClass;

public interface IGoodsDao extends IBaseDao<Goods, Integer> {
	
		//根据商品名称进行查询
		List<Goods> findByGoodsName(String goodsName) throws Exception;
		//根据商品厂家进行查询
		List<Goods> findByManufacturer(String manufacturer) throws Exception;
		//根据商品价格进行查询
		List<Goods> findByPrice(double firstPrice,double secondPrice) throws Exception;
		//根据商品上架时间进行查询
		List<Goods> findByRegTime(String regTime) throws Exception;
		//根据商家adminId进行查询
		List<Goods> findByAdminId(int adminId) throws Exception;
		//根据商品种类classId进行查询
		List<Goods> findByClassId(int classId) throws Exception;
	
	
		List<Goods> findByPage(int page, int size) throws Exception;
	
	
}
