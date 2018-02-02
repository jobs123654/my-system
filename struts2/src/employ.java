import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tool.HibernateSessionFactory;

// default package



/**
 * employ entity. @author MyEclipse Persistence Tools
 */
public class employ extends Abstractemploy implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public employ() {
    }

    
    /** full constructor */
    public employ(String uname, String role, Integer aid) {
        super(uname, role, aid);        
    }
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    /**
     * @param srStrings
     */
    public static void main(String[] srStrings)
    {
    	
    	try {
    		SessionFactory sessionFactory=HibernateSessionFactory. getSessionFactory();
        	Session session=HibernateSessionFactory.getSession();
        	org.hibernate.Transaction transaction=session.beginTransaction();
        	
    		
		
        	System.out.print("---------");
        
        	        employ em=new employ();
        	        em.setRole("33");
        			em.setUname("3333");
        	        session.save(em);
        	transaction.commit();
        	List<employ> employs=session.createQuery("from employ").list();
        	System.out.print("---------"+employs.size());	
		} catch (Exception e) {
			System.out.print("---------");
			e.printStackTrace();
			// TODO: handle exception
		}
    	
    }
   
}
