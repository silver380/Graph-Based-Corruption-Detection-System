package Graph.Vertex;

public class Cars extends Vertex {
    //TODO: add variable
    private String plate = "";
    private String ssn = "";
    private String model ="";
    private String color = "";

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
}
