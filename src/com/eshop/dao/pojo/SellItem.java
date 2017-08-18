package com.eshop.dao.pojo;

import java.io.Serializable;

public class SellItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int sellItemId;
	private SellInfo sellInfo;
	private Goods goods;
	private int amount;
	public SellItem(int amount) {
		super();
		this.amount = amount;
	}
	public int getSellItemId() {
		return sellItemId;
	}
	public void setSellItemId(int sellItemId) {
		this.sellItemId = sellItemId;
	}
	public SellInfo getSellInfo() {
		return sellInfo;
	}
	public void setSellInfo(SellInfo sellInfo) {
		this.sellInfo = sellInfo;
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
	public SellItem() {
		super();
	}
	@Override
	public String toString() {
		return "SellItem [sellItemId=" + sellItemId + ", sellInfo=" + sellInfo + ", goods=" + goods + ", amount="
				+ amount + "]";
	}
	
	

}
