package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.regexp.internal.recompile;
import com.tool.HibernateSessionFactory;
import com.tool.Time;
import com.tool.Tool;

import net.sf.json.JSONArray;
@SuppressWarnings("serial")
@Entity
public class Product extends ActionSupport{
   @Id
   @GeneratedValue(generator="tid")
   @GenericGenerator(name="tid",strategy="assigned")
   @Column(length=5)
	private String tid; 
   
    private String tname;
    private String tclassify;
    private String tmodel;
    
    private String path;
    
//  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Transient
    private User user;
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTurl() {
		return turl;
	}

	public void setTurl(String turl) {
		this.turl = turl;
	}

	private String tcontent;
    
    private String taddress;
    private String turl;    
    
    private boolean status;
    
    private int isNormal;//是否正常
   public int getIsNormal() {
		return isNormal;
	}

	public void setIsNormal(int isNormal) {
		this.isNormal = isNormal;
	}

	//-------------------------------
    @Transient
    private File tpath;
    @Transient
    private Product product;
    
    
    @Transient
    private List<Classify> classifyList=new ArrayList<Classify>();

    @Transient
    private List<Product> result=new ArrayList<Product>();
    
    public List<Product> getResult() {
		return result;
	}
//    public Product
//    (String tid, String tname, String tclassify, String tmodel, File tpath, String tcontent,
//			String taddress, String turl, boolean status)
   static
   {
	   
   }
	public void setResult(List<Product> result) {
		this.result = result;
	}

	public List<Classify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<Classify> classifyList) {
		this.classifyList = classifyList;
	}

	@Transient
    private int first=1;
    
    @Transient 
    private int all;
    
    @Transient
    private int length=1;
    @Transient 
     private java.util.List<Product> list=new ArrayList<Product>();
    public java.util.List<Product> getList() {
		return list;
	}

	public void setList(java.util.List<Product> list) {
		this.list = list;
	}

	@Transient
    //提交过来的file的MIME类型
    private String fileContentType;
    
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public String Classify()
	{
		Session session=HibernateSessionFactory.getSession();
		List<Object> classifies=session.createQuery("select tclassify,count(*) as num from Product group by tclassify").list();
		JSONArray jsonArray=JSONArray.fromObject(classifies);
		HttpServletResponse httpServletResponse=Tool.getResponse();
		System.out.println("----||"+jsonArray);
		try {
			httpServletResponse.setCharacterEncoding("utf-8");
			httpServletResponse.getWriter().print(jsonArray);
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return NONE;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTclassify() {
		return tclassify;
	}

	public void setTclassify(String tclassify) {
		this.tclassify = tclassify;
	}

	public String getTmodel() {
		return tmodel;
	}

	public void setTmodel(String tmodel) {
		this.tmodel = tmodel;
	}

	public File getTpath() {
		return tpath;
	}

	public void setTpath(File tpath) {
		this.tpath = tpath;
	}

	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}

	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	public String getturl() {
		return turl;
	}

	public void setturl(String turl) {
		this.turl = turl;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Product() {
		super();
	}
    public String GetProductByName()
    {
    	if(tname!=null)
    	{
    		Session session=HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			Query query=session.createQuery("from Product where tname like :tn");
			session.clear();
//			session.clear();
			query.setParameter("tn", "%"+tname+"%");
			
			result=query.list();
			
    	}
    	return "result";
    }
	public Product(String tid, String tname, String tclassify, String tmodel, File tpath, String tcontent,
			String taddress, String turl, boolean status) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.tclassify = tclassify;
		this.tmodel = tmodel;
		this.tpath = tpath;
		this.tcontent = tcontent;
		this.taddress = taddress;
		this.turl = turl;
		this.status = status;
	}
    
    public String Add()
    {
    	
    	try {
			Session session=HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			//--------------------------------------------------
			session.clear();
			String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
	        
			  

            // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
			
			
			
			  if (tid != null) {
				  String fnameString=realpath+tname+".jpg";
				  String path1="http://localhost:8080/struts2/upload/"+tname+".jpg";
				  System.out.print("--"+fnameString);  
				  File savefile = new File(new File(realpath), tname+".jpg");
		            
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(tpath, savefile);
		            ActionContext.getContext().put("message", "文件上传成功");
		            
		            Product product=new Product();
		            product.setTid(tid);
		            product.setTaddress(taddress);
		            product.setTmodel(tmodel);
		            product.setTcontent(tcontent);
		            product.setTname(tname);
                    product.setPath(path1);
                    product.setTclassify(tclassify);
                    product.setturl(turl);
                    product.setStatus(false);
		             product.setIsNormal(1);
		            session.save(product);
		            
		            transaction.commit();
					  
		           
		    		
		    		Query query=session.createQuery("from Product  where isnormal=:normal");
		    		query.setParameter("normal", 1);
		    		if(query.list().size()>3)
		    		{
		    			query.setFirstResult(1);
			    		query.setMaxResults(3);
			    		length=(int)(query.list().size()/3);
		    		}
		    		
		    		
		    		
		    		java.util.List<Product> list1=query.list();
		    		
		    		
		    		
		    		for(Product p:list1)
		    		{
		    			list.add(p);
		    		}
		    		
		    		return "show_list";
		        }
			
			
		      System.out.println(this.toString());
			
			   
    	} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
    	
    	loadList();
    	return "showAdd";
    }
    public  void loadList()
    {
    	Session session=HibernateSessionFactory.getSession();
    	session.clear();
    	Transaction transaction=session.beginTransaction();
		
		Query query =session.createQuery("from Classify");
		classifyList=query.list();
		
    }
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "|---仪器信息: 仪器型号"+tid+" 名称 "+tname+" 仪器型号"+tmodel+" 图片路径"+tpath;
	}
	
	public String List()
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		
		session.clear();
		Query query =session.createQuery("from Product where isnormal=:normal");
		query.setParameter("normal", 1);
		
		
		length=(int)(query.list().size()/3);
		
		
	   	query.setFirstResult((first-1)*3);
		
		
		query.setMaxResults(3);
		
		java.util.List<Product> list1=query.list();
		for(Product p:list1)
		{
			list.add(p);
		}
		loadList();
		HttpSession session1=(HttpSession)ServletActionContext.getRequest().getSession();
		User user=(User) session1.getAttribute("user");
		if(user.getRole()==0)
		{
			return "show_list_u";
		}
		return "show_list";
	}
	
	
	
	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String Info()
	{
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		session.clear();
		 product=session.get(Product.class, tid);
		 
		return "info";
		
	}
	public String Update()
	{
		   Session session=HibernateSessionFactory.getSession();
		   Transaction transaction=session.beginTransaction();
		   session.clear();
		   product=session.get(Product.class, tid);
		   loadList();
			//--------------------------------------------------
			
			String realpath = ServletActionContext.getServletContext().getRealPath("/upload");
	        
			  

//因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
			
			
			 System.out.print(this.toString()+"-------------");
			  if (tname!= null) {
				  String fnameString=realpath+tname+".jpg";
				  
				  String path1="http://localhost:8080/struts2/upload/"+tname+".jpg";
				  System.out.print("--"+fnameString);  
				
		           if(tpath!=null)
		           {
		        	   File savefile = new File(new File(realpath), tname+".jpg");	   
			            if (!savefile.getParentFile().exists())
			                savefile.getParentFile().mkdirs();
			            try {
							FileUtils.copyFile(tpath, savefile);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		           }
		            ActionContext.getContext().put("message", "文件上传成功");
		            
		          
		            product.setTid(tid);
		            product.setTaddress(taddress);
		            product.setTmodel(tmodel);
		            product.setTcontent(tcontent);
		            product.setTname(tname);
                    product.setPath(path1);
                     product.setTclassify(tclassify);
                     product.setturl(turl);
                     
                    product.setStatus(false);
		           
		            session.update(product);
		            
		            transaction.commit();
					  
		          
		    		java.util.List<Product> list1=session.createQuery("from Product").list();
		    		for(Product p:list1)
		    		{
		    			list.add(p);
		    		}
		    		
		    		return "info";
		        }
			
			
		 
		 
		return "update";
		
	}
public boolean getStatus()
{
	return status;
}
	public String Delete()
	{
		 Session session=HibernateSessionFactory.getSession();
		  Transaction transaction=session.beginTransaction();
		  Product product=session.get(Product.class, tid);
		  Query query=session.createQuery("delete from DamageRegistration where tid=:id");
		  query.setString("id",tid);
		  
		  query.executeUpdate();
		  
		 session.delete(product);
		 transaction.commit();
			list=session.createQuery("from Product").list();
//			for(Product p:list1)
//			{
//				list.add(p);
//			}
		
		return "delete";
		
	}
	public String GetInfo()
	{
		if(tid!=null)
		{
			 Session session=HibernateSessionFactory.getSession();
			 Product product=(Product)session.get(Product.class, tid);
			 if(product.status)
			 {
				 JSONArray o=JSONArray.fromObject(product);
				 HttpServletResponse request=Tool.getResponse();
				 try {
					request.getWriter().print(o.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		}
			
			return  NONE;
	}
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
	
	public static void main(String[] args)
    {
		
    }
	
    
    
} 
