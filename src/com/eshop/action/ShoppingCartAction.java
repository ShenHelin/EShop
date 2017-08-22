package com.eshop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.ShoppingCart;
import com.eshop.dao.pojo.User;
import com.eshop.service.iservice.IGoodsService;
import com.eshop.service.iservice.IShoppingCartService;
import com.eshop.service.iservice.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("shoppingCartAction")
@Scope("prototype")
public class ShoppingCartAction implements ModelDriven<ShoppingCart>, RequestAware{
	
	@Autowired
	@Qualifier("shoppingCartService")
	private IShoppingCartService shoppingCartService;	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;	
	@Autowired
	@Qualifier("goodsService")
	private IGoodsService goodsService;	
	
	private String option;
	
	private ShoppingCart shoppingCart = new ShoppingCart();
	
	

	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	@Override
	public ShoppingCart getModel() {
		// TODO Auto-generated method stub
		return shoppingCart;
	}
	
	
	public String save() {
		System.out.println("userId in action === " + shoppingCart.getUser().getUserId());
		User user = userService.findById(shoppingCart.getUser().getUserId());
		Goods goods = goodsService.findById(shoppingCart.getGoods().getGoodsId());
		ShoppingCart shoppingCart = new ShoppingCart(1);
		shoppingCart.setUser(user);
		shoppingCart.setGoods(goods);
		System.out.println("user in action === " + user);
		shoppingCart.setGoods(goods);
		return shoppingCartService.save(shoppingCart);
		
	}

	public String update() {
		
		return shoppingCartService.update(shoppingCart);
	}

	public String delete() {
		
		return shoppingCartService.delete(shoppingCart);
	}

	public String findAll() throws IOException {
		String msg = "error";
		List<ShoppingCart> shoppingCartList = shoppingCartService.findAll();
		if (shoppingCartList != null && shoppingCartList.size() > 0) {
			request.put("shoppingCartListFromServer", shoppingCartList);
			msg = "success";
		}
		
		return msg;
	}

	public String findById() {
		String msg = "error";
		ShoppingCart p = shoppingCartService.findById(shoppingCart.getShoppingCartId());
		List<ShoppingCart> shoppingCartList = null;
		if (p != null) {
			if ("update".equals(option)) {
				request.put("shoppingCartFromServer", p);
				msg = "updatesuccess";
			} else {
				shoppingCartList = new ArrayList<ShoppingCart>();
				shoppingCartList.add(p);
				request.put("shoppingCartListFromServer", shoppingCartList);
				msg = "findByIdSuccess";
			}
		}
		request.put("shoppingCartFromServer", p);
		return msg;
	}
	
	
	
	public String findByUserId(){
		String msg = "findByUserIdError";
		User user3 = (User) ActionContext.getContext().getSession().get("user");
//		List<ShoppingCart> shoppingCartList = shoppingCartService.findByUserId(shoppingCart.getUser().getUserId());
		List<ShoppingCart> shoppingCartList = shoppingCartService.findByUserId(user3.getUserId());
		if(shoppingCartList != null && shoppingCartList.size()>0){
			request.put("shoppingCartListFromServer", shoppingCartList);
			msg = "findByUserIdSuccess";
		}
		for(ShoppingCart s:shoppingCartList){
			//System.out.println(s.getUser().getUserId());
			//System.out.println(s.getGoods().getGoodsId());
			User user2 = userService.findById(s.getUser().getUserId());
			Goods goods2 = goodsService.findById(s.getGoods().getGoodsId());
			s.setUser(user2);
			s.setGoods(goods2);
		}
		System.out.println("shoppingCartList in action ========= "+shoppingCartList);
		return msg;
	}
	
	private String chkItem;
	public String getChkItem() {
		return chkItem;
	}
	public void setChkItem(String chkItem) {
		this.chkItem = chkItem;
	}
	public String deleteSome() {
		String[] chkValues = this.getChkItem().split(", ");
		for(int i = 0; i < chkValues.length; i++){  
                System.out.println(chkValues[i]);  
                shoppingCart.setShoppingCartId(Integer.parseInt(chkValues[i]));
                shoppingCartService.delete(shoppingCart);
        }  
		//return shoppingCartService.delete(shoppingCart);
		return "deleteSuccess";
	}
	
	
	
}



