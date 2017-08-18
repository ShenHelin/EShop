package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.GoodsClass;

public interface IGoodsClassDao extends IBaseDao<GoodsClass, Integer> {
	
		//根据商品种类编号进行查询
		GoodsClass findByClassNo(String classNo) throws Exception;
		//根据商品种类名称进行查询
		List<GoodsClass> findByName(String className) throws Exception;
		//根据父类种类进行查询
		List<GoodsClass> findBySuperClass(String superClass) throws Exception;

		List<GoodsClass> findByPage(int page, int size) throws Exception;
	
	
}
