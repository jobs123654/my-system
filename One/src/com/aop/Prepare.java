package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Prepare {
  public void show()
  {
	  System.out.println("前置增强");
  }
  public void show1()
  {
	  System.out.println("后置增强");
  }
  
  public void around(ProceedingJoinPoint point) throws Throwable
  {
	  System.out.println("方法之前");
      point.proceed();
	  System.out.println("方法之后");
  }
}
