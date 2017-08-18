package com.eshop.dao.pojo;

public class ShoppingCart {
	private int shoppingCartId;
	private User user;
	private Goods goods;
	private int amount;
	public int getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ShoppingCart(int amount) {
		super();
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartId=" + shoppingCartId + ", user=" + user.getUsername() + ", goods=" + goods.getGoodsName() + ", amount="
				+ amount + "]";
	}
	
}
