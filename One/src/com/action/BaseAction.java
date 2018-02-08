package com.action;

import javax.servlet.http.HttpServletResponse;

import com.entity.BaseEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.Tool;
import com.dao.BaseDao;
public class BaseAction  extends ActionSupport{
	/**
	 * http://localhost:8080/safe/udeleteEmployee?user.useNumber=1
	 */
	private static final long serialVersionUID = 1L;
	protected static HttpServletResponse response;
   

	static{
		 response=Tool.getHttpServletResponse();
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
    				response.getOutputStream().write(("1").getBytes());	
    			}else{
    				response.getOutputStream().write(("0").getBytes());
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
				response.getOutputStream().write(("1").getBytes());	
			}else{
				response.getOutputStream().write(("0").getBytes());
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
				response.getOutputStream().write(("1").getBytes());	
			}else{
				response.getOutputStream().write(("0").getBytes());
			}
			 	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
	
		return NONE;
	}
	
}
