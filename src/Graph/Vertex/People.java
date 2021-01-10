package Graph.Vertex;

import java.security.ProtectionDomain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class People extends Vertex{
    //TODO: isSuspect must show a degree
    public boolean isSuspect;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String first_name = "";
    private String last_name = "";
    private String city ="";
    private String work = "";
    private String ssn ="";
    private LocalDateTime birthday;

    public People(){

    }

    public People(String [] args)  {

        // Todo: remove
        if (Math.random() <0.5)
            isSuspect = true;

        this.first_name = args[0];
        this.last_name = args[1];
        this.city = args[4];
        this.work = args[5];
        this.ssn = args[2];
        this.birthday = LocalDateTime.parse(args[3],formatter);
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
    public LocalDateTime getBirthday(){
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

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "People{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", work='" + work + '\'' +
                ", ssn='" + ssn + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}