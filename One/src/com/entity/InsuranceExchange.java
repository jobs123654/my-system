package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;

import com.tool.HibernateSessionFactory;
@Entity
public class InsuranceExchange implements  BaseEntity{
	    private int id;//交易记录号
	   
	    private String xianName; //保险名称
		private String xianStartDate; //开始日期
	    private String xianEndDate; //结束日期
	    private String enjoyLink;   //与投保人关系
	    private String  enjoyName;  //姓名
	    private String  enjoyCardType; //证件类型
	    private String   enjoyCardNumber;//证件号码
	    private String  enjoyBirthday;//出生日期
	    private int enjoySex;//性别
	    private String  enjoyEmail;//邮箱
	   
	    private String orderCardNumber;//证件号码 
	    private String orderName;//姓名
	    private String orderCardType;//证件类型
	   
	    private String orderBirthday;//出生日期
	    private int orderSex;//性别
	    private String orderEmail;//邮箱
	    
	    private String useNumber;//员工号
	    
	    private String createTime;//创建时间
	    
	    public String getCreateTime() {
		return createTime;
	   }
	   public void setCreateTime(String createTime) {
		this.createTime = createTime;
	   }
		public String getUseNumber() {
			return useNumber;
		}
		public void setUseNumber(String useNumber) {
			this.useNumber = useNumber;
		}
		@Id
		@GeneratedValue
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getXianName() {
			return xianName;
		}
		public void setXianName(String xianName) {
			this.xianName = xianName;
		}
		public String getXianStartDate() {
			return xianStartDate;
		}
		public void setXianStartDate(String xianStartDate) {
			this.xianStartDate = xianStartDate;
		}
		public String getXianEndDate() {
			return xianEndDate;
		}
		public void setXianEndDate(String xianEndDate) {
			this.xianEndDate = xianEndDate;
		}
		public String getEnjoyLink() {
			return enjoyLink;
		}
		public void setEnjoyLink(String enjoyLink) {
			this.enjoyLink = enjoyLink;
		}
		public String getEnjoyName() {
			return enjoyName;
		}
		public void setEnjoyName(String enjoyName) {
			this.enjoyName = enjoyName;
		}
		public String getEnjoyCardType() {
			return enjoyCardType;
		}
		public void setEnjoyCardType(String enjoyCardType) {
			this.enjoyCardType = enjoyCardType;
		}
		public String getEnjoyCardNumber() {
			return enjoyCardNumber;
		}
		public void setEnjoyCardNumber(String enjoyCardNumber) {
			this.enjoyCardNumber = enjoyCardNumber;
		}
		public String getEnjoyBirthday() {
			return enjoyBirthday;
		}
		public void setEnjoyBirthday(String enjoyBirthday) {
			this.enjoyBirthday = enjoyBirthday;
		}
		public int getEnjoySex() {
			return enjoySex;
		}
		public void setEnjoySex(int enjoySex) {
			this.enjoySex = enjoySex;
		}
		public String getEnjoyEmail() {
			return enjoyEmail;
		}
		public void setEnjoyEmail(String enjoyEmail) {
			this.enjoyEmail = enjoyEmail;
		}
		public String getOrderCardNumber() {
			return orderCardNumber;
		}
		public void setOrderCardNumber(String orderCardNumber) {
			this.orderCardNumber = orderCardNumber;
		}
		public String getOrderName() {
			return orderName;
		}
		public void setOrderName(String orderName) {
			this.orderName = orderName;
		}
		public String getOrderCardType() {
			return orderCardType;
		}
		public void setOrderCardType(String orderCardType) {
			this.orderCardType = orderCardType;
		}
		public String getOrderBirthday() {
			return orderBirthday;
		}
		public void setOrderBirthday(String orderBirthday) {
			this.orderBirthday = orderBirthday;
		}
		public int getOrderSex() {
			return orderSex;
		}
		public void setOrderSex(int orderSex) {
			this.orderSex = orderSex;
		}
		public String getOrderEmail() {
			return orderEmail;
		}
		public void setOrderEmail(String orderEmail) {
			this.orderEmail = orderEmail;
		}
	   public static void main(String[]a)
	   {
		   Session session=HibernateSessionFactory.getSession();
	   }
	
}
