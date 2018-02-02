package com.tool;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DB  extends TimerTask{
    private ServletContext context=null;
    private final Log log = LogFactory.getLog(getClass());
    public  DB(ServletContext context) {
        this.context=context;
    }
     public static boolean exportDatabaseTool(String userName, String password, String SID, String savePath, String fileName) throws InterruptedException {  
            File saveFile = new File(savePath);  
            if (!saveFile.exists()) {// 如果目录不存在  
                saveFile.mkdirs();// 创建文件夹  
            }  
            try {  
                Process process = Runtime.getRuntime().exec("exp " + userName + "/" + password + "@" + SID + " file=" + savePath + "/" + fileName + ".dmp");  
                if(process.waitFor() == 0){//0 表示线程正常终止。   
                    return true;  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
            return false;  
        }  
    @Override
    public void run() {
        Format format = new SimpleDateFormat("yyyyMMdd");
        String filePathString="MJku"+format.format(new Date());
          try {
            if (exportDatabaseTool("rfxmujuku", "rfx", "orcl", "D:/MuJuKuDBBeiFen", filePathString)) {  
                    System.out.println("数据库成功备份！！！");  
                } else {  
                    System.out.println("数据库备份失败！！！");  
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
        
    }

}