package com.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;





public class DOM {
 private static String  path;//out path
 private static String start;//start time of backups  
 private static String end;//
 private static String []special=new String[7];
 public static void init(String path,String start,String[]a)
 {
	 DOM.path=path;
	 DOM.start=start;
	 for(int i=0;i<a.length;i++)
	 {
		 special[i]=a[i];
	 }
//	 DOM.end=end;
 }
 //生成配置文件
  public static void createConfigure()
  {
	  Document document=DocumentHelper.createDocument();
	 document.addComment("system configure file");
	  
	  Element root=document.addElement("root");
    Element path=root.addElement("path");
   path.setText(DOM.path);
	  Element start_ele=root.addElement("start_time");
	  start_ele.setText(start);
	  
	  /*Element end_element=rootDocument.addElement("end_time");
	  
	  end_element.setText(end);*/
	  int i=0;
	  for(String s:special)
	  {
		  if(s!=null)
		  {
			  
			  Element item=root.addElement("sp"+i);
			  item.setText(s);  
		  }
		  
	  }
	  //写入
	  OutputFormat format = OutputFormat.createPrettyPrint();
	           //设置xml文档的编码为utf-8
	  File file=new File(DOM.path);
      if(file.exists())
      {
    	  file.delete();
      }        
	  format.setEncoding("utf-8");
	           Writer out;
	          try {
	              //创建一个输出流对象
	              out = new FileWriter(DOM.path);
	              
	               //创建一个dom4j创建xml的对象
	             XMLWriter writer = new XMLWriter(out, format);
	            //调用write方法将doc文档写到指定路径
	             writer.write(document);
	            writer.close();
	             System.out.print("生成配置文件成功");
	       } catch (IOException e) {
	               System.out.print("生成配置文件失败");
	               e.printStackTrace();
	           }
	  
  }
  //读出配置
  public static void readConfigure(String path)
  {
	  
	SAXReader reader=new SAXReader();
	Document document;
	try {
		 document=reader.read(path);
		 Element  root=document.getRootElement();
		 Element pt=(Element)root.element("path");
		 Element  st=(Element)root.element("start_time");
		 System.out.print("----"+pt.getText()+"  "+st.getText());
	} catch (DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
  }
  
  public static void main(String[]a)
  {
	 
	  String string="";
	  String nameString="default.bak";
	  File file = new File("d:\\root",nameString);  
		for(int i=0;i<20000;i++)
		{
			string+=i+"abc";
		}
		
		byte[]bt=new byte[10000];
		bt=string.getBytes();
		 System.out.print("-1--------------||");
		try {  
          FileOutputStream in = new FileOutputStream(file);  
          try {  
              in.write(bt, 0, bt.length);  
              in.close();  
		           //HttpServletResponse response=Tool.getResponse();
//		           response.getWriter().print("1");
		           System.out.print("-2--------------||");
              // boolean success=true;  
              // System.out.println("写入文件成功");  
          } catch (IOException e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }  
		}catch (Exception e) {
			 e.printStackTrace();  
			// TODO: handle exception
		}

  }
 
}
