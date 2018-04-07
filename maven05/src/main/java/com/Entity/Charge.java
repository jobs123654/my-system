package com.Entity;
/*
*订单类
*/
public class Charge {
//  private String orderNumber;//订单号 20180404163910 准确时间
  private float amount;//金额
  private String currency="cny";//币种
  private String body;//内容
  private String order_no;//订单号
  private String client_ip;//客户端ip
 
  private String subject;//主题
  private String channel;//支付渠道
  private String appid;//app id
  
public Charge(float amount, String body, String order_no, String client_ip, String subject, String channel,String appid) {
	super();
	this.amount = amount;
	this.body = body;
	this.order_no = order_no;
	this.client_ip = client_ip;
	this.subject = subject;
	this.channel = channel;
	this.appid=appid;
}
/**
 * @return the amount
 */
public float getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(float amount) {
	this.amount = amount;
}
/**
 * @return the currency
 */
public String getCurrency() {
	return currency;
}
/**
 * @param currency the currency to set
 */
public void setCurrency(String currency) {
	this.currency = currency;
}
/**
 * @return the body
 */
public String getBody() {
	return body;
}
/**
 * @param body the body to set
 */
public void setBody(String body) {
	this.body = body;
}
/**
 * @return the order_no
 */
public String getOrder_no() {
	return order_no;
}
/**
 * @param order_no the order_no to set
 */
public void setOrder_no(String order_no) {
	this.order_no = order_no;
}
/**
 * @return the client_ip
 */
public String getClient_ip() {
	return client_ip;
}
/**
 * @param client_ip the client_ip to set
 */
public void setClient_ip(String client_ip) {
	this.client_ip = client_ip;
}

/**
 * @return the appid
 */
public String getAppid() {
	return appid;
}
/**
 * @param appid the appid to set
 */
public void setAppid(String appid) {
	this.appid = appid;
}
/**
 * @return the subject
 */
public String getSubject() {
	return subject;
}
/**
 * @param subject the subject to set
 */
public void setSubject(String subject) {
	this.subject = subject;
}
/**
 * @return the channel
 */
public String getChannel() {
	return channel;
}
/**
 * @param channel the channel to set
 */
public void setChannel(String channel) {
	this.channel = channel;
}
public Charge() {
	super();
}
  
}
