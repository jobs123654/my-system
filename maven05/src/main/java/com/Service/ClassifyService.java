package com.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BaseDao;
import com.Entity.Classify;

@Service
public class ClassifyService {
 @Autowired
 private BaseDao<Classify> dao;
 public void add(Classify classify)
 {
	 dao.save(classify);
 }
 public List<Classify> getClassifies()
 {
	 return (List<Classify>) dao.findAll("Classify");
 }
 public void delete(Classify classify)
 {
	 dao.delete(classify);
 }
 public void update(Classify baseEntity)
 {
	 
	 dao.update(baseEntity);
 }
 public Classify getClassify(Classify classify)
 {
	 Session session=dao.getSession();
	 return (Classify)session.get(Classify.class,classify.getId() );
 }
 public List<Classify> getClassifies(Classify classify)
 {
   Session session=dao.getSession();
   Query query=session.createQuery("from Classify where fid like :fid ");
   query.setParameter("fid", "%"+classify.getFid()+"%");
   List<Classify> list=query.list();
   return list;
 }
}
