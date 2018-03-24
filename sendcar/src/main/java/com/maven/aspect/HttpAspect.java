package com.maven.aspect;

import com.maven.entity.User;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class HttpAspect {
  private static  final  String BEFORE="execution(* com.maven.action.*.*(..))";

  @Before(BEFORE)
   public  String before(JoinPoint joinPoint)
  {
      /*User user=(User)joinPoint.getArgs()[0];
      System.out.println("-------------before"+user.getUserName()+"  "+user.getUserPassword());*/
    /*HttpSession session= request.getSession();
    if(session.getAttribute("man")!=null)
    {
     return "home";
    }*/
     return "index";
  }

  @After(BEFORE)
    public  void after()
  {
      System.out.println("--------------after");
  }

}
