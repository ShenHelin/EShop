package com.eshop.dao.pojo;

import java.io.Serializable;

public class UserAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int addressId;
	private String addressName;
	private String addressText;
	private String addressCode;
	private String addressPhone;
	private String isDefault;
	private User user;
	public UserAddress(String addressName, String addressText, String addressCode, String addressPhone,
			String isDefault) {
		super();
		this.addressName = addressName;
		this.addressText = addressText;
		this.addressCode = addressCode;
		this.addressPhone = addressPhone;
		this.isDefault = isDefault;
	}
	public UserAddress() {
		super();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressText() {
		return addressText;
	}
	public void setAddressText(String addressText) {
		this.addressText = addressText;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getAddressPhone() {
		return addressPhone;
	}
	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserAddress [addressId=" + addressId + ", addressName=" + addressName + ", addressText=" + addressText
				+ ", addressCode=" + addressCode + ", addressPhone=" + addressPhone + ", isDefault=" + isDefault
				+ "]";
	}


	
	
	
	
}
