package com.eshop.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserAddress;
import com.eshop.dao.pojo.UserInfo;
import com.eshop.service.iservice.IUserAddressService;
import com.eshop.service.iservice.IUserInfoService;
import com.eshop.service.iservice.IUserService;

@Controller
@RequestMapping("user")
public class UserAction {
	@Autowired
	@Qualifier("userService")
	private IUserService userService;	
	@Autowired
	@Qualifier("userInfoService")
	private IUserInfoService userInfoService;
	@Autowired
	@Qualifier("userAddressService")
	private IUserAddressService userAddressService;	
	
	private String option;//
	
	
	
	@RequestMapping("save")
	public String save(@ModelAttribute User user) {
		String msg = "error";
		String regTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		user.getUserInfo().setRegTime(regTime);
		
		UserInfo userInfo = new UserInfo(user.getUserInfo().getName(), user.getUserInfo().getSex(), user.getUserInfo().getPhone(), user.getUserInfo().getEmail(), user.getUserInfo().getRegTime());
		user.setUserInfo(userInfo);
		userInfo.setUser(user);
		
		if( userService.save(user).equals("success") && userInfoService.save(userInfo).equals("success")){
			UserAddress userAddress = new UserAddress("yulei", "DALIAN-QIANFENG", "150030", "13366666666", "1");
			userAddress.setUser(user);
			userAddressService.save(userAddress);
			msg= "registerSuccess";
		}
		return "registerSuccess".equals(msg)?"login":"error";
		
	}

	@RequestMapping("update")
	public String update(@ModelAttribute User user) {
		String msg = "error";
		if("success".equals(userService.update(user))){
			return "success";
		}
		return msg;
	}

	@RequestMapping("delete")
	public String delete(@ModelAttribute User user) {
		if("success".equals(userService.delete(user))){
			return "success";
		}
		return "error";
	}

	@RequestMapping("findAll")
	public String findAll(Map<String,Object> map) throws IOException {
		String msg = "error";
		List<User> userList = userService.findAll();
		if (userList != null && userList.size() > 0) {
			map.put("userListFromServer", userList);
			msg = "success";
			return "home_page";
		}
		return msg;
	}

	@RequestMapping("findById")
	public String findById(@ModelAttribute User user,Map<String,Object> map) {
		String msg = "error";
		User p = userService.findById(user.getUserId());
		List<User> userList = null;
		if (p != null) {
			if ("update".equals(option)) {
				map.put("userFromServer", p);
				msg = "updatesuccess";
			} else {
				userList = new ArrayList<User>();
				userList.add(p);
				map.put("userListFromServer", userList);
				msg = "findByIdSuccess";
			}
		}
		return msg;
	}
	
	@RequestMapping("findByName")
	public String findByName(@ModelAttribute User user,Map<String,Object> map){
		String msg = "error";
		List<User> userList = userService.findByName(user.getUserInfo().getName());
		if(userList != null && userList.size()>0){
			map.put("userListFromServer", userList);
			msg = "success";
		}
		return msg;
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@ModelAttribute User user,Map<String,Object> map){
		System.out.println("login method.............");
		User user1 = userService.findByUP(user.getUsername(), user.getPassword());
		//System.out.println("user1Id === " + user1.getUserId()); 正确
		if(user1 != null ){
			HttpSession session = getSession();
			map.put("userFromServer", user1);
			//ActionContext.getContext().getSession().put("user", user1);
			session.setAttribute("user", user1);
			System.out.println("登录成功！！！");
			return "redirect:/goods/findAll";
		}
		return "redirect:/user/login";
	}
	
	@RequestMapping("quit")
	public String quit(){
		return "login";
	}
	@RequestMapping("toRegister")
	public String toRegister(){
		return "register";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {} 
	        return session; 
	} 
	public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
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
