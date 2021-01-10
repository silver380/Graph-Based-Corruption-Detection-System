package Graph;
import Graph.Vertex.*;
import Graph.Edge.*;
import java.util.*;

public class Graph {
    private HashMap<String, Vertex> hashMap = new HashMap<>();
//    private HashMap<String, String> IDtoIBan = new HashMap<>();

    public void addVertex(Vertex vertex) {
        System.out.println(vertex.key);
        hashMap.put(vertex.key, vertex);

//        if (vertex instanceof Accounts) {
//            IDtoIBan.put(((Accounts) vertex).getAccount_id(), ((Accounts) vertex).getIban());
//        }
    }

    public void addEdge(Edge edge) {
        System.out.println(edge.edgeKey);
//        String from;
//        if (edge instanceof Transactions)
//            from = IDtoIBan.get(edge.)
//        TODO: transactions ...

        hashMap.get(edge.getFrom()).edges.add(edge);
    }

    public int getSize() {
        return hashMap.size();
    }

    public ArrayList<Vertex> getVertices() {
        return new ArrayList<>(hashMap.values());
    }
}
