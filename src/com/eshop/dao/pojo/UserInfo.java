package com.eshop.dao.pojo;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String regTime;
	private User user;
	public UserInfo() {
		super();
	}
	public UserInfo(String name, String sex, String phone, String email, String regTime) {
		super();
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.regTime = regTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", sex=" + sex + ", phone=" + phone + ", email="
				+ email + ", regTime=" + regTime + "]";
	}
	
	
}
