package Graph.Vertex;

public class Accounts extends Vertex {
    private String ssn ="";
    private String bank_name = "";
    private String account_id="";
    private String iban ="";
    private int visitColor = 0;
    private int depth =0;

    public Accounts() {
    }

    public Accounts(String [] args) {
        this.ssn = args[0];
        this.bank_name = args[1];
        this.account_id = args[3];
        this.iban = args[2];
        this.setKey(this.account_id);
    }

    public String getIban() {
        return iban;
    }

    public String getSsn(){
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBank_name() {
        return this.bank_name;
    }

    public String getAccount_id(){
        return this.account_id;
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
