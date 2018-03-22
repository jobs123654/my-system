package com.entity;

import org.apache.ibatis.cache.TransactionalCacheManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class User{

public User(String useNumber, String userPassword, String userName, int userSex, String userNumber, int role,
			Boolean isRemember) {
		super();
		this.useNumber = useNumber;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.userNumber = userNumber;
		this.role = role;
		this.isRemember = isRemember;
//		SqlSessionFactoryBean
//		DataSourceTransactionManager
//		ComboPooledDataSource
	}



private int id;
 public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

private String useNumber;//工号
 private String userPassword;//密码
 private String userName;//姓名
 private int userSex;//性别
 private String userNumber;//电话
 
 private int role;//权限默认为普通员工
 
 private Book book;
 /**
 * @return the book
 */
public Book getBook() {
	return book;
}

/**
 * @param book the book to set
 */
public void setBook(Book book) {
	this.book = book;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}

 public Boolean getIsRemember() {
	return isRemember;
}

public void setIsRemember(Boolean isRemember) {
	this.isRemember = isRemember;
}
private Boolean isRemember=false;
 
public User() {
	super();
}

public String getUserName() {
	return userName;
}

public int getUserSex() {
	return userSex;
}

public void setUserSex(int userSex) {
	this.userSex = userSex;
}

public void setUserName(String userName) {
	this.userName = userName;
}





public String getUserNumber() {
	return userNumber;
}

public void setUserNumber(String userNumber) {
	this.userNumber = userNumber;
}

public String getUseNumber() {
	return useNumber;
}
public void setUseNumber(String useNumber) {
	this.useNumber = useNumber;
}

public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public User(String useNumber, String userPassword) {
	super();
	this.useNumber = useNumber;
	this.userPassword = userPassword;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return id+" "+useNumber+" "+userPassword+"  "+userName+"  "+userSex+" "+userNumber;
}
 
 
}
