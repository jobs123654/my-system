package com.Service;

import java.util.List;

import org.hibernate.Session;
import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.BaseDao;
import com.Entity.BaseEntity;
import com.Entity.User;
@Service(value="service")
public class UserService {
 @Autowired
 private BaseDao dao;

 public void add(User user)
 {
	dao.save(user);
 }
 public void update(User user)
 {
	 dao.update(user);
 }
 /**
 * @return the dao
 */
public BaseDao getDao() {
	return dao;
}
public void delete(User user)
{
	user=(User) dao.getBaseEntity(user);
	dao.delete(user);
}
/**
 * @param dao the dao to set
 */
public void setDao(BaseDao dao) {
	this.dao = dao;
}
public List<User> getAll()
 {
	List<User> list=(List<User>) dao.findAll("User");
	return  list;
 }
	public User getUser(User user)
	{
		return (User) dao.getBaseEntity(user);
	}
	
	 public List<User> getUserByName(User user)
	 {
		 Session session=dao.getSession();
		 return session.createQuery("from User where name like '%"+user.getName()+"%'").list();
	 }
	 public User findUser(User user)
	 {
		 if(getAll()!=null&&getAll().size()>0)
		 {
			 for(User i:getAll())
			 {
				 if(user.equals(i))
				 {
					 return i;
				 }
			 }
		 }
		 return null;
	 }
	 
	 public void clear()
	 {
		 dao.clear();
	 }
}
