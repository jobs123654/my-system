package com.dao;

import com.itf.Myinterface;

public class BaseDao {
	
	private Myinterface myinterface;
	
   public Myinterface getMyinterface() {
		return myinterface;
	}

	public void setMyinterface(Myinterface myinterface) {
		this.myinterface = myinterface;
	}

public void deal()
   {
	   myinterface.showInfo();
   }
}
