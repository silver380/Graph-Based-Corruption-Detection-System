package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Relationships extends Edge {
    private static final SimpleDateFormat formatter = new SimpleDateFormat();
    private String relation = "";

    public Relationships(String [] args) {
        this.from = args[0];
        this.to = args[1];
        this.relation = args[2];
        try {
            this.date = formatter.parse(args[3]);
        }catch (ParseException e){
            System.out.println("date not valid.");
        }
        this.setEdgeKey(from + to);
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
