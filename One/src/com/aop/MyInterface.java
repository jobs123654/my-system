package com.aop;

public interface MyInterface {
  default void check(){
	System.out.println("there is a asp！");  
  }
}
