package com.maven.dao;

import com.maven.entity.Manager;
import com.maven.ifa.ManagerIfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerDao {
    @Autowired
  private ManagerIfa managerIfa;
    public Manager findUser(Manager manager)
    {
        List<Manager> list=managerIfa.findAll();
        for(Manager m:list)
        {
            if(m.equals(manager))
            {
             return  m;
            }
        }
     return  null;
    }

    public  boolean isUpdate(Manager m)
    {
        if(findUser(m)!=null)
        {
              managerIfa.saveAndFlush(m);
              return true;
        }
        return false;
    }


}
