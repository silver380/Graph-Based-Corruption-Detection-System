package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calls extends Edge {
    //TODO: add variabales
    private static final SimpleDateFormat formatter = new SimpleDateFormat();
    private String call_id = "";
    private String duration = "";

    public Calls (String[] args){
        this.from = args[0];
        this.to = args[1];
        this.call_id = args[2];
        try {
            this.date = formatter.parse( args[3] );
        }catch (ParseException e){
            System.out.println("date not valid.");
        }
        this.duration = args[4];
        this.setEdgeKey(call_id);
    }


    public String getCall_id() {
        return call_id;
    }

    public void setCall_id(String call_id) {
        this.call_id = call_id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
