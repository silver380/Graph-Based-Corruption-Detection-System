package Graph.Vertex;

public class Homes extends Vertex {
    private String ssn = "";
    private String price = "";
    private String address = "";
    private String postal_code = "";
    private long size=0;

    public Homes(String [] args) {
        this.ssn = args[0];
        this.price = args[1];
        this.postal_code = args[2];
        this.address = args[4];
        this.size = Long.parseLong(args[3]);
        this.setKey(postal_code);
    }

    @Override
    public String toString() {
        return "Homes{" +
                "ssn='" + ssn + '\'' +
                ", price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", size=" + size +
                '}';
    }
}
