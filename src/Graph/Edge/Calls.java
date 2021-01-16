package Graph.Edge;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calls extends Edge {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private String call_id = "";
    private String duration = "";

    public Calls (String[] args){
        this.from = args[0];
        this.to = args[1];
        this.call_id = args[2];
        this.date = LocalDate.parse(args[3],formatter);
        this.duration = args[4];
        this.setEdgeKey(call_id);
    }
}
