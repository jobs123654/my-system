package com.maven.dao;

import com.maven.entity.DispatchList;
import com.maven.ifa.DispatchListIfa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DispatchListDao {

       @Autowired private DispatchListIfa dispatchListIfa;

       @Autowired private Session session;

       private String getCustomId()
       {
          int c=dispatchListIfa.findAll().size()+1;
           SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
           String s="";

           return  simpleDateFormat.format(new Date())+ String.format("%04d", c);
       }
       public  void addOrUpdate(DispatchList dispatchList)
       {
           if(dispatchList.getId()==null)
           {
               dispatchList.setId(getCustomId());
           }
           dispatchListIfa.save(dispatchList);
       }

       public void delete(DispatchList dispatchList)
       {
           dispatchListIfa.delete(dispatchList.getId());
       }
    /*   根据用车单位查询*/
       public DispatchList getDispatchList(String d)
       {
          List<DispatchList> dispatchLists=dispatchListIfa.getDispatchList(d);
           return  null;
       }



}
