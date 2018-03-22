package com.maven.ifa;

import com.maven.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerIfa extends JpaRepository<Manager,String>{

}
