package com.model;

public class JP {
  private Product product;
  private Request request;
public JP() {
	super();
}
public JP(Product product, Request request) {
	super();
	this.product = product;
	this.request = request;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Request getRequest() {
	return request;
}
public void setRequest(Request request) {
	this.request = request;
}
}
