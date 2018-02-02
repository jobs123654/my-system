package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Teacher {
@Id
@GeneratedValue(generator="tid")
@GenericGenerator(name="tid",strategy="assigned")
@Column(length=4) 
private String tid;

 private String name;

 @ManyToMany(mappedBy="teachers")
 private Set<Student> students;
 

public String getTid() {
	return tid;
}

public void setTid(String tid) {
	this.tid = tid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}



public Teacher() {
	super();
}

public Teacher(String tid, String name) {
	super();
	this.tid = tid;
	this.name = name;
}
 
}
