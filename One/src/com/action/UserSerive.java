package com.action;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.Counter;
import org.springframework.http.HttpRequest;

import com.dao.UserDao;
import com.entity.InsuranceExchange;
import com.entity.User;
import com.tool.MainLoad;
import com.tool.Tool;

import antlr.collections.List;
import net.sf.json.JSONObject;


public class UserSerive extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String mysql_home;
	private String mysqlPath;//数据库备份 --用户mysql地址接入
	
	private String m_user;
	
	private String m_pwd;
	
	private String m_db;
	
	

	public String getM_user() {
		return m_user;
	}
	public void setM_user(String m_user) {
		this.m_user = m_user;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_db() {
		return m_db;
	}
	public void setM_db(String m_db) {
		this.m_db = m_db;
	}
	public String getMysqlPath() {
		return mysqlPath;
	}
	public void setMysqlPath(String mysqlPath) {
		this.mysqlPath = mysqlPath;
	}

	private java.util.List<User> list;
	
	public java.util.List<User> getList() {
		return list;
	}
	public void setList(java.util.List<User> list) {
		this.list = list;
	}

	private User user;
	
    public User getUser() {
		return user;
   
    }
   
	public void setUser(User user) {
		this.user = user;
	}
	/*
     *登录 
     * 
    */	
	public String login()
    {
		System.out.println("--------------"+ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"db\\");
		HttpServletRequest request=Tool.getHttpServletRequest();
	   
		String path=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"db\\db.sql";
		
//		Tool.startDbback("D:/phpStudy2016/MySQL", "10.128.121.109", "safe", "root", "wdy123654", path);
		File file=new File(path);
		if(!file.exists())
		{
			return "config";
		}
		
		String r=request.getParameter("user.isRemember");
	
	
			if(UserDao.getUser(user)!=null)
			{
				User u=UserDao.getUser(user);
				Cookie number=new Cookie("number", user.getUseNumber());
				Cookie password=new Cookie("password", user.getUserPassword());
//				登录成功
				if(r!=null)
				{
					
					number.setMaxAge(60*60*24*365);
					password.setMaxAge(60*60*24*365);
					
					Tool.getHttpServletResponse().addCookie(number);
					Tool.getHttpServletResponse().addCookie(password);
				}else {
					
					number.setMaxAge(0);
					password.setMaxAge(0);
				}
				
			   Tool.getHttpSession().setAttribute("user", u);
				return LOGIN;
				
			}else{
//				登陆失败
               return ERROR;
			}
    }
	//更新配置
	 public String config()
    {
		 
		 if(mysqlPath!=null)
		 {
			    String path=ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"db\\db.sql";
				
			    mysql_home=mysqlPath;
			   
			    mysqlPath=mysqlPath.replace('\\', '/');
			    
				Tool.startDbback(mysqlPath, "10.128.121.109", m_db, m_user, m_pwd, path); 
				
				return SUCCESS;
		 }
		 return "config";
    	 
    }
	 //数据恢复
	 public String config1() 
	 {
		 HttpServletResponse response=Tool.getHttpServletResponse();
		 System.out.println("--------------------------||>");
		 if(m_user!=null&&m_pwd!=null&&m_db!=null)
		 {
			 System.out.println("--------------------------||<");
			try {
				 Tool.recoverDb(mysqlPath,"10.128.121.109", m_db, m_user, m_pwd, ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"db\\db.sql"); 
		      return SUCCESS;
			} catch (Exception e) {
				return "config1";
				// TODO: handle exception
			}	 
		 }else{
			    return "config1";
		 }
		 
		
		
	 }
	public String manage()
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null)
		{
			return "manage";
		}
		
		return "error";
		
	}
	/*注册
	 * 
	 * */
    public String register()
    {
    	
    	baseEntity=user;
    	super.add();
    	return userList();
    }
   /* 员工清单*/
    public String userList()
    {
    	list=UserDao.getList();
    	return "list";
    }
//    删除用户
   public String deleteEmployee()
   {
	
	   baseEntity=user;
	    super.delete();
	    return userList();
   }
//   更新信息
   public String updateInfo()
   {
	   if((Object)user.getId()!=null&&user.getUseNumber()==null)
	   {
		   user=UserDao.getUser(user.getId());
		   return "update";
	   }
	   baseEntity=user;
	   System.out.println(user);
	 super.update();
	   return userList();
   }
   
  
	
//   退出
   public String logout()
   {
	  Tool.getHttpSession().removeAttribute("user");
	   
	   return "error";
   }
}

