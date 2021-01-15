package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Ownerships;
import Graph.Edge.Relationships;
import Graph.Graph;
import Graph.Vertex.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PhaseTwo {
    public static void FindSusOwnerships(Graph graph) {
        //TODO: make it like calls ?
        for(Vertex v: graph.getHashMap().values()){
            if(v instanceof People) {
                for (Edge e : v.edges) {
                    if (e instanceof Ownerships) {
                        LocalDate today = LocalDate.now();
                        LocalDate difference = e.date.plusYears(2);
                        if (difference.isAfter(today) || difference.isEqual(today)) {
                            ((People) v).setSusOwnership(People.SUSOWNERSHIP);
                            break;
                        }
                    }
                }
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
