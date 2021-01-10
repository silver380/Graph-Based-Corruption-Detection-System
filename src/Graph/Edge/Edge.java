package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Edge {
    public String edgeKey = "";
    public String from = "";
    public String to = "";
    public LocalDateTime date;


    public void setEdgeKey(String edgeKey) {
        this.edgeKey = edgeKey;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getEdgeKey() {
        return edgeKey;
    }
}
