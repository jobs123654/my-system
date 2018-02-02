package com.tool;

import java.awt.color.ICC_Profile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Tool extends ActionSupport{
  private String filename;
  private String filepath;
  
  public Tool() {
	super();
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getFilepath() {
	return filepath;
}
public void setFilepath(String filepath) {
	this.filepath = filepath;
}
public static HttpSession getSession()
  {
	  HttpServletRequest request= ServletActionContext.getRequest();
	  HttpSession session=request.getSession();
	  return session;
  }
  public static HttpServletResponse getResponse()
  {
	  HttpServletResponse request= ServletActionContext.getResponse();
	  
	  return request;
  }
  public static HttpServletRequest getRequest()
  {
	  HttpServletRequest request= ServletActionContext.getRequest();
	  
	  return request;
  }
  private String special;
  
  public String getSpecial() {
	return special;
}
public void setSpecial(String special) {
	this.special = special;
}
public String Backups()
  {
	  
	  if(filename!=null&&filepath!=null)
	  {
		  if(filepath!="")
		  {
			  HttpServletRequest request=Tool.getRequest();
			   String rootpath="d:\\program files\\Tomcat 8.0\\webapps\\struts2\\config\\config.xml";
			   
			   System.out.print("输入成功！-----------"+special);
			   if(special!=null&&special!="")
			   {
				   String[]r=special.split(",");
				   String[] con=new String[r.length];
				 for(int i=0;i<r.length;i++)
				 {
//					 String string=
					con[i]=r[i];
					
				 }
				
				 DOM.init(rootpath, Time.getDate(),con);
				  DOM.createConfigure();
				  System.out.print("输出成功！-----------");  
			   }
			   
			  
			  
			  String nameString=filename.equals("")?"default.bak":filename+".bak";
			  File file = new File(filepath,nameString);  
			  //读入配置
			 
			 
			//判断目标文件所在的目录是否存在  
		        if(!file.getParentFile().exists()) {  
		            //如果目标文件所在的目录不存在，则创建父目录  
		            System.out.println("目标文件所在目录不存在，准备创建它！");  
		            if(!file.getParentFile().mkdirs()) {  
		                System.out.println("创建目标文件所在目录失败！");  
		                return NONE;
		            }  
		        }  
			 
			  try {
				  
				  if(!file.exists())
				  {
					  file.createNewFile();	  
				  }
				String string="";
				for(int i=0;i<10000;i++)
				{
					string+=i+"abcdefghijklmnopqritovwxyz";
				}
				
				byte[]bt=new byte[10000];
				bt=string.getBytes();
				System.out.print("-1--------------||");
				try {  
		            FileOutputStream in = new FileOutputStream(file);  
		            try {  
		                in.write(bt, 0, bt.length);  
		                in.close();  
		             HttpServletResponse response=Tool.getResponse();
		             response.getWriter().print("1");
		             System.out.print("-2--------------||");
		                // boolean success=true;  
		                // System.out.println("写入文件成功");  
		            } catch (IOException e) {  
		                // TODO Auto-generated catch block  
		                e.printStackTrace();  
		            }  
		        } catch (FileNotFoundException e) {  
		            // TODO Auto-generated catch block  
		            e.printStackTrace();  
		        }  
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		  }
		  return NONE;
	  }
		  
	  
		  return "ok";	  
	  
	 
  }

  public static void  main(String[]a) {
	
}
}
