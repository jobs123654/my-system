package com.maven.dao;

import com.maven.entity.Department;
import com.maven.ifa.DepartmentIfa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentDao {

    @Autowired private DepartmentIfa departmentIfa;
    public  void add(Department department)
    {
    departmentIfa.save(department);
    }

    public  void delete(Department department)
    {
           departmentIfa.delete(department);
    }

    public void update(Department department)
    {
        departmentIfa.saveAndFlush(department);
    }

    public List<Department> findAll()
    {

        return  departmentIfa.findAll();
    }
}
