package com.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.entity.User;

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
}
