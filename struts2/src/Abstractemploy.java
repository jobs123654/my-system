// default package



/**
 * Abstractemploy entity provides the base persistence definition of the employ entity. @author MyEclipse Persistence Tools
 */

public abstract class Abstractemploy  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String uname;
     private String role;
     private Integer aid;


    // Constructors

    /** default constructor */
    public Abstractemploy() {
    }

    
    /** full constructor */
    public Abstractemploy(String uname, String role, Integer aid) {
        this.uname = uname;
        this.role = role;
        this.aid = aid;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return this.uname;
    }
    
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAid() {
        return this.aid;
    }
    
    public void setAid(Integer aid) {
        this.aid = aid;
    }
   








}