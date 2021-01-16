package Graph.Vertex;

public class Accounts extends Vertex {
    public static final int NOT_VISITED = 0;
    public static final int VISITING = 1;
    public static final int VISITED = 2;
    private String ssn ="";
    private String bank_name = "";
    private String account_id="";
    private String iban ="";
    private int visitColor = NOT_VISITED;
    private int depth =0;

    public Accounts(String [] args) {
        this.ssn = args[0];
        this.bank_name = args[1];
        this.account_id = args[3];
        this.iban = args[2];
        this.setKey(this.account_id);
    }

    public String getSsn(){
        return this.ssn;
    }

    public int getVisitColor() {
        return visitColor;
    }

    public void setVisitColor(int visitColor) {
        this.visitColor = visitColor;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "ssn='" + ssn + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", account_id='" + account_id + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
