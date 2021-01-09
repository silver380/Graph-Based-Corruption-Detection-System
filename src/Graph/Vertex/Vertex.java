package Graph.Vertex;
import Graph.Edge.Edge;
import java.util.*;
public abstract class Vertex {
    //TODO: add variable
    public String key = "";
    public List<Edge> edges = new LinkedList<>();
    public String getKey(){
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
