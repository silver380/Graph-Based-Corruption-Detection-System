package Graph.Vertex;
import Graph.Edge.Edge;
import java.util.*;
public abstract class Vertex {
    public String key = "";
    public List<Edge> edges = new LinkedList<>();

    public void setKey(String key) {
        this.key = key;
    }
}
