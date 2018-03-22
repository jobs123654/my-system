package com.dao;


import java.util.List;

import com.entity.BaseEntity;
import com.entity.User;
import com.tool.Tool;

public class UserDao extends BaseDao{
    
//	添加用户
	public static Boolean isAdd(User user)
	{
		return BaseDao.isAdd(user);
	}
//删除用户
	public static Boolean isDelete(BaseEntity baseEntity)
	{
		User user=(User)baseEntity;
		if( BaseDao.isDelete(session.get(User.class,user.getId())))
		{	
			return true;
		}
		return false;
	}
//修改信息 
	public static Boolean isUpdate(BaseEntity user0)
	{
		
		User u=(User)user0;
		
		User user=session.get(User.class, u.getId());
		
		System.out.println(user);
		if(user!=null)
		{
		//	user.setUserName(u.getUserName());
			user.setUseNumber(u.getUseNumber());;
			try {
				user.setUserPassword(Tool.encryptSHA(u.getUserPassword()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			user.setUserSex(u.getUserSex());
			if(BaseDao.isUpdate(user))
			{
			 return true;	
			}
			 return false;
		}
		
		 return false;
	}
//查找用户 通过Id
	public static User getUser(int id)
	{
		return session.get(User.class, id);
	}
	
//查找用户 通过 工号密码
	public static User getUser(User u)
	{
		
			for(User user:getList())
			{
				
				try {
					if(user.getUseNumber().equals(u.getUseNumber())&&user.getUserPassword().equals(Tool.encryptSHA(u.getUserPassword())))
					{
						return user;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public static List<User>getList()
	{
		return (List<User>) BaseDao.getList("User"); 
	}
	
	
	
	
}
