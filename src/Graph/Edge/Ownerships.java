package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ownerships extends Edge {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String ownerShip = "";
    private String amount = "";

    public Ownerships(String[] args) {
        this.from = args[0];
        this.to = args[1];
        this.ownerShip = args[2];
        this.date = LocalDate.parse(args[3],formatter);
        this.amount = args[4];
        this.setEdgeKey(ownerShip);
    }
}
