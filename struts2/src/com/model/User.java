package com.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tool.HibernateSessionFactory;
import com.tool.Time;

import antlr.build.Tool;
import net.sf.json.JSONArray;

@Entity
public class User extends ActionSupport{
	
	//------------------------多对一设置-------------------------
//	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
//	@JoinColumn(name="rid",referencedColumnName="RID")
//	
	
	
	//----------------------------------------------------------
	
	static{
		
		  Session session=HibernateSessionFactory.getSession();
	      
	      session.getTransaction().begin();
	      session.save(new User(0,"root","root",Time.getDate(),1));
	      session.getTransaction().commit();
	}
	@Id
	@GeneratedValue
	private int uid;
	private String name;
	private String pwd;
	
	@Transient
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Product.class,orphanRemoval = true,mappedBy = "user")//用户作为一方使用OneToMany注解
///	@JoinColumn(name = "user_id")
	@Transient
	private List<Product>products=new ArrayList<Product>();
	
	private String rtime;//注册时间
	private int role;//角色
	@Transient
	private List<Request> requests= new ArrayList<Request>();
	public String getRtime() {
		return rtime;
	}
	public void setRtime(String rtime) {
		this.rtime = rtime;
	}
	public int getRole() {
		return role;
	}
	
	@Transient
	private String auto;
	public String getAuto() {
		return auto;
	}
	public void setAuto(String auto) {
		this.auto = auto;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public User(int uid, String name, String pwd, String rtime, int role) {
		super();
		this.uid = uid;
		this.name = name;
		this.pwd = pwd;
		this.rtime = rtime;
		this.role = role;
	}
	public User() {
		super();
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Transient
	private  List<User> users=new ArrayList<User>();
	
	public static void main(String[]args) {
		// TODO Auto-generated method stub
      Session session=HibernateSessionFactory.getSession();
      
      session.getTransaction().begin();
      session.getTransaction().commit();
	}
	@Transient
	private List<JP> requests1=new ArrayList<JP>();
	public String getRequest()
	{
		try {
			  Session session=HibernateSessionFactory.getSession();
		      
			  session.clear();
		      session.getTransaction().begin();
		      
		     
		      Query  query=session.createQuery("from Product as p  inner join Request as r on p.tid=r.pid where r.uid=:uid");
		      query.setParameter("uid", uid);
		      List l=query.list();
		      if(l!=null&&l.size()!=0)
		      {
		    	  for(int i=0;i<l.size();i++)
		    	  {
		    		  Object[] o=(Object[])l.get(i);
		    		 Product product=(Product)o[0];
		    		 Request request=(Request)o[1];
		    		 
		    		 requests1.add(new JP(product,request));
		    	  }
		      }
		    requests=query.list();
		      
		    
		      return "r_ok";
		} catch (Exception e) {
		      return ERROR;
		}
	}
	public String Edit()
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.getTransaction();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session2=request.getSession();
		User user1=(User)session2.getAttribute("user");
		int id=user1.getUid();
		
		user=session.get(User.class, id);
 
		if(name!=null)
		{
			if(name!=""&&pwd!="")
			{
				System.out.print("-------"+user.getName()+"  "+user.getUid());
				user.setName(name);
				user.setPwd(pwd);
				session.saveOrUpdate(user);
				transaction.commit();
				return "edit_ok";
				
			}	
		}
		
		
		return "edit";
	}
	public List<JP> getRequests1() {
		return requests1;
	}
	public void setRequests1(List<JP> requests1) {
		this.requests1 = requests1;
	}
	public  String Get()
	{
		loadList();
		JSONArray jsonArray=JSONArray.fromObject(users);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().print(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	public String Register()
	{
		try {
			  Session session=HibernateSessionFactory.getSession();
		      
		      session.getTransaction().begin();
		      
		      User user=new User(name,pwd);
		      user.setRole(0);
		      user.setRtime(Time.getDate());
		      session.save(user);
		      
		      session.getTransaction().commit();
		    Cookie uname=new Cookie("name", name);
		    
		    Cookie upwd=new Cookie("pwd", pwd);
		    
		    HttpServletResponse response=com.tool.Tool.getResponse();
		    
		    response.addCookie(uname);
		    response.addCookie(upwd);
		    
		    
		    
		} catch (Exception e) {
		      return ERROR;
		}
		return "register_ok";
	}
	 public  void loadList()
	    {
	    	Session session=HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			session.clear();
			Query query =session.createQuery("from User");
			users=query.list();
			users.add(new User(0,"root","root",Time.getDate(),1));
	    }
	public String Login()
	{
		
		  Session session=HibernateSessionFactory.getSession();
	      
	      session.getTransaction().begin();
//	      session.save(new User(0,"root","root",Time.getDate(),1));
//	      session.getTransaction().commit();
	      if(name!=null&&pwd!=null)
	      {
	    	  List<User>users=session.createQuery("from User").list();
				for(User u:users)
				{
					if(u.getName().equals(name)&&u.getPwd().equals(pwd))
					{
						HttpServletRequest request=ServletActionContext.getRequest();
						HttpSession session2=request.getSession();
						session2.setAttribute("user", u);
						if(auto!=null)
						{
							Cookie[] cookies=com.tool.Tool.getRequest().getCookies();
							for(Cookie c:cookies)
							{
								if(c.getName()=="uname"&&c.getName()=="upwd")
								{
									c.setMaxAge(7*24*60*60);
								}
							}
						}
						if(u.getRole()==0)
						{
							return "login_ok_u";	
						}
						return "login_ok";
						
					}
				}  
				return ERROR;
	      }
	      
		
		return "login";
	}
	public String Logout()
	{
		Cookie[] cookies=com.tool.Tool.getRequest().getCookies();
		for(Cookie c:cookies)
		{
			if(c.getName().equals("name")||c.getName().equals("pwd"))
			{
			
				c.setMaxAge(0);
			    com.tool.Tool.getResponse().addCookie(c);
			}
			
		}
		
		return "register_ok";
	}
	public String UserList()
	{
		  Session session=HibernateSessionFactory.getSession();
	      
	      session.getTransaction().begin();
	      users=session.createQuery("from User").list();
	     
	     return "show_list";
	}
	public String Delete()
	{
		 Session session=HibernateSessionFactory.getSession();
		  Transaction transaction=session.beginTransaction();
		 User user=session.get(User.class, uid);
		 Query query=session.createQuery("delete from Request where uid=:id");
		 query.setInteger("id", uid);
		 
		 query.executeUpdate();
		 
		 session.delete(user);
		 
		 
		 transaction.commit();
		 users=session.createQuery("from User").list();
		
		return "delete";
		
	}
	
	public static void main()
	{
		Session session=HibernateSessionFactory.getSession();
	      
	      session.getTransaction().begin();
	      
	     
	    	List<Request> requests=session.createQuery("from Request where uid=2").list();
	    	
	    	System.out.print(requests.size()+"----------");
	      
	}
	
}
