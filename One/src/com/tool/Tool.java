package com.tool;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.InsuranceExchangeDao;
import com.entity.InsuranceExchange;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
public class Tool {
    private static HttpSession httpSession; 
    
	public static HttpServletRequest getHttpServletRequest()
	{
		return ServletActionContext.getRequest();
	}
	public static HttpServletResponse getHttpServletResponse()
	{
		return ServletActionContext.getResponse();
	}
	public static HttpSession getHttpSession()
	{
	
		httpSession=getHttpServletRequest().getSession();
		return httpSession;
	}
	 /**  
     * 全局数组  
     */    
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",    
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };    
    private final static String KEY_MD = "SHA"; 
	  /**  
     * SHA 加密  ---------------------------
     * @param data 需要加密的字符串  
     * @return 加密之后的字符串  
     * @throws Exception  
     */    
    public static String encryptSHA(String data) throws Exception {    
        // 验证传入的字符串    
        if (data == null || data.equals("")) {    
            return "";    
        }    
        // 创建具有指定算法名称的信息摘要    
        MessageDigest sha = MessageDigest.getInstance(KEY_MD);    
        // 使用指定的字节数组对摘要进行最后更新    
        sha.update(data.getBytes());    
        // 完成摘要计算    
        byte[] bytes = sha.digest();    
        // 将得到的字节数组变成字符串返回    
        return byteArrayToHexString(bytes);    
    }    
    private static String byteArrayToHexString(byte[] bytes) {    
        StringBuffer sb = new StringBuffer();    
        for (int i = 0; i < bytes.length; i++) {    
            sb.append(byteToHexString(bytes[i]));    
        }    
        return sb.toString();    
    }  
    private static String byteToHexString(byte b) {    
        int ret = b;    
        //System.out.println("ret = " + ret);    
        if (ret < 0) {    
            ret += 256;    
        }    
        int m = ret / 16;    
        int n = ret % 16;    
        return hexDigits[m] + hexDigits[n];    
    }    
    
//    生成excel
    /*
     * flag=true 新增
     * flag=false 更新
*/ 
    public   static void createExcel( InsuranceExchange insuranceExchange,Boolean flag)
    {
// 	   InsuranceExchange insuranceExchange
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
 	  HSSFRow row17=sheet.createRow(18);
 	  HSSFRow row18=sheet.createRow(19);
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
 	  
 	   row17.createCell(8).setCellValue("员工号");
 	   row18.createCell(8).setCellValue("创建时间");
 	  
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
 	  row16.createCell(10).setCellValue(insuranceExchange.getEnjoyLink());
 	 row17.createCell(10).setCellValue(insuranceExchange.getUseNumber());
 	 row18.createCell(10).setCellValue(insuranceExchange.getCreateTime());
 	   //输出Excel文件  
 	   FileOutputStream output=null;
 	try {
 		
      String path=Tool.getHttpServletRequest().getSession().getServletContext().getRealPath("/")+"\\doc\\";
      File filepathFile=new File(path);
      if(!filepathFile.exists())
      {
    	  filepathFile.mkdir();
      }
      File file=new File(path+insuranceExchange.getId()+".xls");
      if(file.exists())
      {
    	  file.delete();
      }
 	
      if(flag)
      {
    		output = new FileOutputStream( path+(InsuranceExchangeDao.getList().size()+1)+".xls");
      }else{
    		output = new FileOutputStream( path+insuranceExchange.getId()+".xls");
      }
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
// 	   Tool.getHttpServletRequest().getSession().getServletContext().getRealPath("/");
    }
   public static void deleteExcel(InsuranceExchange insuranceExchange)
   {
	   File file=new File(Tool.getHttpServletRequest().getSession().getServletContext().getRealPath("/")+"\\doc\\"+insuranceExchange.getId()+".xls");
     if(file.exists())
     {
    	 System.out.println("@@@@@@@@@@@@@@@@@@@@@存在且删除");
    	 file.delete();
     }else{
    	 System.out.println("@@@@@@@@@@@@@@@@@@@@@不存在");
     }
   }
   
//   获取时间
   
   public static String getTime()
   {
	   return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
   }
    
}
