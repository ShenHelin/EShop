package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.eshop.dao.idao.IGoodsClassDao;
import com.eshop.dao.pojo.GoodsClass;
import com.eshop.service.iservice.IGoodsClassService;

@Service("goodsClassService")
public class ServiceGoodsClassImpl implements IGoodsClassService {

	@Autowired
	@Qualifier("goodsClassDao")
	private IGoodsClassDao goodsClassDao;


	@Override
	public String save(GoodsClass t) {
		String msg = "error";
		try {
				goodsClassDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(GoodsClass t) {
		String msg = "error";
		try {
				goodsClassDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(GoodsClass t) {
		String msg = "error";
		try {
				goodsClassDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<GoodsClass> findAll() {
		List<GoodsClass> goodsClassList = null;
		try {
			goodsClassList = goodsClassDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClassList;
	}

	@Override
	public GoodsClass findById(Integer k) {
		GoodsClass goodsClass = null;
		try {
			goodsClass = goodsClassDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClass;
	}

	@Override
	public GoodsClass findByClassNo(String classNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findByName(String className) {
		// TODO Auto-generated method stub
		List<GoodsClass> goodsClassList = null;
		try {
			goodsClassList =  goodsClassDao.findByName(className);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClassList;
	}

	@Override
	public List<GoodsClass> findBySuperClass(String superClass) {
		// TODO Auto-generated method stub
		List<GoodsClass> goodsClassList = null;
		try {
			goodsClassList =  goodsClassDao.findBySuperClass(superClass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClassList;
	}

	@Override
	public List<GoodsClass> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<GoodsClass> goodsClassList = null;
		try {
			goodsClassList =  goodsClassDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsClassList;
	}

}
