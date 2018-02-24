package com.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
   
   @NotEmpty(message="用户名不能为空！")
//   @Size(min=3,max=6,message="姓名长度应该在{min}-{max}之间")
   private String name;
//   @Pattern(regexp="[0-9a-zA-Z]{6,10}",message="密码必须包含字母数字 位数为6~10")
   private String pwd;
   @NotEmpty(message="邮箱")
//   @Email(message="非邮箱")
   private String email;
   
   private String number;
  
   private int score;
	public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"   "+pwd;
	}
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

}
