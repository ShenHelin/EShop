package com.eshop.dao.idao;

import java.util.List;

import com.eshop.dao.pojo.Account;

public interface IAccountDao extends IBaseDao<Account, Integer> {
	
	//根据   账户名称accountName进行查询
	Account findByAccountName(String accountName) throws Exception;
	//根据 userId进行查询
	List<Account> findByUserId(int userId) throws Exception;
	
	
	
}

