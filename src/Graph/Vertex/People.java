package Graph.Vertex;

import java.security.ProtectionDomain;
import java.util.Date;

public class People extends Vertex{
//TODO: add variable
    private String first_name = "";
    private String last_name = "";
    private String city ="";
    private String work = "";
    private Date birthday;

    public String getFirst_name(){
        return this.first_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public String getCity(){
        return this.city;
    }
    public String getWork(){
        return this.work;
    }
    public Date getBirthday(){
        return this.birthday;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}