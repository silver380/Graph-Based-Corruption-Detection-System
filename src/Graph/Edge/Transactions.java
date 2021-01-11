package Graph.Edge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Transactions extends Edge{
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String Transaction_id = "";
    private String amount = "";

    public Transactions(String [] args) {
        this.from = args[0];
        this.to = args[1];
        this.Transaction_id = args[2];
        this.date = LocalDate.parse(args[3],formatter);
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
