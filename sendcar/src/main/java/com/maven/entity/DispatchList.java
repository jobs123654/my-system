package com.maven.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.naming.Name;
import javax.persistence.*;
import javax.sound.midi.Soundbank;
import javax.validation.constraints.Max;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "dispatchlist")
public class DispatchList {
            /*1、序号（年+4位序号）

            2、用车部门（下拉菜单）
            3、用车人员（输入汉字最多10个）
            4、办事地点（输入汉字最多50个）
            5、事由（输入汉字最多50个）
            6、出车时间（日期和时间，点选精确到分钟）
            7、用车时间（输入数字，单位为小时，保留1位小数）
            8、行驶里程(输入数字，单位为公里，保留1位小数)
            9、经办人（登陆用户）
            10、办理日期（点选，需要判断一下，日期不能早于最后一个单据的日期）*/
            @Id
            @GeneratedValue(generator = "id")
            @GenericGenerator(name = "id",strategy = "assigned")

            @Column(unique = true,length = 8)
  private String id;

  private String dep;

  @Override
  public String toString() {
    return "DispatchList{" +
            "id='" + id + '\'' +
            ", dep='" + dep + '\'' +
            ", people='" + people + '\'' +
            ", address='" + address + '\'' +
            ", reason='" + reason + '\'' +
            ", gotime='" + gotime + '\'' +
            ", time=" + time +
            ", length=" + length +
            ", manager='" + manager + '\'' +
            ", date='" + date + '\'' +
            '}';
  }


  private String people;


  private  String address;

  private  String reason;

  private  String gotime;

  private float time;

  private float length;

  private String manager;

  private  String date=new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date());


  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }



  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  public String getPeople() {
    return people;
  }

  public void setPeople(String people) {
    this.people = people;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getGotime() {
    return gotime;
  }

  public void setGotime(String gotime) {
    this.gotime = gotime;
  }

  public float getTime() {
    return time;
  }

  public void setTime(float time) {
    this.time = time;
  }

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }

  public String getManager() {
    return manager;
  }

  public void setManager(String manager) {
    this.manager = manager;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
