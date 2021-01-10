package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        this.date = LocalDateTime.parse(args[3],formatter);
        this.amount = args[4];
        this.setEdgeKey(ownerShip);
    }
    public String getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(String ownerShip) {
        this.ownerShip = ownerShip;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
