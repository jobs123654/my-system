package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.entity.User;

import net.sf.json.JSONObject;

@SessionAttributes(value={"abc"})
@Controller
/*视图的解析流程
 * 
 * */
public class CustomService {
    @RequestMapping(value="/testJson",consumes="application/json",produces="application/json")
    @ResponseBody
    public String testJson(User u)
    {
    	System.out.println("-----------------"+u);
    	User user=new User("111", "111");
    	JSONObject jsonObject=JSONObject.fromObject(user);
    	return jsonObject.toString();
    }
    //------------------------------------------参数不同调用不同的方法
    @RequestMapping(value="app",params="type=1")
    public String test1()
    {
    	System.out.println("app?type=1");
    	return "index";
    }
    @RequestMapping(value="app",params="type=2")
    public String test2()
    {
    	System.out.println("app?type=2");
    	return "index";
    }
    @RequestMapping(value="uploadFile",method=RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file,HttpServletRequest request, HttpServletResponse response,User user)
    {
    	String path=request.getSession().getServletContext().getRealPath("/");
    	System.out.println(file);
    	return "index";
    }
    
}
