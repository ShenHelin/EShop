package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IAdminDao;
import com.eshop.dao.pojo.Admin;
import com.eshop.service.iservice.IAdminService;

@Service("adminService")
public class ServiceAdminImpl implements IAdminService{

	@Autowired
	@Qualifier("adminDao")
	private IAdminDao adminDao;

	@Transactional
	@Override
	public String save(Admin t) {
		String msg = "error";
		try {
				adminDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Admin t) {
		String msg = "error";
		try {
				adminDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Admin t) {
		String msg = "error";
		try {
				adminDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Admin> findAll() {
		List<Admin> AdminList = null;
		try {
			AdminList = adminDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AdminList;
	}

	@Transactional(readOnly=true)
	@Override
	public Admin findById(Integer k) {
		Admin Admin = null;
		try {
			Admin = adminDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Admin;
	}

	@Transactional(readOnly=true)
	@Override
	public Admin findByUserName(String username) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			admin =  adminDao.findByUserName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	
}
