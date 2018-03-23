package com.maven.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {

    @Id
    @GeneratedValue
    private  int id;

    private  String name;

    private String password;


    private  String unit;

    private  String address;

    private  String phone;

     @OneToMany                                          //指定一对多关系
     @Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})         //设定级联关系
     @JoinColumn(name="mid")                       //指定与本类主键所对应的外表的外键
     @Transient

    private Set<Department> departments=new HashSet<Department>();

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private  int role=0;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        Manager manager=(Manager)obj;
        return manager.getName().equals(name)&&manager.getPassword().equals(password);
    }
}
