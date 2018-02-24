package com.test;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
/*@RequestMapping除了修饰方法还可以修饰类
 * 
 * 当修饰类时 注意访问地址
 * 
 * */
@SessionAttributes(names={"c"})
@Controller
public class request extends ExceptionController{
	
	private final static String index="index";
	private User user;
	
	
   public User getUser() {
//	   HibernateValidator
	   return user;
	
   }
	public void setUser(User user) {
		this.user = user;
	}
	/*
	 * PUT DELETE
	 * 方法设置接口返回数据，而不是转发到页面
	 * 1 采用参数
	 * 2 路径参数
	 * */
     @RequestMapping(value="/test0",method=RequestMethod.DELETE)
     @ResponseBody()
	public String testDelete(@RequestParam(value="id") String name)
	{
		System.out.println("delete------------------"+name);
		return "删除成功！";
	}
     @RequestMapping(value="/test0",method=RequestMethod.PUT)
     @ResponseBody()
 	public String testPut(@RequestParam(value="id") MultipartFile name)
 	{
 		System.out.println("put------------------"+name);
 		return "修改成功！";
 	}
     @RequestMapping(value="/test0",method=RequestMethod.POST)
    
  	public String testPost(@RequestParam(value="id") String name)
  	{
  		System.out.println("put------------------"+name);
  		return index;
  	}
     @RequestMapping(value="/test",method=RequestMethod.POST)
     
    /* 路径参数*/
   	public String testPost(@PathVariable(value="id",required=false) Integer id)
   	{
   		System.out.println("put------------------"+id);
   		return index;
   	}
	
	/*路径占位符映射*/

     @RequestMapping(value="/test/{s}")
   
//   @RequestMapping(value="url", method=RequestMethod.GET,params={"one","two"},headers={})

   public String test(@PathVariable("s") String s)
   {
	   System.out.println("------------------"+s);
	   return index;
   }
     
//     采用@CookieValue绑定请求中的cookie值
     @RequestMapping(value="cookie")
     public String getInfo(@CookieValue( value="jsessionId") String id)
     {
    	 System.out.println("sessionid "+id);
    	 return index;
     }
     
//     使用POJO作为参数 类似struts2 中的模型驱动
     @RequestMapping(value="/register")
     public String pojo(User user)
     {
    	 System.out.println("sessionid "+user);
    	 return index;
     }
//     使用Servlet原生API作为入参
     @RequestMapping(value="servlet")
     public String testServlet(HttpServletRequest request,HttpServletResponse response)
     {
//    	Principal
//    	 HttpSession
//    	 Local
//    	 InputStream
//    	 OutputStream
//    	 Reader
//    	 Writer
    	 System.out.println(request);
    	 return index;
     }
     
//     模型数据之 ModelAndView
     @RequestMapping("/model")
     public ModelAndView testModelAndView()
     {
    	 ModelAndView modelAndView=new ModelAndView(index);
    	 modelAndView.addObject("time", new SimpleDateFormat("yyyy").format(new Date()));
    	 List<User> c=new ArrayList<User>();
    	 c.add(new User("111","1"));
    	 c.add(new User("222","2"));
    	      modelAndView.addObject("c", c);//如果和session key相同 输出相同的值
    	 return modelAndView;
     }
     
//     模型驱动之Map
     @RequestMapping("/map")
     public String testMap(Map<String, Object> map)
     {
    	 User user=new User("1111","222222");
    	 map.put("user", user);
    	 return index;
     }
     
//     @ModelAttribute
     @RequestMapping(value="/user",method=RequestMethod.POST)
     public ModelAndView testValidate(@Valid User user,BindingResult bindingResult)
     {
    	 ModelAndView modelAndView;
    	 int ec=bindingResult.getErrorCount();
    	 if(ec>0)
    	 {
    		 modelAndView=new ModelAndView("add");
    		 FieldError name=bindingResult.getFieldError("name");
    		 
    		 FieldError pwd=bindingResult.getFieldError("pwd");
    		 
    		 FieldError email=bindingResult.getFieldError("email");
    		 
    		 if(name!=null)
    		 {
    			 modelAndView.addObject("name", name.getDefaultMessage());		 
    		 }
    		 if(pwd!=null)
    		 {
    			 modelAndView.addObject("pwd",pwd.getDefaultMessage());
    			 System.out.println(pwd.getDefaultMessage());
    		 }
    		 if(email!=null)
    		 {
    			 modelAndView.addObject("email",email.getDefaultMessage());
    		 }
    	
    		 
    	 }else{
    		 
    		 modelAndView=new ModelAndView(index);		 
    	 }
    
    	 return modelAndView;
     }
     @RequestMapping(value="/user1",method=RequestMethod.POST)
     public String testValidate1(@Valid User user,BindingResult bindingResult,HttpServletRequest request,Model model)
     {
    	
    	 int ec=bindingResult.getErrorCount();
    	 
    	 if(ec>0)
    	 {
    		
    	     List<FieldError> list=bindingResult.getFieldErrors();
    	     for(FieldError fieldError:list)
    	     {
    	    	 request.setAttribute(fieldError.getField(), fieldError.getDefaultMessage());
    	    	
    	     }
    	    model.addAttribute("user", user);//     数据回显
    	    
    		   return "add";
    	  }
    
    	       return index;
     }
     @RequestMapping("/login")
     public String login(User user,
    		 Model model,BindingResult 
    		 bindingResult,HttpServletResponse response,
    		 HttpServletRequest request) throws Exception
     {
    
    		 double a=1/0;
//			response.sendRedirect(request.getContextPath()+"/view/index.jsp");
    		 return index;
	
			// TODO Auto-generated catch block
		
			
		
    	 
     }
     

     
}
