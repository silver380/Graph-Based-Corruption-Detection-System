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

    @Override
    public String toString() {
        return "Phones{" +
                "ssn='" + ssn + '\'' +
                ", number='" + number + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
