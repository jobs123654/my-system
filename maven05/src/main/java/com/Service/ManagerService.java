package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BaseDao;
import com.Entity.Manager;
import com.Entity.User;

@Service
public class ManagerService {
   @Autowired private BaseDao< Manager> dao;
   
   public void add(Manager manager)
   {
	   dao.save(manager);
   }
   public void update(Manager manager)
   {
	   dao.update(manager);
   }
   public void delete(Manager manager)
   {
	   dao.delete(manager);
   }
   
   public List<Manager> getAll()
   {
	   return (List<Manager>) dao.findAll("Manager");
   }
   public Manager findManager(Manager user)
	 {
		 if(getAll()!=null&&getAll().size()>0)
		 {
			 for(Manager i:getAll())
			 {
				 if(user.equals(i))
				 {
					 return i;
				 }
			 }
		 }
		 return null;
	 }
}
