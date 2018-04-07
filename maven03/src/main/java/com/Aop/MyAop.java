package com.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;

import com.Entity.User;

@Aspect
@Component
public class MyAop {
  private final static String cl="execution(* com.Action.*.*(..))";
  @Before(cl)
  public void say(JoinPoint point)
  {
	  User user=(User)point.getArgs()[1];
	  
	 
  }
}
