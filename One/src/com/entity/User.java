package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements BaseEntity{

 
 private String useNumber;//工号
 private String userPassword;//密码
 private String userName;//姓名
 private int userSex;//性别
 private String userNumber;//电话
 
 
 @Transient
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
@Id
@GeneratedValue(generator="id")
@GenericGenerator(name="id",strategy="assigned")
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
	return " Id:"+useNumber+" Up:"+userPassword+"  "+userName+"  "+userSex+" "+userNumber;
}
 
 
}
