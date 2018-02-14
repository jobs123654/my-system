package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.New;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.entity.InsuranceExchange;
import com.tool.Tool;


public class Test01 {
   static void createExcel( InsuranceExchange insuranceExchange)
   {
//	   InsuranceExchange insuranceExchange
	   //创建HSSFWorkbook对象  
	   HSSFWorkbook wb = new HSSFWorkbook();  
	   //创建HSSFSheet对象  
	   HSSFSheet sheet = wb.createSheet("sheet0");  
	   //创建HSSFRow对象  
	   HSSFRow row = sheet.createRow(0);  
	   //创建HSSFCell对象  
	   HSSFRow row0=sheet.createRow(0);  
	  //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
	  HSSFCell cell=row0.createCell(9);  
	       //设置单元格内容  
	  cell.setCellValue("交易记录表");  
	  //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
	  sheet.addMergedRegion(new CellRangeAddress(0,0,9,10));  
	  
	   HSSFRow row1=sheet.createRow(2);
	   HSSFRow row2=sheet.createRow(3);
	   HSSFRow row3=sheet.createRow(4);
	   HSSFRow row4=sheet.createRow(5);
	   HSSFRow row5=sheet.createRow(6);
	   HSSFRow row6=sheet.createRow(7);
	   HSSFRow row7=sheet.createRow(8);
	   HSSFRow row8=sheet.createRow(9);
	   HSSFRow row9=sheet.createRow(10);
	   HSSFRow row10=sheet.createRow(11);
	   
	   HSSFRow row11=sheet.createRow(12);
	   HSSFRow row12=sheet.createRow(13);
	   HSSFRow row13=sheet.createRow(14);
	   HSSFRow row14=sheet.createRow(15);
	   HSSFRow row15=sheet.createRow(16);
	   HSSFRow row16=sheet.createRow(17);
	   
	   
	  row1.createCell(8).setCellValue("投保人姓名");
	  row2.createCell(8).setCellValue("证件类型");
	  row3.createCell(8).setCellValue("证件号码");
	  row4.createCell(8).setCellValue("出生日期");
	  row5.createCell(8).setCellValue("投保人性别");
	  row6.createCell(8).setCellValue("投保人邮箱");
	  
	  row7.createCell(8).setCellValue("被保人姓名");
	  row8.createCell(8).setCellValue("证件类型");
	  row9.createCell(8).setCellValue("证件号码");
	  row10.createCell(8).setCellValue("出生日期");
	  row11.createCell(8).setCellValue("被保人性别");
	  row12.createCell(8).setCellValue("被保人邮箱");
	  row13.createCell(8).setCellValue("保险名称");
	  row14.createCell(8).setCellValue("开始日期");
	  row15.createCell(8).setCellValue("结束日期");
	  row16.createCell(8).setCellValue("与投保人关系");
	  
	  row1.createCell(10).setCellValue(insuranceExchange.getOrderName());
	  row2.createCell(10).setCellValue(insuranceExchange.getOrderCardType());
	  row3.createCell(10).setCellValue(insuranceExchange.getOrderCardNumber());
	  row4.createCell(10).setCellValue(insuranceExchange.getOrderBirthday());
	  row5.createCell(10).setCellValue(insuranceExchange.getOrderSex());
	  row6.createCell(10).setCellValue(insuranceExchange.getOrderEmail());
	  row7.createCell(10).setCellValue(insuranceExchange.getEnjoyName());
	  row8.createCell(10).setCellValue(insuranceExchange.getEnjoyCardType());
	  row9.createCell(10).setCellValue(insuranceExchange.getEnjoyCardNumber());
	  row10.createCell(10).setCellValue(insuranceExchange.getEnjoyBirthday());
	  row11.createCell(10).setCellValue(insuranceExchange.getEnjoySex());
	  row12.createCell(10).setCellValue(insuranceExchange.getEnjoyEmail());
	  row13.createCell(10).setCellValue(insuranceExchange.getXianName());
	  row14.createCell(10).setCellValue(insuranceExchange.getXianStartDate());
	  row15.createCell(10).setCellValue(insuranceExchange.getXianEndDate());
	  row16.createCell(10).setCellValue("与投保人关系");
	   //输出Excel文件  
	   FileOutputStream output=null;
	try {
		output = new FileOutputStream("d:\\root.xls");
	
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}  
	   try {
		wb.write(output);
		output.flush();  
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
//	   Tool.getHttpServletRequest().getSession().getServletContext().getRealPath("/");
   }
	public static void main(String[]a) {
      
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
  }
}
