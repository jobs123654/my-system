package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.mbeans.UserMBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.UserDao;
import com.entity.User;

public class Test01 {
    
	public  static SqlSession getSqlSession() throws IOException {
		String resource = "config/mybatis-config.xml";
		
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		return sqlSessionFactory.openSession(true);//开启自动提交模式
	}
	public static void main(String[]a) throws IOException 
	{
		
		SqlSession session = getSqlSession();
		try {
			
			UserDao userDao=session.getMapper(UserDao.class);
			
//			User user=new User("115", "111", "abc", 1, "18332709375", 0, true);			
//			
//			userDao.add(user);
			
			
            User user=userDao.getUser1(2,"abc");
            
		
			
			Map<String, Object> useMap=new HashMap<String, Object>();
			
			useMap.put("id", 2);
			
			useMap.put("userName", "abc");
			
			User user2=userDao.getUserByMap(useMap);
			
			System.out.println(user2);
			
		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		} 
		
		finally {
		  session.close();
		}
	}
	
	 
}
