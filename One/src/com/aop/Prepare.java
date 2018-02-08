package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class Prepare {
	@Before(value="execution(* com.model.User.*(..))")
  public void show()
  {
	  System.out.println("前置增强");
  }
	
	@After(value="execution(* com.model.User.*(..))")
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
