package com.maven.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import java.util.UUID;


@Entity
public class User {
/*
    1、用车单位名称
2、单位地址
3、联系电话*/
    @Id
    @GeneratedValue
    private int id;

    private  String unit;

    private  String address;

    private  String phone;

    public User() {
    }

    public User(String unit, String address, String phone) {
        this.unit = unit;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
