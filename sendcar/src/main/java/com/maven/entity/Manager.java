package com.maven.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Manager {

    @Id
    @GeneratedValue
    private  int id;

    private  String name;

    private String password;

    public Manager(String name, String password) {
        this.name = name;
        this.password = password;
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
