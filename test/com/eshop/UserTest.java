package com.eshop;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.dao.pojo.Admin;
import com.eshop.dao.pojo.Goods;
import com.eshop.dao.pojo.GoodsClass;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.dao.pojo.SellInfo;
import com.eshop.dao.pojo.SellItem;
import com.eshop.dao.pojo.ShoppingCart;
import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserInfo;

public class UserTest {

	
	private ApplicationContext ctx;
	DataSource dataSource;
	SessionFactory sessionFactory;
	Session session;
	Transaction trans;
	
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource = (DataSource) ctx.getBean("dataSource");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.getCurrentSession();
		trans = session.beginTransaction();
		
	}

	@After
	public void tearDown() throws Exception {
		
		trans.commit();
	}
	
	@Test
	public void testSessionFactory(){
		System.out.println(dataSource);
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testInsertUser(){
		User user = new User("xiaoming", "123456");
		UserInfo userInfo = new UserInfo("nnn", "M", "16666666", "666@163.com", "1");
		userInfo.setUser(user);
		user.setUserInfo(userInfo);
		
		session.save(user);
		session.save(userInfo);
		
		
	}
	
	@Test
	public void testInsertGoods(){
		Goods goods = new Goods("MILK", "milk.......", 6.6, 9, 7, "", "");
		session.save(goods);
	}
	
	@Test
	public void testUserStringString() {
		Admin admin = new Admin("admin", "123456", 0);
		session.save(admin);
		GoodsClass goodsClass = new GoodsClass("FOOD", "1001", "0");
		session.save(goodsClass);
		Goods goods = new Goods("milk", "牛奶...", 4.0, 10, 9, "", "");
		goods.setAdmin(admin);
		goods.setGoodsClass(goodsClass);
		session.save(goods);
	}
	
	@Test
	public void testQuery(){
		Admin admin = (Admin) session.get(Admin.class, 1);
		for(Goods goods:admin.getGoodsSet()){
			System.out.println(goods);
		}
		
		GoodsClass goodsClass = (GoodsClass) session.get(GoodsClass.class, 1);
		for(Goods goods:goodsClass.getGoodsSet()){
			System.out.println(goods);
		}
		
	}
	
	@Test
	public void insertSellInfo(){
		
		//Admin admin = new Admin("admin", "123456", 0);
		Admin admin = (Admin) session.get(Admin.class, 1);
		System.out.println(admin);
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		SellInfo sellInfo = new SellInfo("1001", "2017-01-01", 99.9, admin, user);
		session.save(sellInfo);

	}
	
	@Test
	public void testQueryOfSellInfo(){
		
		Admin admin = (Admin) session.get(Admin.class, 1);
		System.out.println(admin);
		for(SellInfo sellInfo:admin.getSellInfoSet()){
			System.out.println(sellInfo);
		}
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
		for(SellInfo sellInfo:user.getSellInfoSet()){
			System.out.println(sellInfo);
		}
	}
	
	@Test
	public void insertSellItem(){
		
		Goods goods = (Goods) session.get(Goods.class, 1);
		SellInfo sellInfo = (SellInfo) session.get(SellInfo.class, 1);
		SellItem sellItem = new SellItem(10);
		sellItem.setGoods(goods);
		sellItem.setSellInfo(sellInfo);
		
		session.save(sellItem);
		
	}
	
	@Test
	public void insertShoppingCart(){
		
		ShoppingCart shoppingCart = new ShoppingCart(3);
		User user = (User) session.get(User.class, 1);
		shoppingCart.setUser(user);
		System.out.println(user);
		Goods goods = (Goods) session.get(Goods.class, 1);
		shoppingCart.setGoods(goods);
		System.out.println(goods);
		session.save(shoppingCart);
		
	}
	
	@Test
	public void insertOrderInfo(){
		OrderInfo orderInfo = new OrderInfo("1002", "", "hi", "dalianshi", "150030", "13333333333", 99.9);
		User user = (User) session.get(User.class, 1);
		orderInfo.setUser(user);
		OrderStatus orderStatus = new OrderStatus("0", "1");
		orderInfo.setOrderStatus(orderStatus);
		orderStatus.setOrderInfo(orderInfo);
		
		session.save(orderInfo);
		session.save(orderStatus);
	}
	
	@Test
	public void insertOrderStatus(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}






















