package com.eshop.service.iservice;

import java.util.List;

import com.eshop.dao.pojo.Account;

public interface IAccountService extends IBaseService<Account, Integer> {
	
	//根据   账户名称accountName进行查询
	Account findByAccountName(String accountName) ;
	//根据 userId进行查询
	List<Account> findByUserId(int userId) ;
	
	
	
}

