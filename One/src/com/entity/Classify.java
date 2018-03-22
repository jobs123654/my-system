package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Classify {
   private int id;
   
   private String cname;
   
   private int fid;
   
   private String intro;

	/**
	 * @return the id
	 */
   @Id
   @GeneratedValue
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
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	/**
	 * @return the fid
	 */
	public int getFid() {
		return fid;
	}
	
	/**
	 * @param fid the fid to set
	 */
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}
	
	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[Classify  "+id+"  "+cname+"  "+fid+"]";
	}
	   
	
	   
   
}
