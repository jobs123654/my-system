package com.tool;

import java.util.TimerTask;

import javax.enterprise.inject.New;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.swing.Timer;

import org.apache.struts2.ServletActionContext;
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
		System.out.println("start to load...---------------- ");
		

		Session=HibernateSessionFactory.getSession();
		
		
		Transaction transaction=null;
		try {
			transaction=Session.beginTransaction();
			User user=new User();
			user.setUseNumber("root");
			user.setUserPassword(Tool.encryptSHA("root"));
			user.setRole(1);
			Session.save(user);
			

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		
		
	}
   
}
