package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.Entity.User;
@Transactional
public class UserDao {
	
   /**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	 private Session getSession()
	 {
		 return sessionFactory.openSession();
	 }
	
   @Autowired
   private SessionFactory sessionFactory;
   
   
   public UserDao()
   {
//	   HibernateTransactionManager
	}
   public List<User> findAll()
   {
	   return getSession().createQuery("from User").list();
   }
   public void add(User user)
   {
	   
	   Session session=getSession();
	   Transaction transaction=session.beginTransaction();
	   session.save(user);
	   transaction.commit();
	   session.close();
	   
   }
   public void delete(User user)
   {
	   
	   Session session=getSession();
	   User user1=(User) session.get(User.class, user.getId());
	   Transaction transaction=session.beginTransaction();
	   session.delete(user1);
	   transaction.commit();
	   session.close();
	   
   }
   public void update(User user)
   {
	  
	   
   }
}
