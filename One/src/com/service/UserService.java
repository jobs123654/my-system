package com.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.BaseDao;
import com.model.User;
import com.opensymphony.xwork2.ActionSupport;

@Aspect
public class UserService extends ActionSupport{
	  private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Before("execution(** com.aop.MyInterface.check(..))")
	public String login()
	{
		
		System.out.println("-------------------------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config1.xml");
		
		BaseDao baseDao=(BaseDao)applicationContext.getBean("basedao");
		baseDao.deal();
		return NONE;
	}
	public String run()
	{
		return NONE;
	}
	public String song()
	{
		return NONE;
	}
	
}
