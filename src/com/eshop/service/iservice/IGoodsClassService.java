package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.GoodsClass;

public interface IGoodsClassService extends IBaseService<GoodsClass, Integer> {
	
		//根据商品种类编号进行查询
		GoodsClass findByClassNo(String classNo) ;
		//根据商品种类名称进行查询
		List<GoodsClass> findByName(String className) ;
		//根据父类种类进行查询
		List<GoodsClass> findBySuperClass(String superClass) ;

		
		List<GoodsClass> findByPage(int page, int size) ;
	
	
}
