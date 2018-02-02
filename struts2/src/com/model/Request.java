package com.model;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tool.HibernateSessionFactory;
import com.tool.Log;
import com.tool.Time;
import com.tool.Tool;

import net.sf.json.JSONArray;
@Entity
@Table(name="request")
public class Request extends ActionSupport {
   @Id
   @GeneratedValue
    private int id;
   
	private int uid;//用户id
   
   @Column(length=4)
   private String pid;//产品id
   
   private int day;//使用时长
   @Column(length=20)
   private String rtime;//申请时间
   
   private String dtime;//处理时间
   
   private int status;//申请状态
  @Transient
  
  private List<Request>requests=new ArrayList<Request>();
  
public int getUid() {
	return uid;
}
public  void loadList()
{
	Session session=HibernateSessionFactory.getSession();
	session.clear();
	Transaction transaction=session.beginTransaction();
	
	Query query =session.createQuery("from Request");
	requests=query.list();
	
}//获取没有批准的申请
@Transient
private List<Request>requests_no=new ArrayList<Request>();

public List<Request> getRequests_no() {
	return requests_no;
}
public void setRequests_no(List<Request> requests_no) {
	this.requests_no = requests_no;
}
public  String GetList()
{
	Session session=HibernateSessionFactory.getSession();
	session.clear();
	Transaction transaction=session.beginTransaction();
	
	Query query =session.createQuery("from Request where status=0");
	requests_no=query.list();
	JSONArray jsonArray=JSONArray.fromObject(requests_no);
	HttpServletResponse response=Tool.getResponse();
	try {
		response.getWriter().print(jsonArray);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return NONE;
}
public void setUid(int uid) {
	this.uid = uid;
}

public String getPid() {
	return pid;
}

public void setPid(String pid) {
	this.pid = pid;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}



public String getRtime() {
	return rtime;
}
public void setRtime(String rtime) {
	this.rtime = rtime;
}
public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public List<Request> getRequests() {
	return requests;
}

public void setRequests(List<Request> requests) {
	this.requests = requests;
}

public Request(int uid, String pid, int day, String rtime, int status) {
	super();
	this.uid = uid;
	this.pid = pid;
	this.day = day;
	this.rtime = rtime;
	this.status = status;
}
@Transient
private List<JL> list=new ArrayList<JL>();
public String Jl()
{
	Session session=HibernateSessionFactory.getSession();
	session.clear();
	Query query=null;
	
	
	if(pid!=null)
	{
		query=session.createQuery("from Request as r inner join User as u on r.uid=u.uid where r.pid=:pid");	
		query.setString("pid", pid.trim());
		
	}
	if(uid!=0)
	{
		query=session.createQuery("from Request as r inner join User as u on r.uid=u.uid where r.uid=:uid");
		query.setInteger("uid", uid);
		
	}
	
	List l=query.list();
	if(l!=null&&l.size()!=0)
	{
		for(int i=0;i<l.size();i++)
		{
			Object[] o=(Object[])l.get(i);
			User u=(User)o[1];	
			Request request=(Request) o[0];
			list.add(new JL(u,request));
		}
		
		
	}
	
	
	
	return "search_ok";
}

public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
public Request() {
	super();
}
@SuppressWarnings("unchecked")
public String RequestList()
{
	
	  Session session=HibernateSessionFactory.getSession();
    session.clear();  
      session.getTransaction().begin();
      requests=session.createQuery("from Request").list();
//       for(Request r:requests)
//       {
//    	   Log.log("|------"+r.getUid()+" "+r.getRtime());
//       }
     return "show_list";
}

public String OK()
{
	if((Object)id!=null)
	{
		 Session session=HibernateSessionFactory.getSession();
		  session.clear();
	      session.getTransaction().begin();
	      
	      Request request=session.get(Request.class, id);
	      
	      request.setStatus(1);
	      request.setDtime(Time.getDate());
	      session.save(request);
	      session.getTransaction().commit();
	      requests=session.createQuery("from Request").list();
//	      session.close();
	}
	return "show_list";
}
public String getDtime() {
	return dtime;
}
public void setDtime(String dtime) {
	this.dtime = dtime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String _Request()
{
	Log.log("---------"+uid+"  "+pid+" 天 "+day+" ---"+rtime);
	if((Object)uid!=null&&pid!=null&&(Object)day!=null)
	{  
		
		
		try {
			Session session=HibernateSessionFactory.getSession();
//			(String uid, String pid, int day, String rtime, int status)
		      session.getTransaction().begin();
		      
		      
		      Request request=new Request(uid,pid,day,Time.getDate(),0);
		      
		      Product product=session.get(Product.class, pid);
		      product.setStatus(true);
		      session.update(product);
		      session.save(request);
		      session.getTransaction().commit();
		      
		      return "r_ok";
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	      
	      return "o_error";
	      
	}
	 
	  
	
	
//      requests=session.createQuery("from Request").list();
     
     return "request";
}
public String Delete()
{
	 Session session=HibernateSessionFactory.getSession();
	  Transaction transaction=session.beginTransaction();
	  Request product=session.get(Request.class, id);
	 session.delete(product);
	 transaction.commit();
	 loadList();
	return "show_list";
	
}
  
}
