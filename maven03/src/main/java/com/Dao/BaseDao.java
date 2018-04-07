package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import com.Entity.BaseEntity;
import com.Entity.User;
@Component("dao") 
public class BaseDao<T>{
	@Autowired
   private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	private Session getSession(){
	
		return sessionFactory.openSession();
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private BaseEntity baseEntity;
	
 
	
// HibernateDaoSupport
public void save(BaseEntity baseEntity)
  {
	  Session s=getSession();
	  Transaction transaction=s.beginTransaction();
	  System.out.println(baseEntity.getClass());
	  s.save(baseEntity);
	  
      transaction.commit();
	  
	 s.close();
  }
  public void update(BaseEntity baseEntity)
  {
	  Session s=getSession();
	  Transaction transaction=s.beginTransaction();
	  System.out.println(baseEntity.getClass());
	  s.saveOrUpdate(baseEntity);
      transaction.commit();
	 s.close();
  }
  public void delete(BaseEntity baseEntity)
  {
	  Session s=getSession();
	  Transaction transaction=s.beginTransaction();
	  s.delete(baseEntity);
      transaction.commit();
	  
	 s.close();
  }
  public List<?> findAll(String  name)
  {
  return getSession().createQuery("from  "+name).list();
  }
  
  public BaseEntity getBaseEntity(User user)
  {
	  baseEntity=user;
	  return getSession().get(baseEntity.getClass(), user.getId());
  }
/**
 * @return the baseEntity
 */
public BaseEntity getBaseEntity() {
	return baseEntity;
}
/**
 * @param baseEntity the baseEntity to set
 */
public void setBaseEntity(BaseEntity baseEntity) {
	this.baseEntity = baseEntity;
}
  
}
