package com.Tool;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.Entity.BaseEntity;
import com.Entity.User;

public class Test {
	@org.junit.Test
  public  void test()
  {
	  Class<User> clazz ;
	  BaseEntity baseEntity=new User();
	  ParameterizedType type = (ParameterizedType)baseEntity.getClass().getGenericSuperclass();  
//      clazz = (Class<User>) type.getActualTypeArguments()[0];  
      System.out.println(type.getActualTypeArguments()[0]);
  }
}
