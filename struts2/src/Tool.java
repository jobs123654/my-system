import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//注解
@Entity
@Table(name="tool",schema="gishome")


public class Tool {
   private int id;
   private String nameString;
   private String classifyString;
   private Date cDate;
   
public Tool() {
//	super();
}

public Tool(int id, String nameString, String classifyString, Date cDate) {
	super();
	this.id = id;
	this.nameString = nameString;
	this.classifyString = classifyString;
	this.cDate = cDate;
}
@Id
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNameString() {
	return nameString;
}

public void setNameString(String nameString) {
	this.nameString = nameString;
}

public String getClassifyString() {
	return classifyString;
}

public void setClassifyString(String classifyString) {
	this.classifyString = classifyString;
}

public Date getcDate() {
	return cDate;
}

public void setcDate(Date cDate) {
	this.cDate = cDate;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
//	return super.toString();
	String s="id"+id+"  name:"+nameString;
	System.out.print(s);
	return s;
}
   
}
