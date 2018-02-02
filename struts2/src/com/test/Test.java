package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;
import com.tool.HibernateSessionFactory;

public class Test {
   public static void main(String[]a)
   {
	   Session session=HibernateSessionFactory.getSession();
//		  Transaction transaction=session.beginTransaction();
//        User user=new User();
//		  
//		  user.setName("122");
//		  user.setPwd("122");
//		  
//		  session.save(user);
//		  
//		  transaction.commit();
		  
//		 List list=new ArrayList();
//		 Query query=session.createQuery("from User where name=:name");
//		 
//		 query.setString("name","122");
//		
//		 list=query.list();
//		 
//		 System.out.print("----"+list.size());
		 
		  
   }
}
