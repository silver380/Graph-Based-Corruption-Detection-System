package Graph.Edge;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Relationships extends Edge {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String relation = "";

    public Relationships(String [] args) {
        this.from = args[0];
        this.to = args[1];
        this.relation = args[2];
        this.date = LocalDate.parse(args[3],formatter);
        this.setEdgeKey(from + to);
    }
}
