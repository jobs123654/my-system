package com.action;



import java.io.IOException;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.util.Counter;
import org.springframework.http.HttpRequest;

import com.dao.UserDao;
import com.entity.User;
import com.tool.MainLoad;
import com.tool.Tool;


public class UserSerive extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		HttpServletRequest request=Tool.getHttpServletRequest();
		
		String r=request.getParameter("user.isRemember");
	
	
			if(UserDao.getUser(user)!=null)
			{
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

				
			   Tool.getHttpSession().setAttribute("user", user);
				return LOGIN;
				
			}else{
//				登陆失败
               return ERROR;
			}
			
		
    }
	/*注册
	 * 
	 * */
    public String register()
    {
    	baseEntity=user;
    	return super.add();
    }
//    删除用户
   public String deleteEmployee()
   {
	
	   baseEntity=user;
	   return super.delete();
   }
//   更新信息
   public String updateInfo()
   {
	   baseEntity=user;
	   return super.update();
   }
   
   public String getInfo()
   {
//	   try {
////		response.getOutputStream().write((UserDao.getUser(user.getUseNumber())).toString().getBytes());
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	   return NONE;
   }
	
//   退出
   public String logout()
   {
	  Tool.getHttpSession().removeAttribute("user");
	   
	   return "error";
   }
}

