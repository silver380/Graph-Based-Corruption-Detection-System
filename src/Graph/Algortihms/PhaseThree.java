package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Transactions;
import Graph.Graph;
import Graph.Vertex.Accounts;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;

import java.util.*;

public class PhaseThree {
    public static void bfs(Accounts badman,Graph graph,ArrayList<People> badmanANDsus){
        Queue<Accounts> q = new LinkedList<>();
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        badman.setVisitColor(1);
        q.add(badman);
        badman.setDepth(0);
        while(!q.isEmpty()){
            Accounts u = q.remove();
            for(Edge e: u.edges){
                if(e instanceof Transactions){
                    Accounts  v= ((Accounts) hashMap.get(e.getTo()));
                    if(v.getVisitColor()==0){
                        v.setVisitColor(1);
                        v.setDepth(u.getDepth()+1);
                        if(v.getDepth()<=6){
                            q.add(v);
                            if (((People) hashMap.get(v.getSsn())).isSuspect == 1) {
                                ((People) hashMap.get(v.getSsn())).isSuspect = 2;
                                badmanANDsus.add((People) hashMap.get(v.getSsn()));
                            }
                        }
                    }
                }
            }
            u.setVisitColor(2);
        }
    }
    public static ArrayList<People> secondCheck(Graph graph){
        ArrayList<People> badmanANDsus = new ArrayList<>();
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        for(Vertex v: hashMap.values()){
            if(v instanceof Accounts && (((People) hashMap.get(((Accounts) v).getSsn())).getWork().equals("قاچاقچی"))){
                badmanANDsus.add((People) hashMap.get(((Accounts) v).getSsn()));
                bfs((Accounts) v, graph, badmanANDsus);
            }
        }
        return badmanANDsus;
    }
}
