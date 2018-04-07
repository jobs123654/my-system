package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Secure implements BaseEntity{
  @Id
  @GeneratedValue
  private int id;
  private String name;//保险名称
  private String classify="电子";//保单类型
  private String obj;//保险对象
  private String lit;//保险期限
  
  private String  insuredage;//被保人年龄
  
  private String proclassify;//职业类别
  
  private String supplier;//供应商
  
  private String prolimit;//各职业等级保额限制
  
  private String sa;//特别约定
  
  private String duty;//保险责任和金额
  
  private String notice;//投保须知
   
  private String  cname;//分类id
  
  private int premium;//保费
  
  private String others;//备注
  
  private String  inform;//特别告知 
  
  /**
 * @return the pro_limit
 */

/**
 * @return the sa
 */
public String getSa() {
	return sa;
}

/**
 * @return the prolimit
 */
public String getProlimit() {
	return prolimit;
}

/**
 * @param prolimit the prolimit to set
 */
public void setProlimit(String prolimit) {
	this.prolimit = prolimit;
}

/**
 * @param sa the sa to set
 */
public void setSa(String sa) {
	this.sa = sa;
}

/**
 * @return the others
 */
public String getOthers() {
	return others;
}

/**
 * @param others the others to set
 */
public void setOthers(String others) {
	this.others = others;
}


  
  /**
 * @return the cname
 */
public String getCname() {
	return cname;
}

/**
 * @return the premium
 */
public int getPremium() {
	return premium;
}

/**
 * @param premium the premium to set
 */
public void setPremium(int premium) {
	this.premium = premium;
}

/**
 * @param cname the cname to set
 */
public void setCname(String cname) {
	this.cname = cname;
}


  

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the classify
 */
public String getClassify() {
	return classify;
}

/**
 * @param classify the classify to set
 */
public void setClassify(String classify) {
	this.classify = classify;
}

/**
 * @return the obj
 */
public String getObj() {
	return obj;
}

/**
 * @param obj the obj to set
 */
public void setObj(String obj) {
	this.obj = obj;
}

/**
 * @return the limit
 */

/**
 * @return the insuredage
 */
public String getInsuredage() {
	return insuredage;
}

/**
 * @return the lit
 */
public String getLit() {
	return lit;
}

/**
 * @param lit the lit to set
 */
public void setLit(String lit) {
	this.lit = lit;
}

/**
 * @param insuredage the insuredage to set
 */
public void setInsuredage(String insuredage) {
	this.insuredage = insuredage;
}

/**
 * @return the proclassify
 */
public String getProclassify() {
	return proclassify;
}

/**
 * @param proclassify the proclassify to set
 */
public void setProclassify(String proclassify) {
	this.proclassify = proclassify;
}

/**
 * @return the supplier
 */
public String getSupplier() {
	return supplier;
}

/**
 * @param supplier the supplier to set
 */
public void setSupplier(String supplier) {
	this.supplier = supplier;
}

/**
 * @return the duty
 */
public String getDuty() {
	return duty;
}

/**
 * @param duty the duty to set
 */
public void setDuty(String duty) {
	this.duty = duty;
}

/**
 * @return the notice
 */
public String getNotice() {
	return notice;
}

/**
 * @param notice the notice to set
 */
public void setNotice(String notice) {
	this.notice = notice;
}



/**
 * @return the inform
 */
public String getInform() {
	return inform;
}

/**
 * @param inform the inform to set
 */
public void setInform(String inform) {
	this.inform = inform;
}
  
  
  
 /* private String duty;//保险责任和金额
    private String coverage;//最高保额
     意外伤害医疗最高保额：不超过意外伤害保额的20%；
  *
  *保障额度：
	意外身故、伤残：10万-100万
	意外医疗（门诊/急诊/住院）:保额<=20%意外身故保额
*/  
  
  
}
