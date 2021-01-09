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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
