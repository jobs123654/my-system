package com.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
  public static String getDate()
  {
	  return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }
  public static int dayForWeek(String pTime) throws Exception {  
	SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");  
	  Calendar c = Calendar.getInstance();  
	  c.setTime(format.parse(pTime));  
	  int dayForWeek = 0;  
	  if(c.get(Calendar.DAY_OF_WEEK) == 1){  
	   dayForWeek = 7;  
	  }else{  
	   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;  
	  }  
	  return dayForWeek;  
	 }  
		public static void main(String[] a) {
   String string="1,2,3";
   String []s=string.split(",");
    for(String i:s)
    {
   System.out.print(i+"  ");    	
    }
 }
}

