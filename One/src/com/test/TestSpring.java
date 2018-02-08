package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.MyInterface;
import com.itf.Myinterface;
import com.model.User;

public class TestSpring {

	@Test
	public void test() {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config1.xml");
		
		User user=(User)applicationContext.getBean("user");
		
		user.show();
	}

}
