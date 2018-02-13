package com.tool;

import javax.enterprise.inject.New;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.InsuranceExchange;
import com.entity.User;
/*服务器启动自动加载*/
public class MainLoad implements ServletContextListener{

	private static Session Session=null;
	
	
	
	public static Session getSession() {
		return Session;
	}
	
	

	public static void setSession(Session session) {
		Session = session;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("start to load... ");
		Session=HibernateSessionFactory.getSession();
		
		
		Transaction transaction=null;
		try {
			transaction=Session.beginTransaction();
			User user=new User();
			user.setUseNumber("root");
			user.setUserPassword(Tool.encryptSHA("root"));
			user.setUseNumber("123");
			Session.save(user);
			
//			InsuranceExchange i1=new InsuranceExchange();
//			i1.setOrderName("one1");
//			InsuranceExchange i2=new InsuranceExchange();
//			i2.setOrderName("one2");
//			InsuranceExchange i3=new InsuranceExchange();
//			i3.setOrderName("one3");
//			InsuranceExchange i4=new InsuranceExchange();
//			i4.setOrderName("one4");
//			InsuranceExchange i5=new InsuranceExchange();
//			i5.setOrderName("one5");
//			InsuranceExchange i6=new InsuranceExchange();
//			i6.setOrderName("one6");
//			Session.save(i1);			Session.save(i2);
//			Session.save(i3);			Session.save(i4);
//			Session.save(i5);			Session.save(i6);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		
	}
   
}
