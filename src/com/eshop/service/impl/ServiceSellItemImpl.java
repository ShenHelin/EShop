package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.ISellItemDao;
import com.eshop.dao.pojo.SellItem;
import com.eshop.service.iservice.ISellItemService;

@Service("sellItemService")
public class ServiceSellItemImpl implements ISellItemService {

	@Autowired
	@Qualifier("sellItemDao")
	private ISellItemDao sellItemDao;

	@Transactional
	@Override
	public String save(SellItem t) {
		String msg = "error";
		try {
				sellItemDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(SellItem t) {
		String msg = "error";
		try {
				sellItemDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(SellItem t) {
		String msg = "error";
		try {
				sellItemDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellItem> findAll() {
		List<SellItem> sellItemList = null;
		try {
			sellItemList = sellItemDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellItemList;
	}

	@Transactional(readOnly=true)
	@Override
	public SellItem findById(Integer k) {
		SellItem sellItem = null;
		try {
			sellItem = sellItemDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellItem;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellItem> findBySellId(int sellId) {
		// TODO Auto-generated method stub
		List<SellItem> sellItemList = null;
		try {
			sellItemList =  sellItemDao.findBySellId(sellId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellItemList;
	}

	@Transactional(readOnly=true)
	@Override
	public List<SellItem> findByGoodsId(int goodsId) {
		// TODO Auto-generated method stub
		List<SellItem> sellItemList = null;
		try {
			sellItemList =  sellItemDao.findByGoodsId(goodsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sellItemList;
	}

}
