package com.action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.entity.User;
import com.inter.UserInterface;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.servive.UserService;
@Controller
public class UserAction { 
	 
	private static final String SUCCESS="success";
	
	@Autowired
	 private UserService service;
	
        @RequestMapping("/login")
		public String login(Model model,User u)
	   {
        
        	User user=new User();
        	user.setName("李更强");
        	
        	service.addUser(user);

	     return SUCCESS;	   
	   }
        
}
