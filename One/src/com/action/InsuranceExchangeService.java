package com.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import org.hibernate.Query;
import org.hibernate.Session;

import com.action.BaseAction;
import com.dao.InsuranceExchangeDao;
import com.entity.InsuranceExchange;
import com.entity.User;
import com.tool.HibernateSessionFactory;
import com.tool.PageManage;
import com.tool.QueryModel;
import com.tool.Tool;

import net.sf.json.JSONArray;

public class InsuranceExchangeService extends BaseAction {

	/**
	 * 
	 */
       private List<InsuranceExchange>list=new ArrayList<InsuranceExchange>();
	   private static final long serialVersionUID = 1L;
	   private InsuranceExchange insuranceExchange;
	   private QueryModel queryModel;
	   
	   private PageManage pageManage;
	   
	   
		public PageManage getPageManage() {
		return pageManage;
	   }
	   public void setPageManage(PageManage pageManage) {
		this.pageManage = pageManage;
	   }
		public QueryModel getQueryModel() {
		return queryModel;
		}
		public void setQueryModel(QueryModel queryModel) {
			this.queryModel = queryModel;
		}
		public InsuranceExchange getInsuranceExchange() {
		return insuranceExchange;
	    }
		public void setInsuranceExchange(InsuranceExchange insuranceExchange) {
			this.insuranceExchange = insuranceExchange;
		}
//	显示业务
	public String show()
	{
		BaseAction.getSession().clear();
		Query query=BaseAction.getSession().createQuery("from  InsuranceExchange");
	    pageManage=new PageManage(1,20,query);
		list=query.list();
		return "show";
	}
	
	
	/*分页处理*/
	public String getInfo()
	{
	BaseAction.getSession().clear();
	Query query=BaseAction.getSession().createQuery("from  InsuranceExchange");
	
    int pString=pageManage.getCurrentpage();
    pageManage.setMax(20);
    pageManage.setDatalist(query.list());
    query.setFirstResult(pageManage.getOffset());
	
    query.setMaxResults(20);
    
	list=query.list();

	return "show";		
	}
	
	
	
	 /*添加信息*/
		public String add()
		{
			User user=(User) Tool.getHttpServletRequest().getSession().getAttribute("user");
			insuranceExchange.setUseNumber(user.getUseNumber());
			baseEntity=insuranceExchange;
            Tool.createExcel(insuranceExchange,true);
			super.add();
		return show();
		}
		
		public List<InsuranceExchange> getList() {
			return list;
		}
		public void setList(List<InsuranceExchange> list) {
			this.list = list;
		}
		/*修改*/
		public String update()
		{
			
			
			if(insuranceExchange.getXianName()!=null)
			{
				System.out.println("--------------------------------"+insuranceExchange.getEnjoyNumber());
				
				baseEntity=insuranceExchange;
				Tool.createExcel(insuranceExchange,false);
				try {

					super.update();
					
				} catch (Exception e) {
					// TODO: handle exception
				e.printStackTrace();
				}
				return show();
			}
			
			   insuranceExchange=(InsuranceExchange)BaseAction.getSession().get(InsuranceExchange.class, insuranceExchange.getId());
			    return "update";
		}
	    /*删除*/
		public String delete()
		{
			baseEntity=insuranceExchange;
			Tool.deleteExcel(insuranceExchange);
			return super.delete();
		}
//		获取信息 通过员工号
		public String getInsuranceExchangeInfo()
		{
			List<InsuranceExchange> list=InsuranceExchangeDao.getInsuranceExchangeList(insuranceExchange.getUseNumber());
			JSONArray jsonArray=JSONArray.fromObject(list);
//			try {
////				response.getOutputStream().write(jsonArray.toString().getBytes());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return NONE;
		}
		public String getResult()
		{
			Query query=null;
			Session session=HibernateSessionFactory.getSession();
			
				if(insuranceExchange!=null&&insuranceExchange.getOrderName()!=null)
				{
//					投保人
					query=session.createQuery("from InsuranceExchange where orderName like ?");
					list=query.setParameter(0, "%"+insuranceExchange.getOrderName()+"%").list();
				}
				else if(insuranceExchange!=null&&insuranceExchange.getXianName()!=null)
				{
//					保险名称
					query=session.createQuery("from InsuranceExchange where xianName like ?");
					list=query.setParameter(0, "%"+insuranceExchange.getXianName()+"%").list();
				}else{
				
					query=session.createQuery("from InsuranceExchange");
				   List<InsuranceExchange>	list0=query.list();
					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
					if(queryModel.getEndTime()!=null&&queryModel.getStartTime()!=null)
					{
						for(InsuranceExchange i:list0)
						{
							try {
								Date s=simpleDateFormat.parse(queryModel.getStartTime());
								Date e=simpleDateFormat.parse(queryModel.getEndTime());
								if(i.getCreateTime()!=null&&s.compareTo(simpleDateFormat.parse(i.getCreateTime()))<0&&e.compareTo(simpleDateFormat.parse(i.getCreateTime()))>0)
								{
									list.add(i);
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
				}
				
				
				
		
			return "result";
		}
		public String getinsuranceExchangeInfo()
		{
			if((Object)insuranceExchange.getId()!=null)
			{
				insuranceExchange=BaseAction.getSession().get(InsuranceExchange.class,insuranceExchange.getId());
			}
			return "info";
		}
}
