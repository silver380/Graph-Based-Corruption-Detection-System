package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Relationships;
import Graph.Graph;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;

import java.time.LocalDate;
import java.util.HashMap;

public class PhaseTwo {
    public static void FindSusOwnerships(Graph graph) {
        for (Edge o : graph.getOwnerships()) {
            LocalDate today = LocalDate.now();
            LocalDate difference = o.date.plusYears(4);
            if (difference.isAfter(today) || difference.isEqual(today)) {
                ((People) graph.getHashMap().get(o.getFrom())).setSusOwnership(People.SUSOWNERSHIP);
            }
        }
    }
    public static void susFinder(Graph graph){
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        FindSusOwnerships(graph);
        for(Vertex v : hashMap.values()) {
            if (v instanceof People && (((People) v).getWork().equals("گمرک") || ((People) v).getWork().equals("سازمان بنادر"))) {
                if(((People) v).isSusOwnership()){
                    ((People) v).isSuspect=People.SUS1;
                }
                else{
                    for(Edge e: v.edges){
                        if(e instanceof Relationships && ((People) hashMap.get(e.getTo())).isSusOwnership()){
                            ((People) v).isSuspect=People.SUS1;
                            break;
                        }
                    }
                }
            }
        }
    }
}
