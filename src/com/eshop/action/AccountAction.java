package com.eshop.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Account;
import com.eshop.service.iservice.IAccountService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("accountAciont")
public class AccountAction implements ModelDriven<Account>, RequestAware{
	
	@Autowired
	@Qualifier("accountService")
	private IAccountService accountService;	
	private Account account = new Account();
	
	
	@Override
	public Account getModel() {
		// TODO Auto-generated method stub
		return account;
	}
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	private String option;
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	
	public String save() {
		return accountService.save(account);
	}

	public String update() {
		return accountService.update(account);
	}

	public String delete() {
		return accountService.delete(account);
	}

	public String findAll() {
		String msg = "error";
		List<Account> accountList = accountService.findAll();
		if (accountList != null && accountList.size() > 0) {
			request.put("accountListFromServer", accountList);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Account a = accountService.findById(account.getAccountId());
		if (a != null) {
			if ("update".equals(option)) {
				request.put("accountFromServer", a);
				msg = "updatesuccess";
			} else {
				List<Account> accountList = new ArrayList<Account>();
				accountList.add(a);
				request.put("accountListFromServer", accountList);
				msg = "success";
			}
		}
		return msg;
	}
	//根据 userId进行查询
	//List<Account> findByUserId(int userId) throws Exception;
	public String findByAccountName() {
		String msg = "error";
		Account a = accountService.findByAccountName(account.getAccountName());
		if (a != null) {
			List<Account> accountList = new ArrayList<Account>();
			accountList.add(a);
			request.put("accountListFromServer", accountList);
			msg = "success";
		}
		return msg;
	}
	public String findByUserId() {
		String msg = "error";
		Account a = (Account) accountService.findByUserId(account.getUser().getUserId());
		if (a != null) {
			List<Account> accountList = new ArrayList<Account>();
			accountList.add(a);
			request.put("accountListFromServer", accountList);
			msg = "success";
		}
		return msg;
	}
	
	
	
}
