package com.eshop.dao.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String username;
	private String password;
	private UserInfo userInfo;
	
	private Set<UserAddress> userAddressSet = new HashSet<UserAddress>();//Set 1:n UserAddress 1
	private Set<Account> accountSet = new HashSet<Account>();
	private Set<SellInfo> sellInfoSet = new HashSet<SellInfo>();
	private Set<ShoppingCart> shoppingCartSet = new HashSet<ShoppingCart>();
	private Set<Comment> commentSet = new HashSet<Comment>();
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public Set<UserAddress> getUserAddressSet() {
		return userAddressSet;
	}
	public void setUserAddressSet(Set<UserAddress> userAddressSet) {
		this.userAddressSet = userAddressSet;
	}
	
	public Set<Account> getAccountSet() {
		return accountSet;
	}
	public void setAccountSet(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}
	
	public Set<SellInfo> getSellInfoSet() {
		return sellInfoSet;
	}
	public void setSellInfoSet(Set<SellInfo> sellInfoSet) {
		this.sellInfoSet = sellInfoSet;
	}
	
	public Set<ShoppingCart> getShoppingCartSet() {
		return shoppingCartSet;
	}
	public void setShoppingCartSet(Set<ShoppingCart> shoppingCartSet) {
		this.shoppingCartSet = shoppingCartSet;
	}
	
	public Set<Comment> getCommentSet() {
		return commentSet;
	}
	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userInfo=" + userInfo
				+  "]";
	}
	
	
	
	
	
	

	
	

}
