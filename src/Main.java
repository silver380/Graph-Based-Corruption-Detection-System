import Graph.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("");
        Graph graph = new Graph();
        IO.Input.getInput(graph);
        IO.Output_Table.show(graph, false);
    }
}