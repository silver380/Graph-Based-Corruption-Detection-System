package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Transactions;
import Graph.Graph;
import Graph.Vertex.Accounts;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;
import java.util.*;

public class PhaseThree {
    public static void addAccount(Graph graph){
        for(Vertex a:graph.getHashMap().values()){
            if(a instanceof Accounts){
                ((People) graph.getHashMap().get(((Accounts) a).getSsn())).getAccounts().add((Accounts) a);
            }
        }
    }
    public static void bfs(People badman,Graph graph){
        Queue<Accounts> q = new LinkedList<>();
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        ArrayList<Accounts> used = new ArrayList<>();
        for(Accounts a:badman.getAccounts()){
            a.setVisitColor(Accounts.VISITING);
            a.setDepth(0);
            q.add(a);
        }
        while(!q.isEmpty()){
            Accounts u = q.remove();
            used.add(u);
            for(Edge e: u.edges){
                if(e instanceof Transactions){
                    Accounts  v= ((Accounts) hashMap.get(e.getTo()));
                    if(v.getVisitColor()==Accounts.NOT_VISITED){
                        int depth = u.getDepth()+1;
                        if(depth<=5){
                            for(Accounts a: ((People) hashMap.get(v.getSsn())).getAccounts()) {
                                a.setDepth(depth);
                                a.setVisitColor(Accounts.VISITING);
                                q.add(a);
                            }
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
        addAccount(graph);
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        for(Vertex v: hashMap.values()){
            if(v instanceof People && ((People) v).getWork().equals("قاچاقچی")){
                bfs(((People) v), graph);
            }
        }
    }
}
