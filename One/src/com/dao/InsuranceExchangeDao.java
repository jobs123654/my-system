package com.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.entity.BaseEntity;
import com.entity.InsuranceExchange;

public class InsuranceExchangeDao extends BaseDao{
	
//	 添加信息
	 public static Boolean isAdd(InsuranceExchange insuranceExchange)
	 {
     return BaseDao.isAdd(insuranceExchange);
	 }
//	 修改
	 public static Boolean isUpdate(BaseEntity baseEntity)
	 {
		 
		 
		 InsuranceExchange  insured=(InsuranceExchange )baseEntity;
		 InsuranceExchange i=BaseDao.session.get(InsuranceExchange .class,insured.getId());
		 i.setOrderBirthday(insured.getOrderBirthday());
         i.setOrderCardNumber(insured.getOrderCardNumber());
         i.setOrderCardType(insured.getEnjoyCardType());
         i.setOrderEmail(insured.getOrderEmail());
         i.setOrderName(insured.getOrderName());
         i.setOrderSex(insured.getOrderSex());
         
		 i.setEnjoyBirthday(insured.getEnjoyBirthday());
		 i.setEnjoyCardNumber(insured.getEnjoyCardNumber());
		 i.setEnjoyCardType(insured.getEnjoyCardType());
		 i.setEnjoyEmail(insured.getEnjoyEmail());
		 i.setEnjoyLink(insured.getEnjoyLink());
		 i.setEnjoyName(insured.getEnjoyName());
		 i.setEnjoySex(insured.getEnjoySex());
		 i.setXianEndDate(insured.getXianEndDate());
		 i.setXianName(insured.getXianName());
		 i.setXianStartDate(insured.getXianStartDate());
      return BaseDao.isUpdate(i);
	 }
//	 删除
	 public static Boolean isDelete(BaseEntity baseEntity)
	 {
		 InsuranceExchange insured=(InsuranceExchange)baseEntity;
		 return BaseDao.isDelete(session.get(InsuranceExchange.class, insured.getId()));
	 }
	 public static List<InsuranceExchange> getList()
	 {
		 return session.createQuery("from InsuranceExchange").list();
	 }
    public static InsuranceExchange getInsuranceExchange(int id)
    {
   	 return session.get(InsuranceExchange.class, id);
    }
	public static List<InsuranceExchange> getInsuranceExchangeList(String id)
	{
		Query query=session.createQuery("from InsuranceExchange where useNumber=?");
		query.setParameter(0, id);
		List<InsuranceExchange> list=query.list();
		return list;
	}
}
