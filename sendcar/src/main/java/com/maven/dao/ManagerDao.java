package com.maven.dao;

import com.maven.entity.Manager;
import com.maven.entity.User;
import com.maven.ifa.ManagerIfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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

    public void addManager (Manager manager)
    {
        managerIfa.save(manager);
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
