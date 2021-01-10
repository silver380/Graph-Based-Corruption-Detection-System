package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions extends Edge{
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private String Transaction_id = "";
    private String amount = "";

    public Transactions(String [] args) {
        this.from = args[0];
        this.to = args[1];
        this.Transaction_id = args[2];
        try {
            this.date = formatter.parse(args[3]);
        }catch (ParseException e){
            System.out.println("date not valid.");
        }
        this.amount = args[4];
        this.setEdgeKey(Transaction_id);
    }

    public String getTransaction_id() {
        return Transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        Transaction_id = transaction_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
