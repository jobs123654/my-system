package com.model;

import com.itf.Myinterface;

public class Animal implements Myinterface{
    private String name;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println(this);
	}
 
}
