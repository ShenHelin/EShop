package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IGoodsClassDao;
import com.eshop.dao.pojo.GoodsClass;
import com.eshop.service.iservice.IGoodsClassService;

@Service("goodsClassService")
public class ServiceGoodsClassImpl implements IGoodsClassService {

	@Autowired
	@Qualifier("goodsClassDao")
	private IGoodsClassDao goodsClassDao;

	@Transactional
	@Override
	public String save(GoodsClass t) {
		String msg = "error";
		try {
				goodsClassDao.save(t);
				msg = "saveSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("GoodsClassService   msg= " + msg);
		return msg;
	}

	@Transactional
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

	@Transactional
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

	@Transactional(readOnly=true)
	@Override
	public List<GoodsClass> findAll() {
		List<GoodsClass> GoodsClassList = null;
		try {
			GoodsClassList = goodsClassDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		return GoodsClassList;
	}

	@Transactional(readOnly=true)
	@Override
	public GoodsClass findById(Integer k) {
		GoodsClass GoodsClass = null;
		try {
			GoodsClass = goodsClassDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return GoodsClass;
	}

	@Override
	public GoodsClass findByClassNo(String classNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findByName(String className) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findBySuperClass(String superClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsClass> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
