package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

@SessionAttributes(value={"you"})//存放模型中的值
@Controller
public class UserService {
	   @RequestMapping(value="/login",method=RequestMethod.POST)
	   public String login(User user,HttpServletResponse response,HttpServletRequest request)
	   {
		   System.out.println("___________"+user);
		   return "index";
	   }
	   
	   @RequestMapping(value="/upload",method=RequestMethod.POST)
	   public String upload(MultipartFile file) throws IOException
	   {
		   
		   System.out.println("___________"+file.getOriginalFilename());
		   return "index";
	   }
	   /*
	    * 配置REST风格的请求方式
	    * 
	    * 
	    * */
	   @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	   public String get(@PathVariable(value="id") Integer id)
	   {
		   System.out.println("get----------------"+id);
		   return "index";
	   }
	   
	   @RequestMapping(value="/post",method=RequestMethod.POST)
       public String post( User user)
       {
		   System.out.println("--------------------"+user);
		   return "index";
       }
	   
	   @RequestMapping(value="/put",method=RequestMethod.PUT)
       public String put( User user)
       {
		 
		   return "index";
       }
	   @RequestMapping(value="/delete",method=RequestMethod.DELETE)
       public String delete( User user)
       {
		  
		   return "index";
       }
	   /*携带cookie值*/
	   @RequestMapping(value="/cookie",method=RequestMethod.POST)
	   public String cookie(@CookieValue(value="json") String c)
	   {
		return "index";   
	   }
	   
	   /*原生servlet入参*/
	   //HttpServletRequest
//	   HttpServletResponse
//	   HttpSession
//	   Principal
//	   Local
//	   InputStream
//	   OutputStream
//	   Writer
//	   Reader

	  /* 处理模型数据的几种方法：
	   ModelAndView
	   Model 及Map
	   ModelAttributes
	   SessionAttribute
	   */
	   @RequestMapping(value="/update",method=RequestMethod.GET)
	   public ModelAndView getUser()
       {
       	 ModelAndView modelAndView=new ModelAndView("index");
       	 modelAndView.addObject("key", "");
       	 return modelAndView;
       }
	   
	   @RequestMapping("/model")//同 ModelMap
	   public String model(Model model)
	   {
		   model.addAttribute("key", new User("111","111"));
		   return "index";
	   }
	   
	   @RequestMapping("/map")
	   public String model(Map< String, User> map)
	   {
		   map.put("you", new User("222","222"));
		   return "index";
	   }
	   @RequestMapping("/session")
	   public String session()
	   {
		   return "form";
	   }
	   
	   /*ModelAttribute 在控制器方法调用之前调用做一些准备工作
	    * 1 修饰无返回值的方法
	    * */
	   
	   
	  /* @ModelAttribute
	   public void start(Map<String, User> map)
	   {
		   从数据库中查出来的值
		    * 原始数据
		    * 
		    * 最后执行对象合并 实际上就是key值对应入参
		    * 
		   User user=new User("111", "111");
		   map.put("user", user);
		   System.out.println("-----------------调用");
	   }*/
	   
	   
	   /*ModelAttribute 修饰有返回值的方法*/
	   
	   @ModelAttribute(value="abc")
	   public User start()
	   {
		   User user=new User("111", "111");
		   
		   return user;//默认key 为user
	   }
//	   数据进行修改时，会自动搜索相同的model名字 进行对象合并 ,寻找abc的key值
	   @RequestMapping("testModel")
	   public String testModel(@ModelAttribute(value="abc") User user)
	   {
		   System.out.println(user);
		   return "index";
	   }

}
       