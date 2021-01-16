package Graph.Vertex;

public class Cars extends Vertex {
    private String plate = "";
    private String ssn = "";
    private String model ="";
    private String color = "";

    public Cars(String [] args) {
        this.plate = args[0];
        this.ssn = args[1];
        this.model = args[2];
        this.color = args[3];
        this.setKey(plate);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "plate='" + plate + '\'' +
                ", ssn='" + ssn + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
