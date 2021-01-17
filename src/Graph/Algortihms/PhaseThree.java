package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Transactions;
import Graph.Graph;
import Graph.Vertex.Accounts;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;
import java.util.*;

public class PhaseThree {
    public static void bfs(Accounts badman,Graph graph){
        Queue<Accounts> q = new LinkedList<>();
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        ArrayList<Accounts> used = new ArrayList<>();
        badman.setVisitColor(Accounts.VISITING);
        q.add(badman);
        badman.setDepth(0);
        while(!q.isEmpty()){
            Accounts u = q.remove();
            used.add(u);
            for(Edge e: u.edges){
                if(e instanceof Transactions){
                    Accounts  v= ((Accounts) hashMap.get(e.getTo()));
                    if(v.getVisitColor()==Accounts.NOT_VISITED){
                        v.setVisitColor(Accounts.VISITING);
                        v.setDepth(u.getDepth()+1);
                        if(v.getDepth()<=5){
                            q.add(v);
                            if (((People) hashMap.get(v.getSsn())).isSuspect == People.SUS1) {
                                ((People) hashMap.get(v.getSsn())).isSuspect = People.SUS2;
                                graph.getBadmanANDsus().add((People) hashMap.get(v.getSsn()));
                            }
                        }
                    }
                }
            }
            u.setVisitColor(Accounts.VISITED);
        }
        for(Accounts u: used){
            u.setVisitColor(Accounts.NOT_VISITED);
        }
    }
    public static void secondCheck(Graph graph){
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        for(Vertex v: hashMap.values()){
            if(v instanceof Accounts && (((People) hashMap.get(((Accounts) v).getSsn())).getWork().equals("قاچاقچی"))){
                bfs((Accounts) v, graph);
            }
        }
    }
}
