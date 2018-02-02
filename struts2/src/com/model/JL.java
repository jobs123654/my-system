package com.model;

public class JL {
 private User user;
 private Request request;
public JL() {
	super();
}
public JL(User user, Request request) {
	super();
	this.user = user;
	this.request = request;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Request getRequest() {
	return request;
}
public void setRequest(Request request) {
	this.request = request;
}
}
