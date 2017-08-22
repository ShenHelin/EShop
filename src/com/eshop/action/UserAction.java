package com.eshop.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserInfo;
import com.eshop.service.iservice.IUserInfoService;
import com.eshop.service.iservice.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<User>, RequestAware {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;	
	@Autowired
	@Qualifier("userInfoService")
	private IUserInfoService userInfoService;	
	
	private User user = new User();
	private String option;//
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	
	
	
	public String save() {
		
		String regTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		user.getUserInfo().setRegTime(regTime);
//		
//		System.out.println(user.getUsername());
//		System.out.println(user.getPassword());
//		System.out.println("-------------------");
//		System.out.println(user.getUserInfo().getName());
//		System.out.println(user.getUserInfo().getPhone());
//		System.out.println(user.getUserInfo().getRegTime());
//		System.out.println(user.getUserInfo().getSex());
//		System.out.println(user.getUserInfo().getEmail());
		
		UserInfo userInfo = new UserInfo(user.getUserInfo().getName(), user.getUserInfo().getSex(), user.getUserInfo().getPhone(), user.getUserInfo().getEmail(), user.getUserInfo().getRegTime());
		user.setUserInfo(userInfo);
		userInfo.setUser(user);
		if( userService.save(user).equals("success") && userInfoService.save(userInfo).equals("success")){
			
			return "registerSuccess";
		}
		return "error";
		
	}

	public String update() {
		return userService.update(user);
	}

	public String delete() {
		return userService.delete(user);
	}

	public String findAll() throws IOException {
		String msg = "error";
		List<User> userList = userService.findAll();
		if (userList != null && userList.size() > 0) {
			request.put("userListFromServer", userList);
			msg = "success";
		}
		for(int i = 0 ; i<userList.size() ; i++){
			System.out.println(userList.get(i).getUsername());
		}

		
		return msg;
	}

	public String findById() {
		String msg = "error";
		User p = userService.findById(user.getUserId());
		List<User> userList = null;
		if (p != null) {
			if ("update".equals(option)) {
				request.put("userFromServer", p);
				msg = "updatesuccess";
			} else {
				userList = new ArrayList<User>();
				userList.add(p);
				request.put("userListFromServer", userList);
				msg = "findByIdSuccess";
			}
		}
		request.put("userFromServer", p);
		return msg;
	}
	
	public String findByName(){
		String msg = "error";
		List<User> userList = userService.findByName(user.getUserInfo().getName());
		if(userList != null && userList.size()>0){
			request.put("userListFromServer", userList);
			msg = "success";
		}
		return msg;
	}
	
	public String login(){
		System.out.println("login method.............");
		String msg = "loginError";
		User user1 = userService.findByUP(user.getUsername(), user.getPassword());
		//System.out.println("user1Id === " + user1.getUserId()); 正确
		if(user1 != null ){
			request.put("userFromServer", user1);
			ActionContext.getContext().getSession().put("user", user1);
			msg = "loginSuccess";
		}
		return msg;
	}
	
	
	
//	public String findByPrice() {
//		String msg = "error";
//		List<User> userList = userService.findByPrice(user.getPrice(), user.getPrice()+100);
//		if(userList != null && userList.size()>0){
//			request.put("userListFromServer", userList);
//			msg = "success";
//		}
//		return msg;
//	}
	





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
