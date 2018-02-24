package com.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.json.JsonArray;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.entity.User;

import net.sf.json.JSONObject;

@Controller
public class Upload extends ExceptionController{
	
	
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(@RequestParam(name="file",required=false) MultipartFile multipartFile,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		Model model
    		) throws IllegalStateException, IOException
    {
    	System.out.println("start");
    	String path=request.getContextPath()+"/upload";
    	
    	String filename=new Date().getTime()+".jpg";
    	
    	File tfile=new File(path,filename);
    	
    	if(!tfile.exists())
    	{
    		tfile.mkdir();
    	}
    	multipartFile.transferTo(tfile);//执行上传
    	model.addAttribute("file", request.getContextPath()+"/upload/"+filename);
    	System.out.println(request.getContextPath()+"/upload/"+filename);
    	return "index";
    }
    
    @RequestMapping("/dog")
    public String test(@RequestParam("des") String des, @RequestParam("dog") MultipartFile file,HttpServletResponse response)
    {
    	System.out.println("-------------------"+des+"     ");
    	return "index";
    }
//    json请求
    @RequestMapping("/requestJson")
    @ResponseBody
    public User requestJson(User user)
    {
    	return user;
    }
}
