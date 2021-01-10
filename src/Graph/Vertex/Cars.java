package Graph.Vertex;

public class Cars extends Vertex {
    private String plate = "";
    private String ssn = "";
    private String model ="";
    private String color = "";

    public Cars() {
    }

    public Cars(String [] args) {
        this.plate = args[0];
        this.ssn = args[1];
        this.model = args[2];
        this.color = args[3];
        this.setKey(plate);
    }

    public String getPlate(){
        return this.plate;
    }
    public  String getSsn(){
        return this.ssn;
    }
    public String getColor(){
        return this.color;
    }
    public String getModel(){
        return this.model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
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
