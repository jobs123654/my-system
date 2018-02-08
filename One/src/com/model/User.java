package com.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.itf.Myinterface;

public class User {
 
private String name;
  private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return name+"  "+password;
}

public void showInfo() {
	// TODO Auto-generated method stub
	System.out.println(this);
}

public void show()
{
	System.out.println("hhh");
}
  
}
