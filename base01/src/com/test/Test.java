package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
	
	@org.junit.Test
  public void say() throws ClassNotFoundException
  {
	 Class<?> c1=Class.forName("java.lang.String");
	 
	 String string="hellow";
	 Class<?>c=string.getClass();
	 
	 Method[] methods=c.getDeclaredMethods();
	 Constructor[]constructors=c.getConstructors();
	 Field[]fields=c.getDeclaredFields();
	 
  }
}
