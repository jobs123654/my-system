package com.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Entity
@Embeddable 
public class Adress {
  private String code;
  private String adrString;
public Adress(String code, String adrString) {
	super();
	this.code = code;
	this.adrString = adrString;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Adress() {
	
}
public String getAdrString() {
	return adrString;
}
public void setAdrString(String adrString) {
	this.adrString = adrString;
}
  
}
