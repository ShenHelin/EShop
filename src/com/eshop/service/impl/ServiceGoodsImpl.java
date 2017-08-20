package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IGoodsDao;
import com.eshop.dao.pojo.Goods;
import com.eshop.service.iservice.IGoodsService;

@Service("goodsService")
public class ServiceGoodsImpl implements IGoodsService {

	@Autowired
	@Qualifier("goodsDao")
	private IGoodsDao goodsDao;

	@Transactional
	@Override
	public String save(Goods t) {
		String msg = "error";
		try {
				goodsDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Goods t) {
		String msg = "error";
		try {
				goodsDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Goods t) {
		String msg = "error";
		try {
				goodsDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findAll() {
		List<Goods> goodsList = null;
		try {
			goodsList = goodsDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public Goods findById(Integer k) {
		Goods goods = null;
		try {
			goods = goodsDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByGoodsName(goodsName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByManufacturer(String manufacturer) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByManufacturer(manufacturer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByPrice(double firstPrice, double secondPrice) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByPrice(firstPrice, secondPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByRegTime(String regTime) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByRegTime(regTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByAdminId(int adminId) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByAdminId(adminId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Goods> findByClassId(int classId) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByClassId(classId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	@Transactional(readOnly=true,
			propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED)
	@Override
	public List<Goods> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		List<Goods> goodsList = null;
		try {
			goodsList =  goodsDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsList;
	}



}
