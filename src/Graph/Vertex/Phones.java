package Graph.Vertex;

public class Phones extends Vertex{
    private String ssn = "";
    private String number = "";
    private String operator ="";

    public Phones(String [] args) {
        this.ssn = args[0];
        this.number = args[1];
        this.operator = args[2];
        this.setKey(this.number);
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
