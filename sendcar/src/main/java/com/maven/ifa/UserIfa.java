package com.maven.ifa;

import com.maven.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserIfa extends JpaRepository<User,Integer>{
}
