package com.maven.ifa;

import com.maven.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentIfa extends JpaRepository<Department,String>{

}
