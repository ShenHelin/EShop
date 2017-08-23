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

import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.dao.pojo.OrderItem;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.dao.pojo.ShoppingCart;
import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserAddress;
import com.eshop.service.iservice.IGoodsService;
import com.eshop.service.iservice.IOrderInfoService;
import com.eshop.service.iservice.IOrderItemService;
import com.eshop.service.iservice.IOrderStatusService;
import com.eshop.service.iservice.IShoppingCartService;
import com.eshop.service.iservice.IUserAddressService;
import com.eshop.service.iservice.IUserService;
import com.opensymphony.xwork2.ActionContext;
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
	@Autowired
	@Qualifier("orderInfoService")
	private IOrderInfoService orderInfoService;	
	@Autowired
	@Qualifier("orderItemService")
	private IOrderItemService orderItemService;	
	@Autowired
	@Qualifier("orderStatusService")
	private IOrderStatusService orderStatusService;	
	@Autowired
	@Qualifier("userAddressService")
	private IUserAddressService userAddressService;	
	
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
		
		
		
//		User user1 = (User) ActionContext.getContext().getSession().get("user");
//		System.out.println(user1);
//		UserAddress userAddress = new UserAddress("yulei", "DALIAN-QIANFENG", "150030", "13366666666", "1");
//		userAddress.setUser(user1);
//		
//		userAddressService.save(userAddress);
		
		
		
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
	public String buySome() {
		
		double totalPrice = 0;
		String[] chkValues = this.getChkItem().split(", ");
		for(int i = 0; i < chkValues.length; i++){  
            System.out.println(chkValues[i]);  
            shoppingCart = shoppingCartService.findById(Integer.parseInt(chkValues[i]));
            Goods goods = goodsService.findById(shoppingCart.getGoods().getGoodsId());
            totalPrice = totalPrice + goods.getPrice()*shoppingCart.getAmount();
        }
		

		
		//插入orderInfo
		String userAddressStr = "";
		String userAddressCode = "";
		String orderPhone = "";
		User user1 = (User) ActionContext.getContext().getSession().get("user");
		User user = userService.findById(user1.getUserId());
		System.out.println(user.getUserAddressSet());
		for(UserAddress userAddress:user.getUserAddressSet()){
			if(userAddress.getIsDefault().equals("1")){
				userAddressStr = userAddress.getAddressName();
				userAddressCode = userAddress.getAddressCode();
				orderPhone = userAddress.getAddressPhone();
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String submitTime = sdf.format(new Date());
		
		OrderStatus orderStatus = new OrderStatus("1", "1");
		
		
		OrderInfo orderInfo = new OrderInfo("1001", submitTime, user.getUsername(), userAddressStr, userAddressCode, orderPhone, 0);
		orderInfo.setUser(user);
		orderInfo.setOrderStatus(orderStatus);
		orderInfo.setTotalPrice(totalPrice);
		orderStatus.setOrderInfo(orderInfo);
		orderInfo.setOrderStatus(orderStatus);
		orderInfoService.save(orderInfo);
		orderStatusService.save(orderStatus);
		
		
		
		
		
		
		//double totalPrice = 0;
		//String[] chkValues = this.getChkItem().split(", ");
		for(int i = 0; i < chkValues.length; i++){  
            System.out.println(chkValues[i]);  
            //shoppingCart.setShoppingCartId(Integer.parseInt(chkValues[i]));
            shoppingCart = shoppingCartService.findById(Integer.parseInt(chkValues[i]));
            shoppingCartService.delete(shoppingCart);
            
            Goods goods = goodsService.findById(shoppingCart.getGoods().getGoodsId());
            goods.setLeaveNum(goods.getLeaveNum()-shoppingCart.getAmount());
            goodsService.update(goods);
            //totalPrice = totalPrice + goods.getPrice()*shoppingCart.getAmount();
            
            OrderItem orderItem = new OrderItem(shoppingCart.getAmount(), goods.getPrice()*shoppingCart.getAmount());
            orderItem.setGoods(goods);
            orderItem.setOrderInfo(orderInfo);
            orderItemService.save(orderItem);
        }
		
		
		
		//插入sellInfo
		
		
		
		return "deleteSuccess";
	}
	
	
	
}




