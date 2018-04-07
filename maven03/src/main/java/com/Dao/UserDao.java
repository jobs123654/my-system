package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.User;
@Transactional

public class UserDao extends BaseDao{
	
   public UserDao()
   {
//	   HibernateTransactionManager
	}
   public List<User> findAll()
   {
//	   return getSession().createQuery("from User").list();
	   return null;
   }
   public void add(User user)
   {
	   
	   /*Session session=getSession();
	   Transaction transaction=session.beginTransaction();
	   session.save(user);
	   transaction.commit();
	   session.close();*/
	   save(user);
	   
   }
   public void delete(User user)
   {
	   
	   /*Session session=getSession();
	   User user1=(User) session.get(User.class, user.getId());
	   Transaction transaction=session.beginTransaction();
	   session.delete(user1);
	   transaction.commit();
	   session.close();
	   */
	   delete(user);
	   
   }
   public void update(User user)
   {
	  
	   
   }
}
