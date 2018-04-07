package com.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BaseDao;
import com.Entity.Classify;
import com.Entity.Secure;
@Service
public class SecureService {
  @Autowired private BaseDao<Secure> dao;
  public void add(Secure secure)
  {
	  dao.save(secure);
  }
  public void delete(Secure secure)
  {
	  dao.delete(secure);
  }
  public void update(Secure secure)
  {
	  dao.update(secure);
  }
  public Secure getSecure(Secure secure)
  {
	  return (Secure)dao.getSession().get(Secure.class, secure.getId());
  }
  public List<Secure>getSecures()
  {
	  return (List<Secure>) dao.findAll("Secure");
  }
  
  /*根据分类名称获取*/
	public List<Secure> getSecures(Secure secure) {
		Session session=dao.getSession();
		Query query=session.createQuery("from Secure where cname like :fid ");
		   query.setParameter("fid", "%"+secure.getCname()+"%");
		   List<Secure> list=query.list();
		session.close();
		return list;
	}
	public Secure getSecureById(Secure secure) {
		Session session=dao.getSession();
		  Secure secure2=(Secure) session.get(Secure.class, secure.getId());
		session.close();
		return secure2;
	}
	  /*private String name;//保险名称
	  private String classify="电子";//保单类型
	  private String obj;//保险对象
	  private String lit;//保险期限
	  
	  private String  insuredage;//被保人年龄
	  
	  private String proclassify;//职业类别
	  private String supplier;//供应商
	  private String duty;//保险责任和金额
	  private String notice;//投保须知
	   
	  private String  cname;//分类id
*/	 /*筛选保险*/
	@SuppressWarnings("deprecation")
	public List<Secure> choiceSecure(Secure secure)
	{
		Session session=dao.getSession();
		String s="from Secure where id>0";
		Query query=null;
		if(secure.getSupplier()!=null)
		{
			s+=" and supplier like :supplier";
			query=session.createQuery(s);
			query.setParameter("supplier", "%"+secure.getSupplier()+"%");
		}else{
			query=session.createQuery(s);	
		}
		List<Secure> list=(List<Secure>)query.list();
		System.out.println(list);
		return list;
	}
}
