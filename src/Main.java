import Graph.*;
import Graph.Algortihms.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        IO.Input.getInput(graph);
        PhaseTwo.susFinder(graph);

        IO.Output_Table.show(graph);
        IO.Output.draw(graph);
    }
}
