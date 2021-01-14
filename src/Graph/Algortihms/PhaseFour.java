package Graph.Algortihms;

import Graph.Edge.Calls;
import Graph.Edge.Edge;
import Graph.Graph;
import Graph.Vertex.Accounts;
import Graph.Vertex.People;
import Graph.Vertex.Phones;

public class PhaseFour {
    public static void susCallFinder (Graph graph){
        for (Edge c : graph.getCalls()) {
            Phones v = (Phones) graph.getHashMap().get(c.getFrom());
            if (((People) graph.getHashMap().get(v.getSsn())).getWork().equals("قاچاقچی")){
                Phones vTo = ((Phones) graph.getHashMap().get(c.getTo()));
                ((People) graph.getHashMap().get(v.getSsn())).setSusCall(true);
            }
        }
    }

    public static void thirdCheck (Graph graph){
        susCallFinder(graph);

    }
}
