package com.model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tool.HibernateSessionFactory;
import com.tool.Time;
import com.tool.Tool;

import freemarker.template.SimpleDate;
import net.sf.json.JSONArray;
@SuppressWarnings("serial")
@Entity
public class DamageRegistration extends ActionSupport{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(length=400)
    private String tid;
    
    private String msg;//详情
    
    private String status;//状态 --待修复//已修复
    
    private String time;//登记时间
    
    private int month;
    public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	@Transient
    private List<DamageRegistration> damageRegistrations=new ArrayList<DamageRegistration>();
    
    @Transient
    private DamageRegistration damageRegistration;
    
	public DamageRegistration getDamageRegistration() {
		return damageRegistration;
	}
	public void setDamageRegistration(DamageRegistration damageRegistration) {
		this.damageRegistration = damageRegistration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String DR()
	{
		Session session=HibernateSessionFactory.getSession();
		List<Object> classifies=session.createQuery("select month,count(*) as num from DamageRegistration  group by month").list();
		JSONArray jsonArray=JSONArray.fromObject(classifies);
		HttpServletResponse httpServletResponse=Tool.getResponse();
		System.out.println("----||"+jsonArray);
		httpServletResponse.setCharacterEncoding("utf-8");
		
		try {
			httpServletResponse.getWriter().print(jsonArray);
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return NONE;
	}
	public List<DamageRegistration> getDamageRegistrations() {
		return damageRegistrations;
	}
	public void setDamageRegistrations(List<DamageRegistration> damageRegistrations) {
		this.damageRegistrations = damageRegistrations;
	}
	public  void loadList()
	{
		Session session=HibernateSessionFactory.getSession();
		session.clear();
		Transaction transaction=session.beginTransaction();
		
		Query query =session.createQuery("from DamageRegistration");
		damageRegistrations=query.list();
	}
	/*
	 * 
	 * */
	public String Add()
	{
		
		if(tid!=null&&msg!=null)
		{
			Session session=HibernateSessionFactory.getSession();
			session.clear();
			Transaction transaction=session.beginTransaction();
			DamageRegistration damageRegistration=new DamageRegistration();
			damageRegistration.setTid(tid);
			damageRegistration.setMsg(msg);
			
			damageRegistration.setTime(Time.getDate());
			damageRegistration.setMonth(Integer.parseInt(new SimpleDateFormat("MM").format(new Date())));
			
			damageRegistration.setStatus("待修复");
			Product product=session.get(Product.class, tid);
			product.setIsNormal(0);
			session.save(product);
			session.save(damageRegistration);
			transaction.commit();
			loadList();
			return "list";
		}
		
		return "add";
	}
	public String Delete()
	{
		if((Object)id!=null)
		{
			Session session=HibernateSessionFactory.getSession();
			session.clear();
			Transaction transaction=session.beginTransaction();
			DamageRegistration damageRegistration=session.get(DamageRegistration.class, id);
			session.delete(damageRegistration);
			transaction.commit();
			
		}
		loadList();
		return "list";
	}
	public String Update()
	{
		Session session=HibernateSessionFactory.getSession();
		session.clear();
		Transaction transaction=session.beginTransaction();
		damageRegistration=session.get(DamageRegistration.class, id);
		if((Object)id!=null&&tid!=null&&msg!=null&&status!=null)
		{
			
			damageRegistration.setTid(tid);
			damageRegistration.setMsg(msg);
			damageRegistration.setTime(Time.getDate());
			damageRegistration.setStatus(status);
			if(status.equals("已修复"))
			{
				Product product=session.get(Product.class, tid);
				product.setIsNormal(1);
				session.update(product);
			}
				
			session.update(damageRegistration);
			transaction.commit();	
			loadList();
			return "list";	
		}
		return "update";
		
	}
	public String List()
	{
		loadList();
		return "list";
	}
	
}
