package com.action;



import java.io.IOException;

import com.dao.UserDao;
import com.entity.User;


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
			if(UserDao.getUser(user)!=null)
			{
//				登录成功
//				if(user.getIsRemember())
//				{
//					
//				}
				System.out.println("-------"+user.getIsRemember());
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
	   try {
		response.getOutputStream().write((UserDao.getUser(user.getUseNumber())).toString().getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return NONE;
   }
	
}
