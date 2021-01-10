package Graph.Vertex;

import java.security.ProtectionDomain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class People extends Vertex{
    private static final SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
    private String first_name = "";
    private String last_name = "";
    private String city ="";
    private String work = "";
    private String ssn ="";
    private Date birthday;

    public People(){

    }

    public People(String [] args)  {


        this.first_name = args[0];
        this.last_name = args[1];
        this.city = args[4];
        this.work = args[5];
        this.ssn = args[2];
        try {
            this.birthday = formatter1.parse(args[3]);
        }
        catch (ParseException e){
            System.out.println("date not valid");
        }
        this.setKey(this.ssn);
    }

    public String getSsn() {
        return ssn;
    }
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

    public void setSsn(String ssn) {
        this.ssn = ssn;
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