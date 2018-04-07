package com.Action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.Entity.Manager;
import com.Entity.User;
import com.Service.ManagerService;
import com.Service.UserService;
import com.Tool.Exp;
import com.Tool.Page;
/*管理员*/
@Controller
public class ManagerAction  extends BaseAction{
	  @Autowired
	  private ManagerService mservice;
	  
	  @Autowired 
	  private UserService service;
	  
	  
	  /**
	 * @return the mservice
	 */
	public ManagerService getMservice() {
		return mservice;
	}
	  /*管理员登录*/
	  @RequestMapping("/mlogin")
		public String mlogin( Model model,Manager user,HttpServletRequest request)
	   {
      	
        String aString=request.getMethod();
      	if(request.getMethod().equals("POST"))
       {
      	 if(mservice.findManager(user)!=null)
      	 {
      		 Manager user0=mservice.findManager(user);
         	 model.addAttribute("user", user0);
         	  HttpSession session=request.getSession();
       	      session.setAttribute("user", user0);
         	    /* if(user0.getRole()!=0)
         	     {
         	    	 return "manager";
         	     }
         	  model.addAttribute("msg",new Exp("您的权限过低!"));
         	  return "login";*/
       	   return "manager";
      	 }
      	  
       }
       model.addAttribute("msg",new Exp("账号或密码错误!"));
       return "manager_index";   
	   }
	//退出
      @RequestMapping("logout")
      public String logout(HttpServletRequest request,Model model)
      {
      	HttpSession session=request.getSession();
      	model.addAttribute("msg",new Exp(""));
      	session.removeAttribute("user");
      	service.clear();
      	return "login";
      }
     
	  
      /*返回主页*/
	  @RequestMapping("/home")
	     public String home(Model model)
	   {
		  return "manager";
	   }
	  /*显示业务员列表*/
	  @RequestMapping("/user_list")
	     public String userList(Model model,@RequestParam( value="c",defaultValue="1") int c )
	   {
		  List<User> u=service.getAll();
		  Page<User> page=new Page<User>(c, 10, u);
          model.addAttribute("list",page.getResult() );
          model.addAttribute("page",page );
		  return USER;
	     	
	   }
	  @RequestMapping("/result_user_list")
	     public String resultUserList(Model model,User user, @RequestParam( value="c",defaultValue="1") int c )
	   {
		  List<User> u=service.getUserByName(user);
		  Page<User> page=new Page<User>(c, 10, u);
          model.addAttribute("list",page.getResult() );
          model.addAttribute("page",page );
          model.addAttribute("user", user);
		  return "result_user_list";
	   }
	  @RequestMapping("/show_add_user")
	     public String add(Model model)
	   {
	         return "add_user";
	   }
	  
	  @RequestMapping("/add_user")
	     public String addUser(@RequestParam("file") MultipartFile file, Model model,User user,HttpServletRequest request)
	   {
		 
		  
		     if(user.getName()!=null)
		     {
		    	 if(!file.isEmpty()) {
		             //上传文件路径
		             String path = request.getServletContext().getRealPath("/")+"/head/";
		             File file2=new File(path);
		             if(file2.isDirectory()&&!file2.exists())
		             {
		            	 file2.mkdir();
		             }
		             //上传文件名
		             String filename = user.getId()+".jpg";
		             user.setPicpath("head/"+filename);
		             File filepath = new File(path,filename);
		             //判断路径是否存在，如果不存在就创建一个
		             if (!filepath.getParentFile().exists()) { 
		                 filepath.getParentFile().mkdirs();
		             }
		             //将上传文件保存到一个目标文件当中
		             try {
						file.transferTo(new File(path + File.separator + filename));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		             
		    	 
		    	 service.add(user);
		    	 return userList(model,1);
		         }
		     }
	         return "add_user";
	   }
	  @RequestMapping("/update_user")
	     public String updateUser( @RequestParam("file") MultipartFile file,Model model,User user,HttpServletRequest request)
	   {
		  System.out.println(file+"  "+user);
		  
		   if(!file.isEmpty())
		   {
			   //上传文件路径
	             String path = request.getServletContext().getRealPath("/")+"/head/";
	             File file2=new File(path);
	             if(file2.isDirectory()&&!file2.exists())
	             {
	            	 file2.mkdir();
	             }
	             //上传文件名
	             String filename = user.getId()+".jpg";
	             user.setPicpath("head/"+filename);
	             File filepath = new File(path,filename);
	             //判断路径是否存在，如果不存在就创建一个
	             if (!filepath.getParentFile().exists()) { 
	                 filepath.getParentFile().mkdirs();
	             }
	             //将上传文件保存到一个目标文件当中
	             try {
					file.transferTo(new File(path + File.separator + filename));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		   }
		    
	         service.update(user);
	         return userList(model,1);
	     	
	   }
	  
	  @RequestMapping("/show_update_user")
	    public String showUpdateUser(Model model,User user)
	   {
		   
	     	
	     	 User user2=service.getUser(user);
	     	 model.addAttribute("u", user2);
	         return "update_user";
	     	
	   }
		 @RequestMapping("/delete_user")
	     public String delUser(Model model,User user)
	     {
	     	 service.delete(user);
	     	 return userList(model,1);
	     }
		 
		 /*显示所有账户列表*/
		 @RequestMapping("/manager_list")
	     public String managerLIst(Model model,@RequestParam( value="c",defaultValue="1") int c )
	     {
			   List<Manager> u=mservice.getAll();
			  Page<Manager> page=new Page<Manager>(c, 10, u);
	          model.addAttribute("list",page.getResult() );
	          model.addAttribute("page",page );
	     	return "manager_list";
	     }
		 
		 /*新增账户*/
		 @RequestMapping("/add_manager")
	     public String addManager(Model model,Manager manager,HttpServletRequest request)
	     {
			 if(request.getMethod().equals("POST"))
			 {
				 mservice.add(manager);	 
				 return managerLIst(model, 1);
			 }
			 return "add_manager";
	     }
		 public void addManager(Manager manager)
	     {
			
				 mservice.add(manager);	 
			
	     }
		 
		 /*修改账户*/
		 @RequestMapping("/update_manager")
	     public String updateManager(Model model,Manager manager,HttpServletRequest request)
	     {
			 if(request.getMethod().equals("POST"))
			 {
				 mservice.update(manager);
			     	return managerLIst(model, 1);	 
			 }
			 Manager m=mservice.findManager(manager);
			 model.addAttribute("m", m);
			 return "update_manager";
			 
	     }
		 /*删除账户*/
		 @RequestMapping("/delete_manager")
	     public String deleteManager(Model model,Manager manager)
	     {
			 mservice.delete(manager);
	     	return managerLIst(model, 1);
	     }
		
		 
		 
		 
		
	 
	
}
