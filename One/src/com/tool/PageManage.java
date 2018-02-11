	package com.tool;
	
	import java.util.ArrayList;
	import java.util.List;

import org.hibernate.Query;

import com.entity.InsuranceExchange;
	
	public class PageManage {
   private int first=0;//起始点
   
   private int offset;//偏移量
   
   private int max=2;//每一页记录数量
   
   private int total;//总记录数
   
   private int totalpage;//总页数
   
   private int currentpage=1;//当前页
   
   private Query query;
   
   
   public int getCurrentpage() {
	return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getTotalpage() {
		this.totalpage=(datalist.size()%max)==0?(int) Math.floor( datalist.size()/max):(int) Math.floor( datalist.size()/max)+1;

		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	private List<InsuranceExchange>datalist=new ArrayList<InsuranceExchange>();//数据源
	   
   
	
	public PageManage(int c, int max, Query query) {
	super();
	currentpage=c;
	this.max = max;
	this.datalist=query.list();
   this.totalpage=getTotalpage();
//	query.setFirstResult(getOffset());
//	
//	query.setMaxResults(max);
	
	query.setFirstResult(getOffset());
	
	query.setMaxResults(max);


	
    }
	public PageManage(int max, List<InsuranceExchange> datalist) {
		super();
		this.max = max;
		this.datalist = datalist;
		
	}
	public PageManage() {
	super();
}
	public List<InsuranceExchange> getDatalist() {
	return datalist;
    }
	public void setDatalist(List<InsuranceExchange> datalist) {
		this.datalist = datalist;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getOffset() {
		return (currentpage-1)*max;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getTotal() {
		return datalist.size();
	}
	public void setTotal(int total) {
		this.total = total;
	}
	   
   
}
