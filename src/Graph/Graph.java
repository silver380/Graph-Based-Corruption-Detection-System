package Graph;
import Graph.Vertex.*;
import Graph.Edge.*;
import java.util.*;

public class Graph {
    private HashMap<String, Vertex> hashMap = new HashMap<>();

    public void addVertex(Vertex vertex) {
        System.out.println(vertex.key);
        hashMap.put(vertex.key, vertex);
    }

    public void addEdge(Edge edge) {
        System.out.println(edge.edgeKey);
        hashMap.get(edge.getFrom()).edges.add(edge);
    }
}
