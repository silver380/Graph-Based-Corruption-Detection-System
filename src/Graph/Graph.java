package Graph;
import Graph.Vertex.*;
import Graph.Edge.*;
import java.util.*;

public class Graph {
    private HashMap<String, Vertex> hashMap = new HashMap<>();
    private ArrayList<Edge> calls = new ArrayList<>();
    private ArrayList<People> badmanANDsus = new ArrayList<>();
    private ArrayList<Edge> ownerships = new ArrayList<>();

    public void addVertex(Vertex vertex) {
        hashMap.put(vertex.key, vertex);
    }

    public void addEdge(Edge edge) {
        if (edge instanceof Calls) {
            calls.add(edge);
        }
        else if(edge instanceof Ownerships) {
            ownerships.add(edge);
        }
        else if(edge  instanceof Transactions){
            Accounts vFrom = ((Accounts) hashMap.get(edge.getFrom()));
            Accounts vTo = ((Accounts) hashMap.get((edge.getTo())));
            ((People) hashMap.get(vFrom.getSsn())).getAccounts().add(((People) hashMap.get(vTo.getSsn())));
        }

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

    public ArrayList<People> getBadmanANDsus() {
        return badmanANDsus;
    }

    public ArrayList<Edge> getOwnerships() {
        return ownerships;
    }

    public void setBadmanANDsus(ArrayList<People> badmanANDsus) {
        this.badmanANDsus = badmanANDsus;
    }
}
