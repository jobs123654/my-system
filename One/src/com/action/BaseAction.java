package com.action;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.entity.BaseEntity;
import com.entity.InsuranceExchange;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.HibernateSessionFactory;
import com.tool.Tool;
import com.dao.BaseDao;
public class BaseAction  extends ActionSupport{
	/**
	 * http://localhost:8080/safe/udeleteEmployee?user.useNumber=1
	 */
	private static final long serialVersionUID = 1L;
	
   
    private static Session session=HibernateSessionFactory.getSession();
    
	public static Session getSession() {
		return session;
	}
	public static void setSession(Session session) {
		BaseAction.session = session;
	}
	
	protected BaseEntity baseEntity;
	
	public BaseEntity getBaseEntity() {
		
		return baseEntity;
	}
	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
	public String add()
	{
		
    	
    		 try {
    			if(BaseDao.isAdd(baseEntity))
    			{
    			
    			}else{
    				
    			}
    			 	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		return NONE;
	}
	public String delete()
	{

		 try {
			if(BaseDao.delete(baseEntity))
			{
				
			}else{
				
			}
			 	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
	
		return NONE;
	}
	public String update()
	{

		 try {
			if(BaseDao.update(baseEntity))
			{
				
			}else{
				
			}
			 	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
	
		return NONE;
	}
	
}
