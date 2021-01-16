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
            Phones vFrom = (Phones) graph.getHashMap().get(c.getFrom());
            Phones vTo = ((Phones) graph.getHashMap().get(c.getTo()));
            if (((People) graph.getHashMap().get(vFrom.getSsn())).getWork().equals("قاچاقچی")){
                if(!((People) graph.getHashMap().get(vTo.getSsn())).isSusCall()) {
                    ((People) graph.getHashMap().get(vTo.getSsn())).setSusCall(People.SUSCCALL);
                }
            }
            else if(((People) graph.getHashMap().get(vTo.getSsn())).getWork().equals("قاچاقچی")){
                if(!((People) graph.getHashMap().get(vFrom.getSsn())).isSusCall()) {
                    ((People) graph.getHashMap().get(vFrom.getSsn())).setSusCall(People.SUSCCALL);
                }
            }
        }
    }
    public static void thirdCheck (Graph graph){
        susCallFinder(graph);
        for (People p : graph.getBadmanANDsus()) {
            if(p.isSusCall()){
                p.isSuspect = People.SUS3;
            }
        }
    }
}
