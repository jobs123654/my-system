package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class User {
   @Id
   @GenericGenerator(name = "id",strategy = "assigned")
    @GeneratedValue(generator = "id")
    private  String id;

    private String address;

    private  String phone;



    @ManyToOne(targetEntity = Manager.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "mid",foreignKey = @ForeignKey(name = "mid"))
    private  Manager manager;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone ;
    }



    public User(String address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public Manager getManager() {
        return manager;
    }

    public User() {

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
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
