package com.Aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Entity.User;

@Aspect
@Component
public class MyAop {
  private final static String cl="execution(* com.Action.*.*(..))";
  @Before(cl)
  public boolean say(JoinPoint point)
  {
      HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
      HttpSession session=request.getSession();
     if(session.getAttribute("user")==null)
     {
    	 return false;
     }
     return true;
  }
}
