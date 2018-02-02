package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.GenericGenerator;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tool.HibernateSessionFactory;
import com.tool.Log;

@Entity
public class Classify extends ActionSupport {
   @Id
   @GeneratedValue(generator="cid")
   @GenericGenerator(name="cid",strategy="assigned")
   @Column(length=4)
	private String cid;
    private String cname;
    
    private String content;//备注
    //一方持有多方的集合-------------------------------------
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name="cid")
    
    private Set< Product> products;
    
    @Transient
    private List<Product> result=new ArrayList<Product>();
    //------------------------------------------------------
	
  
@Transient
   private List<Classify> classifies=new ArrayList<Classify>();
   
   public List<Product> getResult() {
	return result;
}

public void setResult(List<Product> result) {
	this.result = result;
}
@Transient
   private Classify classify;
   
	public Classify getClassify() {
	return classify;
}

public void setClassify(Classify classify) {
	this.classify = classify;
}

	public Classify() {
		super();
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
	
	public String Result()
	{
		if(cname!=null)
		{
		Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from Product where tclassify =:name");
		query.setString("name", cname.trim());
		transaction.commit();
		result=query.list();
		}
		System.out.print("------"+cname);
		return "result";
	}
    public Classify(String cid, String cname, String content) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.content = content;
	}
    
	public List<Classify> getClassifies() {
		return classifies;
	}

	public void setClassifies(List<Classify> classifies) {
		this.classifies = classifies;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    public  void loadList()
    {
    	Session session=HibernateSessionFactory.getSession();
		Transaction transaction=session.beginTransaction();
		session.clear();
		Query query =session.createQuery("from Classify");
		classifies=query.list();
    }
	public String ClassifyList()
    {
      loadList();	
    	return "show_list";
    }
	
	public String Add()
	{
		try {
			Session session=HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			Classify classify=new Classify(cid,cname,content);
			
			session.save(classify);
			
			
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			return "o_error";
		}
		loadList();
		return "show_list";
		
		
	}
	
	public String Update()
	{
		Log.log("---"+cid);
		try {
			Session session=HibernateSessionFactory.getSession();
			Transaction transaction=session.beginTransaction();
			classify=session.get(Classify.class, cid);
			if(cid!=null&&cname==null)
			{
				
				
				
				
				return "update";
				
				
			}else{
				classify.setCid(cid);
				classify.setCname(cname);
				classify.setContent(content);
				session.update(classify);
				transaction.commit();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
		loadList();
		return "show_list";	
	
	}
     /*级联处理
      * 
      * 
      * */
	public String Delete()
	{
		try {
			if(cid!=null)
			{
				Session session=HibernateSessionFactory.getSession();
				Transaction transaction=session.beginTransaction();
				Classify classify=session.get(Classify.class, cid);
				String cname=classify.getCname();
				
				Query query=session.createQuery("delete from Product where tclassify=:name");
				query.setString("name", cname);
				query.executeUpdate();
			   
				Query query1=session.createQuery("from Product where tclassify=:name");
				
				
				
				session.delete(classify);
				
				transaction.commit();
				loadList();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			
		}
		return "show_list";	
	}
	
    
}
