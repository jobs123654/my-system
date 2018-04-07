package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements BaseEntity{
	 /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		User obj=(User)o;
		// TODO Auto-generated method stub
		return id.equals(obj.getId())&&password.equals(obj.getPassword());
	}

  	 @Id
	 @GeneratedValue(generator="id")
	 @GenericGenerator(name="id",strategy="assigned")
	 @Column(unique=true)
	private String  id;

	private String name;
   
	private String password;
	
	private String identity;//身份证
	
	private int sex;//性别
	
    private String phone;//手机号
	
    private String picpath;//头像路径
    
    private int role=0;//角色id
	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	

	/**
	 * @return the identity
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * @param identity the identity to set
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/**
	 * @return the id
	 */
	

	/**
	 * @return the picpath
	 */
	public String getPicpath() {
		return picpath;
	}

	/**
	 * @param picpath the picpath to set
	 */
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	 
	
}
