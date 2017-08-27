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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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

@Controller
@RequestMapping("shoppingCart")
@Scope("prototype")
public class ShoppingCartAction {
	
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
	
	
	

	

	@RequestMapping(value="/{userId}&{goodsId}",method=RequestMethod.POST)
	public String save(@PathVariable("userId") Integer userId,@PathVariable("goodsId") Integer goodsId,Map<String,Object> map) {
		
//		User user1 = (User) ActionContext.getContext().getSession().get("user");
//		System.out.println(user1);
//		UserAddress userAddress = new UserAddress("yulei", "DALIAN-QIANFENG", "150030", "13366666666", "1");
//		userAddress.setUser(user1);
//		
//		userAddressService.save(userAddress);
		
		
		String msg = "error";
		
		System.out.println("userId in action === " + userId);
		User user = userService.findById(userId);
		Goods goods = goodsService.findById(goodsId);
		ShoppingCart shoppingCart1 = new ShoppingCart(1);
		shoppingCart1.setUser(user);
		shoppingCart1.setGoods(goods);
		System.out.println("user in action === " + user);
		shoppingCart1.setGoods(goods);
		
		msg = shoppingCartService.save(shoppingCart1);
		return "success".equals(msg)?"redirect:/goods/findAll":"error";
		
		
		
	}

	@RequestMapping(value="/{}",method=RequestMethod.PUT)
	public String update(@ModelAttribute ShoppingCart shoppingCart) {
		String msg = "error";
		msg = shoppingCartService.update(shoppingCart);
		return "success".equals(msg)?"redirect:/goods/findAll":"error";
	}

	@RequestMapping(value="delete/{shoppingCartId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("shoppingCartId") Integer shoppingCartId) {
		String msg = "error";
		ShoppingCart shoppingCart = shoppingCartService.findById(shoppingCartId);
		msg = shoppingCartService.delete(shoppingCart);
		HttpSession session = getSession();
		User user = (User) session.getAttribute("user");
		return "deleteSuccess".equals(msg)?"redirect:/shoppingCart/findByUserId/"+user.getUserId():"error";
	}

	@RequestMapping("findAll")
	public String findAll(@ModelAttribute Goods goods,Map<String,Object> map) throws IOException {
		String msg = "error";
		List<ShoppingCart> shoppingCartList = shoppingCartService.findAll();
		if (shoppingCartList != null && shoppingCartList.size() > 0) {
			map.put("shoppingCartListFromServer", shoppingCartList);
			msg = "success";
		}
		
		return "success".equals(msg)?"redirect:/goods/findAll":"error";
	}

	@RequestMapping(value="findById/{shoppingCartId}",method=RequestMethod.GET)
	public String findById(@PathVariable("shoppingCartId") Integer shoppingCartId,Map<String,Object> map) {
		String msg = "error";
		ShoppingCart p = shoppingCartService.findById(shoppingCartId);
		List<ShoppingCart> shoppingCartList = null;
		if (p != null) {
			if ("update".equals(option)) {
				map.put("shoppingCartFromServer", p);
				msg = "updateSuccess";
			} else {
				shoppingCartList = new ArrayList<ShoppingCart>();
				shoppingCartList.add(p);
				map.put("shoppingCartListFromServer", shoppingCartList);
				msg = "findByIdSuccess";
			}
		}
		map.put("shoppingCartFromServer", p);
		
		return "findByIdSuccess".equals(msg)?"redirect:/shoppingCart/findByUserId":"error";
	}
	
	@RequestMapping(value="findByUserId/{userId}",method=RequestMethod.GET)
	public String findByUserId(@PathVariable("userId") Integer userId,Map<String,Object> map){
		String msg = "error";
		
/*		HttpSession session = getSession();
		User user3 = (User) session.getAttribute("user");*/
		
//		List<ShoppingCart> shoppingCartList = shoppingCartService.findByUserId(shoppingCart.getUser().getUserId());
		List<ShoppingCart> shoppingCartList = shoppingCartService.findByUserId(userId);
		if(shoppingCartList != null && shoppingCartList.size()>0){
			map.put("shoppingCartListFromServer", shoppingCartList);
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
		
		return "shoppingCart";
	}
	
	private String chkItem;
	public String getChkItem() {
		return chkItem;
	}
	public void setChkItem(String chkItem) {
		this.chkItem = chkItem;
	}
	
	@RequestMapping(value="buySome", method = RequestMethod.DELETE)
	public String buySome(@RequestParam("chkItem") String[] chkValues,@ModelAttribute ShoppingCart shoppingCart,Map<String,Object> map) {
		String msg = "error";
		
		double totalPrice = 0;
		//String[] chkValues = this.getChkItem().split(", ");
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
		HttpSession session = getSession();
		User user1 = (User) session.getAttribute("user");
		//User user1 = (User) ActionContext.getContext().getSession().get("user");
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
            
            msg = "deleteSuccess";
        }
		
		
		
		//插入sellInfo
		
		
		return "deleteSuccess".equals(msg)?"redirect:/shoppingCart/findByUserId/"+user1.getUserId():"error";
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
}




