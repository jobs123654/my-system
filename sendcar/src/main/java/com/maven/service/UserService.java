package com.maven.service;

import com.maven.entity.User;
import com.maven.ifa.UserIfa;
import com.sun.org.apache.xml.internal.serializer.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserIfa u;

    @Transactional
  public void insert(User user){
   u.save(user);
   }

   @Transactional
    public void delete(User user)
   {
       u.delete(user);
   }

   @Transactional
    public void update(User user)
   {
       u.saveAndFlush(user);
   }

   public List<User> getLists()
   {
       return  u.findAll();
   }

   public  User getUser(int id)
   {
     for(User user:getLists())
     {
         if(user.getId()==id)
         {
             return  user;
         }
     }
     return null;
   }
}
