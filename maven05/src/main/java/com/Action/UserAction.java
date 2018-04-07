package com.Action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.persister.entity.Loadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.Entity.Classify;
import com.Entity.InsuranceExchange;
import com.Entity.User;
import com.Service.ClassifyService;
import com.Service.InsuranceExchangeService;
import com.Service.SecureService;
import com.Service.UserService;
import com.Tool.Exp;
import com.Tool.Page;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Controller
/*
*业务员
*/
public class UserAction extends BaseAction{
       
	  @Autowired
	  private UserService service;
	  
	  @Autowired
	  private ClassifyService sservice;
	  
	  
	  
	  @RequestMapping("index")
	  public String index(Model model)
	  {
		  Load(model);
		  return "index";
	  }
	  private void Load(Model model)
	  {
		  Classify classify=new Classify();
   	   classify.setFid("一年期");
   	   model.addAttribute("c1", sservice.getClassifies(classify));
   	   classify.setFid("汽车保险产品");
   	   model.addAttribute("c2", sservice.getClassifies(classify));
   	   classify.setFid("长期寿险电子保单类产品");
   	   model.addAttribute("c3", sservice.getClassifies(classify));
   	   classify.setFid("其他产品");
   	   model.addAttribute("c4", sservice.getClassifies(classify));
	  }
        @RequestMapping("/login")
		public String login( Model model,User user,BindingResult result,HttpServletRequest request)
	   {
         if(service.findUser(user)!=null)
         {
        	  User user0=service.findUser(user);
        	 /* model.addAttribute("user", user0);*/
        	   HttpSession session=request.getSession();
        	   session.setAttribute("yw", user0);
        	   Load(model);
        	  return "index";
        	 
         }
         model.addAttribute("msg",new Exp("工号或密码错误!"));
        
         return "login";   
	   }
       //退出
        @RequestMapping("ulogout")
        public String  logout(HttpServletRequest request,Model model)
        {
        	HttpSession session=request.getSession();
        	model.addAttribute("msg",new Exp(""));
        	session.removeAttribute("yw");
        	service.clear();
        	return "login";
        }
       
        //创建支付
        @RequestMapping("charge_test")
        public String  charge(HttpServletRequest request,Model model)
        {
        	return "charge_test";
        }
       
		
}
