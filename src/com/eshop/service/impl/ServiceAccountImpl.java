package com.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eshop.dao.idao.IAccountDao;
import com.eshop.dao.pojo.Account;
import com.eshop.service.iservice.IAccountService;

@Service("accountService")
public class ServiceAccountImpl implements IAccountService{
	
	@Autowired
	@Qualifier("accountDao")
	private IAccountDao accountDao;

	@Transactional
	@Override
	public String save(Account t) {
		String msg = "error";
		try {
				accountDao.save(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String update(Account t) {
		String msg = "error";
		try {
				accountDao.update(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional
	@Override
	public String delete(Account t) {
		String msg = "error";
		try {
				accountDao.delete(t);
				msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findAll() {
		List<Account> AccountList = null;
		try {
			AccountList = accountDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AccountList;
	}

	@Transactional(readOnly=true)
	@Override
	public Account findById(Integer k) {
		Account Account = null;
		try {
			Account = accountDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Account;
	}

	@Transactional(readOnly=true)
	@Override
	public Account findByAccountName(String accountName) {
		// TODO Auto-generated method stub
		Account account = null;
		try {
			account =  accountDao.findByAccountName(accountName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

	@Transactional(readOnly=true)
	@Override
	public List<Account> findByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Account> accountList = null;
		try {
			accountList =  (List<Account>) accountDao.findById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountList;
	}

}






