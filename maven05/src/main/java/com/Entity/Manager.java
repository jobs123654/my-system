package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.Tool.Tool;

/*管理员账户*/
@Entity
public class Manager implements BaseEntity{
 
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 Manager manager=(Manager)obj;
		return  name.equals(manager.getName())&&pwd.equals(manager.getPwd());
	}

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=true)
	private String name;
	
	@Column(nullable=false)
	private String pwd;
	
	@Column(nullable=false,unique=true)
	private String phone;
	
	@Column(nullable=false,unique=true)
	private String email;
	
	
	private String time;
	
	

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = Tool.getCTime();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 * @throws Exception 
	 */
	public void setPwd(String pwd) throws Exception {
		this.pwd = Tool.encryptSHA(pwd);
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
