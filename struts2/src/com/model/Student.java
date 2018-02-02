package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.Session;

import com.tool.HibernateSessionFactory;
import com.tool.Time;
//many to many 
@Entity
public class Student {

	@Id
	@GeneratedValue
	private int sid;
    private String name;
    //------------------------多对多双向外键  三张表--------------------------
    @ManyToMany
    @JoinTable(name="s_t",
    joinColumns={@JoinColumn(name="sid")},
    inverseJoinColumns={@JoinColumn(name="tid")}    		)
    
    private Set<Teacher>teachers;

	public Student() {
		super();
	}

	public Student( String name, Set<Teacher> teachers) {
		this.name = name;
		this.teachers = teachers;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	  public static void main(String[]args)
	    {
	    	 Session session=HibernateSessionFactory.getSession();
				
			 session.getTransaction().begin();

			 Set<Student>students=new HashSet<Student>();
			 Teacher t1=new Teacher();
			 t1.setTid("t11");
			 t1.setName("t1");
			 
			 Teacher t2=new Teacher();
			 t1.setTid("t22");
			 t2.setName("t2");
			 
			 Set<Teacher>teachers=new HashSet<Teacher>();
//			 Set<Teacher>teachers=new HashSet<Teacher>();
			 teachers.add(t1);
			 
			 Student s1=new Student("111",teachers);
			 Student s2=new Student("222",teachers);
			 
			 session.save(t1);
			 session.save(s1);
			 session.save(s2);
//			 students.add(new Student())
			
			 session.getTransaction().commit();
	    }
	    
    
}
