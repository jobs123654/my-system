package com.maven.dao;

import com.maven.entity.User;
import com.maven.ifa.UserIfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
    @Autowired private UserIfa userIfa;

    public void addUser(User user)
    {
     userIfa.save(user);
    }
}
