package com.Tool;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Entity.Secure;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
public class Tool {
    private static HttpSession httpSession; 
    
    public static String getCTime()
    {
    	return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    }
    
    public static HttpServletRequest getHttpServletRequest()
    {
    	 RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    	 HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
    	return request;
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
    public   static void createExcel( Secure insuranceExchange,Boolean flag)
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
 	 HSSFRow row19=sheet.createRow(20);
 	 HSSFRow row20=sheet.createRow(21);
 	 
 	  row1.createCell(8).setCellValue("投保人姓名");
 	  row2.createCell(8).setCellValue("证件类型");
 	  row3.createCell(8).setCellValue("证件号码");
 	  row4.createCell(8).setCellValue("出生日期");
 	  row5.createCell(8).setCellValue("投保人性别");
 	  row6.createCell(8).setCellValue("投保人手机号");
 	 row7.createCell(8).setCellValue("投保人邮箱");
 	  row8.createCell(8).setCellValue("被保人姓名");
 	  row9.createCell(8).setCellValue("证件类型");
 	  row10.createCell(8).setCellValue("证件号码");
 	  row11.createCell(8).setCellValue("出生日期");
 	  row12.createCell(8).setCellValue("被保人性别");
 	  row13.createCell(8).setCellValue("被保人手机号");
 	  row14.createCell(8).setCellValue("被保人邮箱");
 	  
 	  row15.createCell(8).setCellValue("保险名称");
 	  row16.createCell(8).setCellValue("开始日期");
 	  row17.createCell(8).setCellValue("结束日期");
 	  row18.createCell(8).setCellValue("与投保人关系");
 	  
 	   row19.createCell(8).setCellValue("员工号");
 	   row20.createCell(8).setCellValue("创建时间");
 	  
 	 /* row1.createCell(10).setCellValue(insuranceExchange.getOrderName());
 	  
 	  row2.createCell(10).setCellValue(insuranceExchange.getOrderCardType());
 	  row3.createCell(10).setCellValue(insuranceExchange.getOrderCardNumber());
 	  row4.createCell(10).setCellValue(insuranceExchange.getOrderBirthday());
 	  row5.createCell(10).setCellValue(insuranceExchange.getOrderSex()==0?"男":"女");
 	  row6.createCell(10).setCellValue(insuranceExchange.getOrderNumber());
 	  row7.createCell(10).setCellValue(insuranceExchange.getOrderEmail());
 	 
 	  row8.createCell(10).setCellValue(insuranceExchange.getEnjoyName());
 	  row9.createCell(10).setCellValue(insuranceExchange.getEnjoyCardType());
 	  row10.createCell(10).setCellValue(insuranceExchange.getEnjoyCardNumber());
 	  row11.createCell(10).setCellValue(insuranceExchange.getEnjoyBirthday());
 	  row12.createCell(10).setCellValue(insuranceExchange.getEnjoySex()==0?"男":"女");
 	 row13.createCell(10).setCellValue(insuranceExchange.getEnjoyNumber());
 	  row14.createCell(10).setCellValue(insuranceExchange.getEnjoyEmail());
 	  row15.createCell(10).setCellValue(insuranceExchange.getXianName());
 	  row16.createCell(10).setCellValue(insuranceExchange.getXianStartDate());
 	  row17.createCell(10).setCellValue(insuranceExchange.getXianEndDate());
 	  row18.createCell(10).setCellValue(insuranceExchange.getEnjoyLink());
 	  row19.createCell(10).setCellValue(insuranceExchange.getUseNumber());
 	  row20.createCell(10).setCellValue(insuranceExchange.getCreateTime());*/
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
//    		output = new FileOutputStream( path+(InsuranceExchangeDao.getList().size()+1)+".xls");
      }else{
    		output = new FileOutputStream( path+(insuranceExchange.getId()-1)+".xls");
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
   public static void deleteExcel(Secure insuranceExchange)
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
  /* 数据库备份*/
   public static void backupMysqlDatabase(String dbpath, String hostName,String dataBase,String userName, 
		   String passwd,String outFilePath )throws Exception { 
//		还原一个数据库:mysql -h localhost -u root -p123456 www
//
//
//		备份一个数据库:mysqldump -h localhost -u root -p123456 www > d:\www2008-2-26.sql
		   //组装MySQL的备份命令 
		   StringBuilder sqlStr = new StringBuilder(); 
		   sqlStr.append(dbpath+"/bin/mysqldump -u").append(userName) .append(" -p").append(passwd) 
		   .append(" ").append(dataBase); 
		   if(hostName != null &&!hostName.equals("") ){ 
		   sqlStr.append("");
		   
		   System.out.println(sqlStr+"**************************");
		   } 
		   // --default-character-set=gb2312 
		   //调用系统cmd 命令执行备份命令 
		   Runtime rt = Runtime.getRuntime(); 
		   Process process = rt.exec(sqlStr.toString()); 
		   InputStream in = process.getInputStream();//控制台的输出信息作为输入流 
		   InputStreamReader isr = new InputStreamReader(in,"utf8"); StringBuilder sb = new StringBuilder(""); 
		   String inStr; 
		   //组合控制台输出信息字符串 
		   BufferedReader br = new BufferedReader(isr); 
		   while((inStr = br.readLine()) != null){ 
		   sb.append(inStr) 
		   .append("rn"); 
		   }//把备份数据写入到文件中 
		   FileOutputStream fout = new FileOutputStream (outFilePath); 
		   OutputStreamWriter writer = new OutputStreamWriter(fout,"utf8"); 
		   writer.write(sb.toString()); 
		   writer.flush(); 
		   //写完文件,关闭相应的流 
		   in.close(); 
		   isr.close(); 
		   br.close(); 
		   writer.close(); 
		   fout.close(); 
		   }
   public static void recoverDb(String dbpath, String hostName,String dataBase,String userName, 
		   String passwd,String fPath) throws Exception
         {
	       Runtime rt = Runtime.getRuntime(); 
	       String sqlStr = ""; 
	       sqlStr=dbpath+"/bin/mysql -u "+userName+" -p "+passwd+" "+dataBase; 
	            Process child;
				
	    
	            InputStreamReader in;
	            child = rt.exec(sqlStr.toString());

				in = new InputStreamReader(new FileInputStream(fPath),"UTF-8");
				BufferedReader br =new BufferedReader(in);
		          
	            String inStr =null;
	            StringBuffer sb = new StringBuffer("");
	            String outStr;
	            outStr = sb.toString();
	            
		           
			    
	            OutputStream out = child.getOutputStream();
	            OutputStreamWriter writer =new OutputStreamWriter(out,"UTF-8");
	            writer.write(outStr);
	            writer.flush();
	            
	            out.flush();
	            out.close();     
	            br.close();     
	            writer.close();  
				
				
	          System.out.println("数据恢复成功！");
   }
 //启动备份任务
 	public static void startDbback(String dbpath, String hostName,String dataBase,String userName, 
 		   String passwd,String outFilePath)
 	{

 		TimerTask timerTask=new TimerTask() {
 			
 			@Override
 			public void run() {
 				// TODO Auto-generated method stub
 			try {
//				backupMysqlDatabase(dbpath, hostName, dataBase, userName, passwd, outFilePath);
				System.out.println("备份成功！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("备份失败！");
			}
 			
 			}
 		};
 		int time=7*24*60*60*1000;
      java.util.Timer timer=new java.util.Timer();
      timer.schedule(timerTask, 0, time);
      
 	}
	   public static void main(String[]a)
	   {
//		   ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")
		   String hostName ="192.168.26.200"; 
		   String dataBase ="safe";//is 
		   String userName ="root"; 
		   String passwd ="wdy123654"; 
		   String outFilePath ="D:/backupmysql.sql"; try { 
//		   backupMysqlDatabase("11",hostName,dataBase, userName, passwd, outFilePath); 
			  
			   }catch (Exception e) {
				// TODO: handle exception
			   e.printStackTrace();
			   }
		   
	   }
    
}
