package Graph.Algortihms;

import Graph.Edge.Edge;
import Graph.Graph;
import Graph.Vertex.Cars;
import Graph.Vertex.Homes;
import Graph.Vertex.People;
import Graph.Vertex.Vertex;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PhaseTwo {
    public ArrayList<Vertex> susFinder(Graph g){
        ArrayList<Vertex> sus = new ArrayList<>();
        HashMap<String, Vertex> hashMap = g.getHashMap();
        for(Vertex v : hashMap.values()) {
            if (v instanceof People && (((People) v).getWork().equals("گمرک") || ((People) v).getWork().equals("سازمان بنادر"))) {
                List<Edge> edges = v.edges;
                for (Edge e : edges) {
                    if ((hashMap.get(e.to) instanceof Cars) || (hashMap.get(e.to) instanceof Homes)) {
                        LocalDateTime today = LocalDateTime.now();
                        LocalDateTime difference = e.date.plusYears(2);
                        if(difference.isAfter(today)){
                            ((People) v).isSuspect=true;
                            sus.add(v);
                            break;
                        }
                    }
                    else if(hashMap.get(e.to) instanceof People){
                        List<Edge> childEdges = hashMap.get(e.to).edges;
                        boolean isSus = false;
                        for( Edge ec: childEdges){
                            if(hashMap.get(ec.to) instanceof Cars || hashMap.get(ec.to) instanceof Homes){
                                LocalDateTime today = LocalDateTime.now();
                                LocalDateTime difference = ec.date.plusYears(2);
                                if(difference.isAfter(today)){
                                    isSus=true;
                                    ((People) v).isSuspect=true;
                                    sus.add(v);
                                    break;
                                }
                            }
                        }
                        if(isSus){
                            break;
                        }
                    }
                }

            }
        }
        return sus;
    }

}
