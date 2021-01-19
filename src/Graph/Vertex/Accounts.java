package Graph.Vertex;

public class Accounts extends Vertex {
    private String ssn ="";
    private String bank_name = "";
    private String account_id="";
    private String iban ="";

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
