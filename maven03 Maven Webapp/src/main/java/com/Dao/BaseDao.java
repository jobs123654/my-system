package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.Entity.BaseEntity;

public class BaseDao {
	@Autowired
  private BaseEntity baseEntity;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	 {
		 return sessionFactory.openSession();
	 }
  public void add(BaseEntity baseEntity)
  {
	  Transaction transaction=getSession().beginTransaction();
	  
	  getSession().save(baseEntity);
	  
	  transaction.commit();
	  
	  getSession().close();
  }
  public void update(BaseEntity baseEntity)
  {
	  
  }
  public void delete(BaseEntity baseEntity)
  {
      Transaction transaction=getSession().beginTransaction();
	  getSession().delete(baseEntity); 
	  transaction.commit();
	  getSession().close();
  }
  public List<BaseEntity> findAll(String  name)
  {
	  return getSession().createQuery("from"+name).list();
  }
  
}
