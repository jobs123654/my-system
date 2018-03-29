package com.Action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.Entity.User;
import com.Service.UserService;
import com.Tool.Page;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Controller
public class UserAction {
       
	  @Autowired
	  private UserService service;
	  private static final String SUCCESS="success";
        @RequestMapping("/login")
		public String login(Model model,User user)
	   {
         service.add(user); 
		 Page<User> page=new Page<User>(1,2, service.getAll());
		 
         model.addAttribute("list",page.getResult());
         model.addAttribute("page",page);
		 
	     return SUCCESS;	   
	   }
        @RequestMapping("/page")
        public String test(Model model,@RequestParam(value="c" ,defaultValue="1") int c)
        {

        	 Page<User> page=new Page<User>(c,2, service.getAll());
             model.addAttribute("list",page.getResult());
             model.addAttribute("page",page);
        	return SUCCESS;
        }
        @RequestMapping("/ut")
        public String ut(Model model,User user)
        {
        	User user4=user;
        	
            if(user.getName()!=null&&!user.getName().equals(""))
            {
            	service.update(user);
            	return SUCCESS;	
            }
            User user2=service.getUser(user);
            model.addAttribute("user",user2 );
          return "update";
        	
        }
        @RequestMapping("/del")
        public String del(Model model,User user)
        {
        	service.delete(user);
          return SUCCESS;
        	
        }
	   	/**
		 * @return the service
		 */
		public UserService getService() {
			return service;
		}
		/**
		 * @param service the service to set
		 */
		public void setService(UserService service) {
			this.service = service;
		}
		
		public String register()
		{
	   		
		     return "register";	   
		}
}
