package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ownerships extends Edge {
    private static final SimpleDateFormat formatter = new SimpleDateFormat();
    private String ownerShip = "";
    private String amount = "";

    public Ownerships(String[] args) {
        this.from = args[0];
        this.to = args[1];
        this.ownerShip = args[2];
        try {
            this.date = formatter.parse( args[3] );
        }catch (ParseException e){
            System.out.println("date not valid.");
        }
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
