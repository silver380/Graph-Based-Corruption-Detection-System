package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Edge.Ownerships;
import Graph.Edge.Relationships;
import Graph.Graph;
import Graph.Vertex.Cars;
import Graph.Vertex.Homes;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PhaseTwo {
    public static void susFinder(Graph graph){
        HashMap<String, Vertex> hashMap = graph.getHashMap();
        for(Vertex v : hashMap.values()) {
            if (v instanceof People && (((People) v).getWork().equals("گمرک") || ((People) v).getWork().equals("سازمان بنادر"))) {
                List<Edge> edges = v.edges;
                for (Edge e : edges) {
                    if ((e instanceof Ownerships)) {
                        LocalDate today = LocalDate.now();
                        LocalDate difference = e.date.plusYears(2);
                        if(difference.isAfter(today)||difference.isEqual(today)){
                            ((People) v).isSuspect=1;
                            break;
                        }
                    }
                    else if(e instanceof Relationships){
                        List<Edge> childEdges = hashMap.get(e.to).edges;
                        for( Edge ec: childEdges) {
                            if (hashMap.get(ec.to) instanceof Cars || hashMap.get(ec.to) instanceof Homes) {
                                LocalDate today = LocalDate.now();
                                LocalDate difference = ec.date.plusYears(2);
                                if (difference.isAfter(today)||difference.isEqual(today)) {
                                    ((People) v).isSuspect = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
