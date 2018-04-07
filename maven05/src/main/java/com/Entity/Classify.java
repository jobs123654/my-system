package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Classify implements BaseEntity{
  @Id
  @GeneratedValue
  private int id;
  private String cname;//分类名称
  private String uid;//创建人
  private String time;//创建时间
  private String fid;
/**
 * @return the fid
 */
public String getFid() {
	return fid;
}
/**
 * @param fid the fid to set
 */
public void setFid(String fid) {
	this.fid = fid;
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
 * @return the uid
 */
public String getUid() {
	return uid;
}
/**
 * @param uid the uid to set
 */
public void setUid(String uid) {
	this.uid = uid;
}
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
	this.time = time;
}
  
}
