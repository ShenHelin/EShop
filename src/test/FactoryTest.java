package test;

import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.dao.pojo.Account;
import com.eshop.dao.pojo.OrderInfo;
import com.eshop.dao.pojo.OrderStatus;
import com.eshop.dao.pojo.User;
import com.eshop.dao.pojo.UserAddress;

public class FactoryTest {

	
	private ApplicationContext ctx;
	
	
	
		
	@Test
	public void testSessionFactory() throws Exception{
		
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		//System.out.println(dataSource);
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		//System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		//System.out.println(session);
		
//		//Data date = new Data();
//		UserInfo ui = new UserInfo("hahah", "M", "123", "123", "");
//		User user = new User("hhhh", "123");
//		user.setUserId(1);
//		user.setUserInfo(ui);
//		ui.setUser(user);
//		
//		Transaction transaction = session.beginTransaction();
//		session.save(user);
//		session.save(ui);
//		transaction.commit();
		
		User user = new User("hhhh", "123");
		user.setUserId(1);
		Transaction transaction = session.beginTransaction();
		UserAddress ad = new UserAddress("aaa", "aab", "123", "321", "0");
		ad.setUser(user);
		session.save(ad);
		transaction.commit();
		for(UserAddress userAddress:user.getUserAddressSet()){
			System.out.println(userAddress);
		}

		
	}
	
	@Test
	public void testQuery(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		User user = (User) session.get(User.class,1);
		transaction.commit();
		System.out.println("use: " + user);
		
		System.out.println("**************֮��ִ�е�select���Ϊ������  lazy=true******************");
//		Set<UserAddress> emps = user.getUserAddressSet();
//		for(UserAddress userAddress:emps){
//			System.out.println(userAddress);
//		}
		Set<Account> emps = user.getAccountSet();
		for(Account userAddress:emps){
			System.out.println(userAddress);
		}
		
	}
	
	@Test
	public void testInsertAccount(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		User user = new User("hhhh", "123");
		user.setUserId(1);
		Account account = new Account("ZXYH", 100000.0);
		account.setUser(user);
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();
		
	}
	

	
	
	
	
	
}





