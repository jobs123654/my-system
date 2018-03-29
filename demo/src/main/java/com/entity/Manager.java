package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    //一对多查询
    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<User> list=new ArrayList<>();

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
