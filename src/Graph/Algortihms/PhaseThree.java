package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Transactions;
import Graph.Graph;
import Graph.Vertex.Accounts;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;
import java.util.*;

public class PhaseThree {
    public static void bfs(People badman,Graph graph){
        Queue<People> q = new LinkedList<>();
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        ArrayList<People> used = new ArrayList<>();
        badman.setDepth(0);
        q.add(badman);
        badman.setVisitColor(People.VISITING);
        while(!q.isEmpty()){
            People u = q.remove();
            used.add(u);
            for(People p: u.getAccounts()){
                    if(p.getVisitColor()==People.NOT_VISITED){
                        int depth = u.getDepth()+1;
                        if(depth<=5){
                            p.setDepth(depth);
                            q.add(p);
                            p.setVisitColor(People.VISITING);
                            if(p.isSuspect==People.SUS1){
                                p.isSuspect=People.SUS2;
                                graph.getBadmanANDsus().add(p);
                            }
                        }
                    }
            }
            u.setVisitColor(People.VISITED);
        }
        for(People u: used){
            u.setVisitColor(People.NOT_VISITED);
        }
    }
    public static void secondCheck(Graph graph){
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        for(Vertex v: hashMap.values()){
            if(v instanceof People && ((People) v).getWork().equals("قاچاقچی")){
                bfs(((People) v), graph);
            }
        }
    }
}
