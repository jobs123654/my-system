package com.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.BaseEntity;
import com.entity.InsuranceExchange;
import com.entity.User;
import com.tool.HibernateSessionFactory;
import com.tool.MainLoad;
import com.tool.Tool;
public class BaseDao {
	protected static Session session;
	 protected static Transaction transaction;
	 
	 static{
		 session=MainLoad.getSession();
	 }
	 public static Boolean isAdd(BaseEntity baseEntity)
	 {
		try {
			 transaction=session.beginTransaction();
//				user.setUserPassword(Tool.encryptSHA(user.getUserPassword()));
				if(baseEntity instanceof User)
				{
					User user=(User)baseEntity;
					user.setUserPassword(Tool.encryptSHA(user.getUserPassword()));
					
				}if(baseEntity instanceof InsuranceExchange)
				{
					InsuranceExchange insuranceExchange=(InsuranceExchange)baseEntity;
					insuranceExchange.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					Tool.createExcel(insuranceExchange,true);
				}
				
				session.save(baseEntity);
				transaction.commit();
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		e.printStackTrace();
		}
		return false;
		
	 }
	 public static Boolean delete(BaseEntity baseEntity)
	 {
			try {
				if(baseEntity instanceof User)
		
				{
					
					UserDao.isDelete(baseEntity);
				}
				if(baseEntity instanceof InsuranceExchange)
				{
					InsuranceExchangeDao.isDelete(baseEntity);
				}
				
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			 e.printStackTrace();
			}
			return false;
	 }
	 public static Boolean isDelete(BaseEntity baseEntity)
	 {
		 try {
	         
				transaction=session.beginTransaction();	
				session.delete(baseEntity);
				transaction.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				transaction.rollback();
			 e.printStackTrace();
			}
		
		return false;
	 }
	 public static Boolean update(BaseEntity baseEntity)
	 {
			try {
				if(baseEntity instanceof User)
					
				{
					
					UserDao.isUpdate(baseEntity);
					
				}
				if(baseEntity instanceof InsuranceExchange)
				{
					InsuranceExchangeDao.isUpdate(baseEntity);
				}
				
			
			} catch (Exception e) {
				// TODO: handle exception
				
				e.printStackTrace();
				return false;
			}
			return true;
	 }
	 public static Boolean isUpdate(BaseEntity baseEntity)
	 {
		 try {
		       
					transaction=session.beginTransaction();
					session.saveOrUpdate(baseEntity);
					transaction.commit();
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					transaction.rollback();
				 e.printStackTrace();
				}
		return false;
	 }
	 public static List<?> getList(String entityName)
	 {
		 try {
			 return session.createQuery("from "+entityName).list();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return null;
		
	 }

}
