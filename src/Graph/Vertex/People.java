package Graph.Vertex;

import javax.swing.text.DateFormatter;
import java.security.ProtectionDomain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class People extends Vertex{
    public static final int NOTSUS=0;
    public static final int SUS1=1;
    public static final int SUS2=2;
    public static final int SUS3=3;
    public static final boolean SUSCALL = true;
    public static final boolean NOTSUSCALL = false;
    public static final boolean SUSOWNERSHIP= true;
    public static final boolean NOTSUSOWNERSHIP = false;
    public static final int NOT_VISITED = 0;
    public static final int VISITING = 1;
    public static final int VISITED = 2;
    private int visitColor = NOT_VISITED;
    public int isSuspect=NOTSUS;
    private int depth =0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    private String first_name = "";
    private String last_name = "";
    private String city = "";
    private String work = "";
    private String ssn = "";
    private LocalDate birthday;
    private boolean susOwnership = NOTSUSOWNERSHIP;
    private boolean susCall = NOTSUSCALL;
    private Set<People> accounts = new HashSet<>();
    public People(){

    }

    public People(String [] args)  {
        this.first_name = args[0];
        this.last_name = args[1];
        this.city = args[4];
        this.work = args[5];
        this.ssn = args[2];
        this.birthday = LocalDate.parse(args[3],formatter);
        this.setKey(this.ssn);
    }

    public String getWork(){
        return this.work;
    }
    public LocalDate getBirthday(){
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

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSusOwnership() {
        return susOwnership;
    }

    public void setSusOwnership(boolean susOwnership) {
        this.susOwnership = susOwnership;
    }

    public boolean isSusCall() {
        return susCall;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSusCall(boolean susCall) {
        this.susCall = susCall;
    }
    public int getVisitColor() {
        return visitColor;
    }

    public void setVisitColor(int visitColor) {
        this.visitColor = visitColor;
    }
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Set<People> getAccounts() {
        return accounts;
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