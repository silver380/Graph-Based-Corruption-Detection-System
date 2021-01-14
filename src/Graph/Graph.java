package Graph;
import Graph.Vertex.*;
import Graph.Edge.*;
import java.util.*;

public class Graph {
    private HashMap<String, Vertex> hashMap = new HashMap<>();
    private ArrayList<Edge> calls = new ArrayList<>();

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

        if (edge instanceof Calls)
            calls.add(edge);

        hashMap.get(edge.getFrom()).edges.add(edge);
    }

    public ArrayList<Edge> getCalls() {
        return calls;
    }

    public int getSize() {
        return hashMap.size();
    }

    public HashMap<String, Vertex> getHashMap() {
        return hashMap;
    }

    public ArrayList<Vertex> getVertices() {
        return new ArrayList<>(hashMap.values());
    }

}
