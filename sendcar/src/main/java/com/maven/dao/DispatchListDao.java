package com.maven.dao;

import com.maven.entity.DispatchList;
import com.maven.ifa.DispatchListIfa;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DispatchListDao {


       @Autowired private DispatchListIfa dispatchListIfa;



      public String getCustomId()
       {
          int c=dispatchListIfa.findAll().size()+1;
           SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy");
           String s="";

           return  simpleDateFormat.format(new Date())+ String.format("%04d", c);
       }

       public  void addOrUpdate(DispatchList dispatchList)
       {

           try {
               if(dispatchList.getId()==null)
               {

                   dispatchList.setId(getCustomId());
                   dispatchList.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
               }
               System.out.println(dispatchList);
               dispatchListIfa.save(dispatchList);
           }catch(RollbackException e)
           {
                   e.printStackTrace();
           }
       }

       public void delete(DispatchList dispatchList)
       {
           dispatchListIfa.delete(dispatchList);
       }
    /*   根据用车单位查询*/
       public DispatchList getDispatchList(String d)
       {
        return  null;
       }

       public List<DispatchList> getAll()
       {
           return  dispatchListIfa.findAllByOrderByIdAsc();
       }
       public List<DispatchList> getDispatchlistBySal(DispatchList dispatchList)
       {
           List<DispatchList> list=new ArrayList<DispatchList>();
           if(dispatchList.getManager()!=null&&!dispatchList.getManager().equals(""))
           {
                  list=dispatchListIfa.findByManagerContains(dispatchList.getManager());
               System.out.println("部门");
           }
          else if(dispatchList.getPeople()!=null&&!dispatchList.getPeople().equals(""))
           {
                list=dispatchListIfa.findByPeopleContains(dispatchList.getPeople());
               System.out.println("随行人员");
           }else{
//               findByManagerAndPeople(dispatchList.getManager(),dispatchList.getPeople());
               list=dispatchListIfa.findAllByOrderByIdAsc();
               System.out.println("全部");
           }


           return list;


       }

       public DispatchList findOneById(String id)
       {
         return  dispatchListIfa.findOneById(id);
       }


}
